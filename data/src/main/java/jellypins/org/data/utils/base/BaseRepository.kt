package jellypins.org.data.utils.base

import android.util.Log
import jellypins.org.domain.utils.ErrorType
import jellypins.org.domain.utils.RemoteErrorEmitter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException

/**
 * packageName    : jellypins.org.data.utils.base
 * fileName       : BaseRepository
 * author         : syshinpins
 * date           : 2022/06/06
 * description    : RestApi 기본 응답 처리 구현 추상 클래스
 * ========================================================================================
 * VERSION      DATE             AUTHOR             NOTE
 * ----------------------------------------------------------------------------------------
 * 0.0.0        2022-06-06       syshinpins         최초 생성
 */
abstract class BaseRepository {
    companion object {
        const val TAG = "BaseRepository"
        const val MESSAGE_KEY = "message"
        const val ERROR_KEY = "error"
    }

    /**
     * Api 호출 시 응답 에러 처리
     * withContext로 순차 처리
     * @param T : API 요청 코루틴 메소드 타입
     * @param emitter : 에러처리
     * @param callFunction : API 요청 코루틴 메소드
     * @return : 응답 결과 데이터 (null = 에러)
     */
    suspend inline fun <T> safeApiCall(emitter: RemoteErrorEmitter, crossinline callFunction: suspend () -> T): T? {
        return try {
            val myObject = withContext(Dispatchers.IO) { callFunction.invoke() }    //코루틴 IO 처리 메소드 호출
            myObject
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

    /**
     * Api 호출 시 응답 에러 처리
     * @param T : API 요청 메소드 타입
     * @param emitter : 에러처리
     * @param callFunction : API 요청 메소드
     * @return : 응답 결과 데이터 (null = 에러)
     */
    inline fun <T> safeApiCallNoContext(emitter: RemoteErrorEmitter, callFunction: () -> T): T? {
        return try {
            val myObject = callFunction.invoke()
            myObject
        } catch (e:Exception) {
            e.printStackTrace()
            Log.e(TAG, "Call error: ${e.localizedMessage}", e.cause)
            when(e) {
                is HttpException -> {
                    if(e.code() == 401) emitter.onError(ErrorType.TIMEOUT)
                    else {
                        val body = e.response()?.errorBody()
                        emitter.onError(getErrorMessage(body))
                    }
                }
                is SocketTimeoutException -> emitter.onError(ErrorType.TIMEOUT)
                is IOException -> emitter.onError(ErrorType.NETWORK)
                else -> emitter.onError(ErrorType.UNKNOWN)
            }
            null
        }
    }

    /**
     * 에러 메시지 처리
     * @param responseBody : 응답 body
     * @return : 에러 메시지
     */
    fun getErrorMessage(responseBody: ResponseBody?): String {
        return try {
            val jsonObject = JSONObject(responseBody!!.string())
            when {
                jsonObject.has(MESSAGE_KEY) -> jsonObject.getString(MESSAGE_KEY)
                jsonObject.has(ERROR_KEY) -> jsonObject.getString(ERROR_KEY)
                else -> "Something wrong happened"
            }
        } catch(e: Exception) {
            "Something wrong happened"
        }
    }
}