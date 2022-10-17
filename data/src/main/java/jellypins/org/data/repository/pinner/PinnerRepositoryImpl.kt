package jellypins.org.data.repository.pinner

import jellypins.org.data.repository.pinner.remote.PinnerRemoteDataSource
import jellypins.org.domain.repository.PinnerRepository
import jellypins.org.domain.utils.RemoteErrorEmitter
import javax.inject.Inject

/**
 * packageName    : jellypins.org.data.repository.pinner
 * fileName       : PinnerRepositoryImpl
 * author         : syshinpins
 * date           : 2022/10/14
 * description    : Pinner 데이터 소스 구현
 * ========================================================================================
 * VERSION      DATE             AUTHOR             NOTE
 * ----------------------------------------------------------------------------------------
 * 0.0.0        2022-10-14       syshinpins         최초 생성
 */
class PinnerRepositoryImpl @Inject constructor(
    private val pinnerRemoteDataSource: PinnerRemoteDataSource
) : PinnerRepository {

    override suspend fun getPinner(remoteErrorEmitter: RemoteErrorEmitter, email: String) {
        pinnerRemoteDataSource.getPinner(remoteErrorEmitter, email)
    }
}