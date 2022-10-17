package jellypins.org.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * packageName    : jellypins.org.base
 * fileName       : BaseRecyclerViewHolder
 * author         : syshin310
 * date           : 2022-06-14
 * description    : RecyclerViewHolder Base Class 작성
 * S = Model/Data class , T = RecyclerView.ViewHolder
 * ========================================================================================
 * VERSION      DATE             AUTHOR             NOTE
 * ----------------------------------------------------------------------------------------
 * 0.0.0        2022-06-14       syshin310          최초 생성
 */
abstract class BaseRecyclerViewHolder<T>(
    private val containerView: View
): RecyclerView.ViewHolder(containerView){
    abstract fun bind(item: T, position: Int)
}