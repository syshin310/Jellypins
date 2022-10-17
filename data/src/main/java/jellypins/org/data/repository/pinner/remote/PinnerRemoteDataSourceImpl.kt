package jellypins.org.data.repository.pinner.remote

import jellypins.org.data.service.api.ApiInterface
import jellypins.org.data.di.NetworkModule
import jellypins.org.data.model.Response
import jellypins.org.data.utils.base.BaseApiRepository
import jellypins.org.domain.utils.RemoteErrorEmitter
import javax.inject.Inject

/**
 * packageName    : jellypins.org.data.repository.pinner.remote
 * fileName       : PinnerRemoteDataSourceImpl
 * author         : syshinpins
 * date           : 2022/10/14
 * description    : Pinner API 데이터 소스 구현
 * ========================================================================================
 * VERSION      DATE             AUTHOR             NOTE
 * ----------------------------------------------------------------------------------------
 * 0.0.0        2022-10-14       syshinpins         최초 생성
 */
class PinnerRemoteDataSourceImpl @Inject constructor(
    @NetworkModule.GitServer private val apiInterface: ApiInterface          //API 인터페이스
) : BaseApiRepository(), PinnerRemoteDataSource {


    override suspend fun getPinner(
        remoteErrorEmitter: RemoteErrorEmitter,
        email: String
    ): Response? {
        return safeApiCall(remoteErrorEmitter) {
            apiInterface.getPinner(email)
        }
    }
}