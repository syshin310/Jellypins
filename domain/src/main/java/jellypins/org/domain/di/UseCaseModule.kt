package jellypins.org.domain.di

import jellypins.org.domain.repository.PinnerRepository
import jellypins.org.domain.usecases.PinnerUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * packageName    : jellypins.org.domain.di
 * fileName       : UseCaseModule
 * author         : syshinpins
 * date           : 2022/06/06
 * description    : UseCase 의존성 주입
 * ========================================================================================
 * VERSION      DATE             AUTHOR             NOTE
 * ----------------------------------------------------------------------------------------
 * 0.0.0        2022-06-06       syshinpins         최초 생성
 */
@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    /**
     * UserListUseCase 의존성 주입
     * @param repository
     * @return
     */
    @Provides
    @Singleton
    fun providePinnerUseCase(repository: PinnerRepository) = PinnerUseCase(repository)
}