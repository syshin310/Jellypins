package jellypins.org.widget.badge

import android.content.Context
import android.content.res.ColorStateList
import android.util.AttributeSet
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import jellypins.org.R

/**
 * packageName    : jellypins.org.widget.badge
 * fileName       : Badge
 * author         : syshin310
 * date           : 2022-06-23
 * description    :
 * ========================================================================================
 * VERSION      DATE             AUTHOR             NOTE
 * ----------------------------------------------------------------------------------------
 * 0.0.0        2022-06-23       syshin310          최초 생성
 */
class Badge @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0,
    defStyleRes: Int = 0
) : LinearLayout(context, attrs, defStyle, defStyleRes) {
    private val badgeText: TextView
    private var important: Boolean

    init {
        inflate(context, R.layout.widget_badge, this)
        badgeText = findViewById(R.id.badge)
        important = false
        isImportant(important)
        adjustVisibility()
    }

    fun setText(text: String) {
        badgeText.text = text
        adjustVisibility()
    }

    fun isImportant(isImportant: Boolean) {
        if (isImportant) {
            badgeText.backgroundTintList = ColorStateList.valueOf(
                ContextCompat.getColor(
                    context,
                    R.color.badge
                )
            )
        } else {
            badgeText.backgroundTintList = ColorStateList.valueOf(
                ContextCompat.getColor(
                    context,
                    R.color.badge
                )
            )
        }
    }

    private fun adjustVisibility() {
        if (badgeText.text.isNullOrBlank() && this.visibility == VISIBLE) {
            this.visibility = INVISIBLE
        } else {
            this.visibility = VISIBLE
        }
    }
}