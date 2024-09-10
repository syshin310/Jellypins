package jellypins.org.data.mapper.pinner

import jellypins.org.data.model.pinner.PinnerRemoteRequestDataModel
import jellypins.org.data.repository.pinner.remote.PinnerRemoteDataSource
import jellypins.org.domain.model.pinner.PinnerModel

/**
 * packageName    : com.gfieldcaddie.data.mapper
 * fileName       : Mapper
 * author         : syshin310
 * date           : 2022-06-13
 * description    :
 * ========================================================================================
 * VERSION      DATE             AUTHOR             NOTE
 * ----------------------------------------------------------------------------------------
 * 0.0.0        2022-06-13       syshin310          최초 생성
 */
object PinnerMapper {
    object Pinner {
        fun Response(response : PinnerRemoteRequestDataModel?) : PinnerModel? {
            return response?.toDomain()
        }

        private fun PinnerRemoteRequestDataModel.toDomain(): PinnerModel {
            return this.let {
                PinnerModel(
                    ID = it.ID,
                    SNS_CONN_ID = it.SNS_CONN_ID,
                    EMAIL = it.EMAIL,
                    PASSCODE = it.PASSCODE,
                    COUNTRY_CD = it.COUNTRY_CD,
                    VERIFY_TYPE = it.VERIFY_TYPE,
                    VERIFIED = it.VERIFIED,
                    PROFILE_IMG = it.PROFILE_IMG,
                    BACKGROUND_IMG = it.BACKGROUND_IMG,
                    MSG_TOKEN = it.MSG_TOKEN,
                    TYPE_ID = it.TYPE_ID,
                    GROUP_ID = it.GROUP_ID,
                    AGE = it.AGE,
                    GENDER = it.GENDER,
                    BIRTHDAY = it.BIRTHDAY,
                    PHONE = it.PHONE,
                    MOBILE = it.MOBILE,
                    LANGUAGE_CD = it.LANGUAGE_CD,
                    LEVEL = it.LEVEL,
                    POINT = it.POINT,
                    PREMIUM_ID = it.PREMIUM_ID,
                    PREMIUM_EXPIRATION_DATE = it.PREMIUM_EXPIRATION_DATE,
                    PREMIUM_REGISTED_DATE = it.PREMIUM_REGISTED_DATE,
                    ADVERTISING_ID = it.ADVERTISING_ID,
                    COMMENT = it.COMMENT,
                    MEMO = it.MEMO,
                    RECOMMAND = it.RECOMMAND,
                    LAST_IP = it.LAST_IP,
                    PAYPAL_NO = it.PAYPAL_NO,
                    PAYPAL_YN = it.PAYPAL_YN,
                    TOTAL_CASH = it.TOTAL_CASH,
                    USED_CASH = it.USED_CASH,
                    SAVE_CASH = it.SAVE_CASH,
                    CREATE_DATETIME = it.CREATE_DATETIME,
                    LAST_LOGIN_DATETIME = it.LAST_LOGIN_DATETIME,
                    UPDATE_DATETIME = it.UPDATE_DATETIME,
                    COUNTRY_NAME = it.COUNTRY_NAME,
                    NAME = it.NAME,
                    LAST_NAME = it.LAST_NAME,
                    FIRST_NAME = it.FIRST_NAME
                )
            }
        }
    }
}