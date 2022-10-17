package jellypins.org.data.service.api

import jellypins.org.data.BuildConfig
import jellypins.org.data.model.pinner.PinnerRemoteRequestDataModel
import retrofit2.Response
import retrofit2.http.*

/**
 * packageName    : jellypins.org.data.service.api
 * fileName       : ApiInterface
 * author         : syshinpins
 * date           : 2022/06/06
 * description    : RestAPI 인터페이스를 정의.

 * ========================================================================================
 * VERSION      DATE             AUTHOR             NOTE
 * ----------------------------------------------------------------------------------------
 * 0.0.0        2022-06-06       syshinpins         최초 생성
 */
interface ApiInterface {

    //피너 추가
    //피너 조회
    @GET("${BuildConfig.CONTROLLER}/api/v1/pinner/pinner2.do")
    suspend fun getPinner(@Query("email") email: String) : jellypins.org.data.model.Response

    //젤리 추가
    //젤리 리스트 조회
    //젤리핀 추가
    //젤리핀 리스트 조회
    //젤리트립 추가
    //젤리트립 리스트 조회
}