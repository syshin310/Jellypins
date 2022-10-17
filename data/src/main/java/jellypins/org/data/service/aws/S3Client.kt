package jellypins.org.data.service.aws

import android.content.Context
import android.util.Log
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.mobileconnectors.s3.transferutility.*
import com.amazonaws.regions.Region
import com.amazonaws.regions.Regions
import com.amazonaws.services.s3.AmazonS3Client
import kotlinx.coroutines.suspendCancellableCoroutine
import java.io.File
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

/**
 * packageName    : jellypins.org.data.service.thirdparty
 * fileName       : S3Client
 * author         : syshin310
 * date           : 2022-06-09
 * description    :
 * ========================================================================================
 * VERSION      DATE             AUTHOR             NOTE
 * ----------------------------------------------------------------------------------------
 * 0.0.0        2022-06-09       syshin310         최초 생성
 */
class S3Client @Inject constructor(){
    /**
     * S3 업로드 리스너 코루틴 처리
     * @param uploadObserver : 업로드 옵저버
     * @return : 완료 여부
     */
    private suspend fun upload(uploadObserver: TransferObserver): TransferState = suspendCancellableCoroutine { continuation ->
        uploadObserver.setTransferListener(object : TransferListener {
            override fun onStateChanged(id: Int, state: TransferState) {
                if(continuation.isActive) {
                    when (state) {
                        TransferState.COMPLETED -> continuation.resume(TransferState.COMPLETED)     //업로드 완료
                        TransferState.CANCELED -> continuation.resume(TransferState.CANCELED)       //업로드 취소됨
                        TransferState.FAILED -> continuation.resume(TransferState.FAILED)           //업로드 실패
                        TransferState.WAITING -> {}                                                 //업로드 실행 대기(시작전)
                        TransferState.IN_PROGRESS -> {}                                             //업로드 진행중..
                        else -> continuation.resume(state)
                    }
                }
            }

            override fun onProgressChanged(id: Int, current: Long, total: Long) {
                try {
                    val done = (((current.toDouble() / total) * 100.0).toInt())
                } catch (e: Exception) {

                }
            }

            override fun onError(id: Int, ex: Exception) {
                if(continuation.isActive)
                    continuation.resumeWithException(ex)
            }
        })
    }

    /**
     * S3 싱글 이미지 업로드 진행
     * @param path : 로컬 이미지 경로
     * @param placeCode : 골프장 코드
     * @return : 업로드 파일 경로 (에러시 빈문자열)
     */
    suspend fun uploadSingleImage(context: Context, path: String, placeCode: String, today: String, fileName: String): String {
        var uploadUrl = ""
        var ret:TransferState = TransferState.UNKNOWN
        try {
            //S3클라이언트 초기화
            val s3Client = AmazonS3Client(
                //TODO Access key, secret key 추후 변경
                BasicAWSCredentials(jellypins.org.data.BuildConfig.AWS_ACCESS_KEY, jellypins.org.data.BuildConfig.AWS_SECRET_KEY),
                Region.getRegion(Regions.US_EAST_2)
            )

            val transferUtility = TransferUtility.builder().s3Client(s3Client).context(context).build()
            TransferNetworkLossHandler.getInstance(context)

            var uploadObserver = transferUtility?.upload(jellypins.org.data.BuildConfig.AWS_BUCKET, "clubphoto/$placeCode/$today/$fileName", File(path))
            uploadObserver?.let {
                ret = upload(uploadObserver)
                Log.d("S3", "Result : $ret")
            }
            if (ret == TransferState.COMPLETED)
                uploadUrl = jellypins.org.data.BuildConfig.AWS_CLOUD_FRONT + "/clubphoto/$placeCode/$today/$fileName"
        }
        catch (e:Exception) {

        }
        return uploadUrl
    }
}