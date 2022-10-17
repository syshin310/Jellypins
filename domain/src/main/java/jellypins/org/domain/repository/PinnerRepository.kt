package jellypins.org.domain.repository

import jellypins.org.domain.utils.RemoteErrorEmitter

/**
 * packageName    : jellypins.org.domain.repository
 * fileName       : PinnerRepository
 * author         : syshinpins
 * date           : 2022/06/06
 * description    : Pinner 데이터 소스 구현
 * ========================================================================================
 * VERSION      DATE             AUTHOR             NOTE
 * ----------------------------------------------------------------------------------------
 * 0.0.0        2022-06-06       syshinpins         최초 생성
 */
interface PinnerRepository {

    suspend fun getPinner(remoteErrorEmitter: RemoteErrorEmitter, email:String)
}