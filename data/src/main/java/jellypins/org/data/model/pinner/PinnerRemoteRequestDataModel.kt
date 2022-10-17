package jellypins.org.data.model.pinner

import com.google.gson.annotations.SerializedName

/**
 * packageName    : jellypins.org.data.model.pinner
 * fileName       : PinnerRemoteRequestDataModel
 * author         : syshinpins
 * date           : 2022/10/14
 * description    : 피너 생성 API 요청 데이터 모델 클래스
 * ========================================================================================
 * VERSION      DATE             AUTHOR             NOTE
 * ----------------------------------------------------------------------------------------
 * 0.0.0        2022-10-14       syshinpins         최초 생성
 */

data class PinnerRemoteRequestDataModel (
    @SerializedName("ID")
    val ID: Int,
    @SerializedName("SNS_CONN_ID")
    val SNS_CONN_ID: String?,
    @SerializedName("EMAIL")
    val EMAIL: String?,
    @SerializedName("PASSCODE")
    val PASSCODE: String?,
    @SerializedName("COUNTRY_CD")
    val COUNTRY_CD: String?,
    @SerializedName("VERIFY_TYPE")
    val VERIFY_TYPE: String?,
    @SerializedName("VERIFIED")
    val VERIFIED: String?,
    @SerializedName("PROFILE_IMG")
    val PROFILE_IMG: String?,
    @SerializedName("BACKGROUND_IMG")
    val BACKGROUND_IMG: String?,
    @SerializedName("MSG_TOKEN")
    val MSG_TOKEN: String?,
    @SerializedName("TYPE_ID")
    val TYPE_ID: Int?,
    @SerializedName("GROUP_ID")
    val GROUP_ID: Int?,
    @SerializedName("AGE")
    val AGE: Int?,
    @SerializedName("GENDER")
    val GENDER: String?,
    @SerializedName("BIRTHDAY")
    val BIRTHDAY: String?,
    @SerializedName("PHONE")
    val PHONE: String?,
    @SerializedName("MOBILE")
    val MOBILE: String?,
    @SerializedName("LANGUAGE_CD")
    val LANGUAGE_CD: String?,
    @SerializedName("LEVEL")
    val LEVEL: Int?,
    @SerializedName("POINT")
    val POINT: Int?,
    @SerializedName("PREMIUM_ID")
    val PREMIUM_ID: String?,
    @SerializedName("PREMIUM_EXPIRATION_DATE")
    val PREMIUM_EXPIRATION_DATE: String?,
    @SerializedName("PREMIUM_REGISTED_DATE")
    val PREMIUM_REGISTED_DATE: String?,
    @SerializedName("ADVERTISING_ID")
    val ADVERTISING_ID: String?,
    @SerializedName("COMMENT")
    val COMMENT: String?,
    @SerializedName("MEMO")
    val MEMO: String?,
    @SerializedName("RECOMMAND")
    val RECOMMAND: Int?,
    @SerializedName("LAST_IP")
    val LAST_IP: String?,
    @SerializedName("PAYPAL_NO")
    val PAYPAL_NO: String?,
    @SerializedName("PAYPAL_YN")
    val PAYPAL_YN: String?,
    @SerializedName("TOTAL_CASH")
    val TOTAL_CASH: Int?,
    @SerializedName("USED_CASH")
    val USED_CASH: Int?,
    @SerializedName("SAVE_CASH")
    val SAVE_CASH: Int?,
    @SerializedName("CREATE_DATETIME")
    val CREATE_DATETIME: String?,
    @SerializedName("LAST_LOGIN_DATETIME")
    val LAST_LOGIN_DATETIME: String?,
    @SerializedName("UPDATE_DATETIME")
    val UPDATE_DATETIME: String?,
    @SerializedName("COUNTRY_NAME")
    val COUNTRY_NAME: String?,
    @SerializedName("NAME")
    val NAME: String?,
    @SerializedName("LAST_NAME")
    val LAST_NAME: String?,
    @SerializedName("FIRST_NAME")
    val FIRST_NAME: String?
)