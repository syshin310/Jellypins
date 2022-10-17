package jellypins.org.data.model

import com.google.gson.annotations.SerializedName
import java.util.*

/**
 * packageName    : jellypins.org.data.model
 * fileName       : Response
 * author         : syshinpins
 * date           : 2022/06/06
 * description    : RestAPI 응답 공통 코드 검사 용 응답 모델 데이터 클래스
 * ========================================================================================
 * VERSION      DATE             AUTHOR             NOTE
 * ----------------------------------------------------------------------------------------
 * 0.0.0        2022-06-06       syshinpins         최초 생성
 */
data class Response(
    @SerializedName("result")
    val result : String,                //결과값
    @SerializedName("code")
    val code : String,                  //결과 코드
    @SerializedName("Message")
    val Message : String,               //메시지
    @SerializedName("data")
    val data : Objects
)
