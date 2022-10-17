package jellypins.org.domain.utils

/**
 * packageName    : jellypins.org.domain.utils
 * fileName       : ErrorType
 * author         : syshinpins
 * date           : 2022/06/06
 * description    : API 에러 처리 인터페이스
 * ========================================================================================
 * VERSION      DATE             AUTHOR             NOTE
 * ----------------------------------------------------------------------------------------
 * 0.0.0        2022-06-06       syshinpins         최초 생성
 */
interface RemoteErrorEmitter {
    fun onError(msg: String)
    fun onError(errorType: ErrorType)
}