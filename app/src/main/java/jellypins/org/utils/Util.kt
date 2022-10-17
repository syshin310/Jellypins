package jellypins.org.utils

import android.content.Context
import android.database.Cursor
import android.net.Uri
import android.provider.MediaStore
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

/**
 * packageName    : jellypins.org.utils
 * fileName       : Util
 * author         : syshinpins
 * date           : 2022/06/09
 * description    :
 * ========================================================================================
 * VERSION      DATE             AUTHOR             NOTE
 * ----------------------------------------------------------------------------------------
 * 0.0.0        2022-06-09       syshinpins         최초 생성
 */
object Util {
    /**
     * 파일 uri를 전체 경로 값으로 변경
     * @param context : 컨텍스트
     * @param fileUri
     * @return
     */
    fun getFullPathFromUri(context: Context, fileUri: Uri?): String? {
        var fullPath: String? = null
        val column = "_data"
        var cursor: Cursor? = fileUri?.let { context.contentResolver.query(it, null, null, null, null) }
        if (cursor != null) {
            cursor.moveToFirst()
            var documentId: String = cursor.getString(0)
            documentId = documentId.substring(documentId.lastIndexOf(":") + 1)
            cursor.close()
            val projection = arrayOf(column)
            try {
                cursor = context.contentResolver.query(
                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                    projection,
                    MediaStore.Images.Media._ID + " = ? ",
                    arrayOf(documentId),
                    null
                )
                if (cursor != null) {
                    cursor.moveToFirst()
                    fullPath = cursor.getString(cursor.getColumnIndexOrThrow(column))
                }
            } finally {
                cursor.close()
            }
        }
        return fullPath
    }

    /**
     * 파일명 확장자 취득
     * @param path : 파일명 포함 경로 또는 파일명(확장자 포함)
     * @return
     */
    fun getExtensionOfFile(path: String) : String {
        val index = path.lastIndexOf(".")
        return path.substring(index + 1, path.length)
    }

    /**
     * DateTimeFormatter에 맞는 일시 출력
     * @param dateformat
     * @return
     */
    fun getNowDateTime(dateformat: DateTimeFormatter? = DateTimeFormatter.ISO_DATE): String {
        val current = LocalDateTime.now()
        return current.format(dateformat)
    }

    /**
     * date format에 맞는 일시 출력
     * @param dateformat
     * @return
     */
    fun getNowDateTime(dateformat:String? = "yyyyMMdd") : String {
        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern(dateformat)
        return current.format(formatter)
    }
}