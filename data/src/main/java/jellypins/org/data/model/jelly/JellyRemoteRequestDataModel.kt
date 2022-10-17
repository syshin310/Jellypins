package jellypins.org.data.model.jelly

import com.google.gson.annotations.SerializedName

/**
 * packageName    : jellypins.org.data.model.jelly
 * fileName       : JellyRemoteRequestDataModel
 * author         : syshinpins
 * date           : 2022/10/14
 * description    : 젤리 API 요청 데이터 모델 클래스
 * ========================================================================================
 * VERSION      DATE             AUTHOR             NOTE
 * ----------------------------------------------------------------------------------------
 * 0.0.0        2022-10-14       syshinpins         최초 생성
 */

data class JellyRemoteRequestDataModel (
    @SerializedName("ID")
    val ID: Int,
    @SerializedName("COUNTRY_CD")
    val COUNTRY_CD: String?,
    @SerializedName("CITY_CD")
    val CITY_CD: String?,
    @SerializedName("IMAGE")
    val IMAGE: String?,
    @SerializedName("LAT")
    val LAT: Float?,
    @SerializedName("LNG")
    val LNG: Float?,
    @SerializedName("PLACE_ID")
    val PLACE_ID: String?,
    @SerializedName("TYPE_ID")
    val TYPE_ID: Int?,
    @SerializedName("TAGS")
    val TAGS: String?,
    @SerializedName("VIEW_CNT")
    val VIEW_CNT: Int?,
    @SerializedName("COMMENT_CNT")
    val COMMENT_CNT: Int?,
    @SerializedName("LIKE_CNT")
    val LIKE_CNT: Int?,
    @SerializedName("BUY_CNT")
    val BUY_CNT: Int?,
    @SerializedName("USE_YN")
    val USE_YN: String?,
    @SerializedName("CREATE_DATETIME")
    val CREATE_DATETIME: String?,
    @SerializedName("UPDATE_DATETIME")
    val UPDATE_DATETIME: String?,
    @SerializedName("NOW_DATETIME")
    val NOW_DATETIME: String?,
    @SerializedName("USER_ID")
    val USER_ID: Int,
    @SerializedName("PROFILE_IMG")
    val PROFILE_IMG: String?,
    @SerializedName("COUNTRY_NAME")
    val COUNTRY_NAME: String?,
    @SerializedName("CITY_NAME")
    val CITY_NAME: String?,
    @SerializedName("PLACE_NAME")
    val PLACE_NAME: String?,
    @SerializedName("ADDRESS")
    val ADDRESS: String?,
    @SerializedName("USER_NAME")
    val USER_NAME: String?
)