package jellypins.org.domain.utils

/**
 * packageName    : jellypins.org.domain.utils
 * fileName       : ErrorType
 * author         : syshinpins
 * date           : 2022/06/06
 * description    : API 처리 에러 타입 열거형 클래스
 * ========================================================================================
 * VERSION      DATE             AUTHOR             NOTE
 * ----------------------------------------------------------------------------------------
 * 0.0.0        2022-06-06       syshinpins         최초 생성
 */
enum class ErrorType {
    NETWORK,                //네트워크 에러
    TIMEOUT,                //타임아웃
    SESSION_EXPIRED,        //세션만료
    UNKNOWN                 //알 수 없음
}