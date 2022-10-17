package jellypins.org.data.di

import jellypins.org.domain.repository.PinnerRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jellypins.org.data.repository.pinner.PinnerRepositoryImpl
import jellypins.org.data.repository.pinner.remote.PinnerRemoteDataSourceImpl
import javax.inject.Singleton

/**
 * packageName    : jellypins.org.data.di
 * fileName       : RepositoryModule
 * author         : syshinpins
 * date           : 2022/06/06
 * description    : Repository 의존성 주입
 * ========================================================================================
 * VERSION      DATE             AUTHOR             NOTE
 * ----------------------------------------------------------------------------------------
 * 0.0.0        2022-06-06       syshinpins         최초 생성
 */
@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    /**
     * PinnerRepository 의존성 주입
     * @param pinnerRemoteDataSourceImpl
     * @return
     */
    @Provides
    @Singleton
    fun provideUserListRepository(
        pinnerRemoteDataSourceImpl: PinnerRemoteDataSourceImpl
    ): PinnerRepository {
        return PinnerRepositoryImpl(
            pinnerRemoteDataSourceImpl
        )
    }
}