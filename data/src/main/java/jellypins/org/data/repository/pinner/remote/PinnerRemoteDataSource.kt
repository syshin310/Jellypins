package jellypins.org.data.repository.pinner.remote

import jellypins.org.data.model.Response
import jellypins.org.domain.utils.RemoteErrorEmitter

/**
 * packageName    : jellypins.org.data.repository.pinner.remote
 * fileName       : PinnerRemoteDataSource
 * author         : syshinpins
 * date           : 2022/10/14
 * description    :
 * ========================================================================================
 * VERSION      DATE             AUTHOR             NOTE
 * ----------------------------------------------------------------------------------------
 * 0.0.0        2022-10-14       syshinpins         최초 생성
 */
interface PinnerRemoteDataSource {
    /**
     * 사용자 조회 API 처리
     * @param remoteErrorEmitter : 에러 처리
     * @param email : 이메일
     * @return : 응답 모델
     */
    suspend fun getPinner(remoteErrorEmitter: RemoteErrorEmitter, email:String) : Response?
}