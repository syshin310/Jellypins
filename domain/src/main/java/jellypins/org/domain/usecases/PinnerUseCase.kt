package jellypins.org.domain.usecases

import jellypins.org.domain.repository.PinnerRepository
import jellypins.org.domain.utils.RemoteErrorEmitter
import javax.inject.Inject

/**
 * packageName    : jellypins.org.domain.usecases
 * fileName       : PinnerUseCase
 * author         : syshinpins
 * date           : 2022/06/06
 * description    : Pinner의 UseCase작성
 * ========================================================================================
 * VERSION      DATE             AUTHOR             NOTE
 * ----------------------------------------------------------------------------------------
 * 0.0.0        2022-06-06       syshinpins         최초 생성
 */
class PinnerUseCase  @Inject constructor(
    private val pinnerRepository: PinnerRepository
) {

    /**
     * 사용자 목록 조회 UseCase
     * @param remoteErrorEmitter : 에러 처리
     * @param email : 사용자 목록 조회 파라메터
     * @return :
     */
    suspend fun executeGetPinner(remoteErrorEmitter: RemoteErrorEmitter, email: String) = pinnerRepository.getPinner(remoteErrorEmitter, email)
}