package jellypins.org.data.utils.base

import android.util.Log
import jellypins.org.data.model.Response
import jellypins.org.domain.utils.ErrorType
import jellypins.org.domain.utils.RemoteErrorEmitter
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException

/**
 * packageName    : jellypins.org.data.utils.base
 * fileName       : BaseApiRepository
 * author         : syshinpins
 * date           : 2022/06/06
 * description    : BaseRepository를 상속받아 RestApi 기본 응답 처리에 Api 공통 처리 로직을 추가한 추상 클래스
 * ========================================================================================
 * VERSION      DATE             AUTHOR             NOTE
 * ----------------------------------------------------------------------------------------
 * 0.0.0        2022-06-06       syshinpins         최초 생성
 */
abstract class BaseApiRepository : BaseRepository(){
    companion object {
        const val TAG = "BaseRepository"
        private const val MESSAGE_KEY = "message"
        private const val ERROR_KEY = "error"
    }

    /**
     * API 요청 응답의 공통 코드 처리 메소드
     * @param T : 응답 데이터 모델 타입
     * @param emitter : 에러처리
     * @param body : 응답 데이터
     * @return : 처리 결과 데이터 (null = 에러)
     */
    suspend inline fun <T> apiResult(emitter: RemoteErrorEmitter, body : T): T? {
        return try {
            val gson = Gson()
            val json = gson.toJson(body)
            val response = gson.fromJson(json, Response::class.java)
            when(response?.code) {
                "100" -> { body }
                else -> {
                    withContext(Dispatchers.Main) {
                        Log.e(TAG, "api error: ${response.result}, ${response.code}, ${response.Message}")
                        emitter.onError(response.Message)
                        null
                    }
                }
            }
        } catch (e:Exception) {
            withContext(Dispatchers.Main) {
                e.printStackTrace()
                Log.e(TAG, "Call error: ${e.localizedMessage}", e.cause)
                when(e) {
                    is HttpException -> {
                        if(e.code() == 401) emitter.onError(ErrorType.SESSION_EXPIRED)
                        else {
                            val body = e.response()?.errorBody()
                            emitter.onError(getErrorMessage(body))
                        }
                    }

                    is SocketTimeoutException -> emitter.onError(ErrorType.TIMEOUT)
                    is IOException -> emitter.onError(ErrorType.NETWORK)
                    else -> emitter.onError(ErrorType.UNKNOWN)
                }
            }
            null
        }
    }
}