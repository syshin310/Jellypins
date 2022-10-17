package jellypins.org.data.di

import jellypins.org.data.service.api.ApiInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jellypins.org.data.repository.pinner.remote.PinnerRemoteDataSource
import jellypins.org.data.repository.pinner.remote.PinnerRemoteDataSourceImpl
import javax.inject.Singleton

/**
 * packageName    : jellypins.org.data.di
 * fileName       : DataSourceImplModule
 * author         : syshinpins
 * date           : 2022/06/06
 * description    : DataSource implements 주입
 * ========================================================================================
 * VERSION      DATE             AUTHOR             NOTE
 * ----------------------------------------------------------------------------------------
 * 0.0.0        2022-06-06       syshinpins         최초 생성
 */
@Module
@InstallIn(SingletonComponent::class)
class DataSourceImplModule {

    /**
     * PinnerRemoteDataSourceImpl 의존성 주입
     * @param apiInterface : API 인터페이스
     * @return
     */
    @Provides
    @Singleton
    fun providePinnerRemoteDataSource(
        apiInterface: ApiInterface
    ) : PinnerRemoteDataSource {
        return PinnerRemoteDataSourceImpl(
            apiInterface
        )
    }
}