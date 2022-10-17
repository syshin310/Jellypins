package jellypins.org.base

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * packageName    : jellypins.org.base
 * fileName       : BaseRecyclerViewAdapter
 * author         : syshin310
 * date           : 2022-06-14
 * description    :
 * ========================================================================================
 * VERSION      DATE             AUTHOR             NOTE
 * ----------------------------------------------------------------------------------------
 * 0.0.0        2022-06-14       syshin310          최초 생성
 */
abstract class BaseRecyclerViewAdapter <S, T : RecyclerView.ViewHolder>
    : RecyclerView.Adapter<T>(){

    //리스트
    var items = mutableListOf<S>()
        private set

    /**
     * 리사이크러 뷰 아이템 뷰홀더 생성
     * @param parent
     * @param viewType
     * @return
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): T {
        return createItemViewHolder(parent, viewType)
    }

    /**
     * 리사이클러뷰 아이템 데이터 바인드
     * @param holder
     * @param position
     */
    override fun onBindViewHolder(holder: T, position: Int) {
        bindItemViewHolder(holder, position)
    }

    /**
     * 아이템 갯수
     * @return
     */
    override fun getItemCount() = items.size

    protected abstract fun createItemViewHolder(parent: ViewGroup, viewType: Int) : T
    protected abstract fun bindItemViewHolder(holder: T, position: Int)

    /**
     * 아이템 리스트 추가
     * @param items
     * @param clearPreviousItems
     */
    open fun addAll(items: ArrayList<S>?, clearPreviousItems: Boolean = false) {
        if (clearPreviousItems) {
            this.items.clear()
        }

        if (items != null) {
            this.items.addAll(items)
        }
        notifyDataSetChanged()
    }

    /**
     * 아이템 추가
     * @param item
     * @param position
     * @param clearPreviousItems
     */
    fun addItem(item: S, position: Int = items.size, clearPreviousItems: Boolean = false) {
        var adapterPosition = position
        if (clearPreviousItems) {
            this.items.clear()
            adapterPosition = 0
        }

        this.items.add(adapterPosition, item)
        notifyDataSetChanged()
    }

    /**
     * 아이템 삭제
     * @param position
     */
    fun removeItem(position: Int) {
        if (position != -1) {
            items.removeAt(position)
            notifyItemRemoved(position)
        }
    }

    /**
     * 아이템 취득
     * @param position
     * @return
     */
    fun getItemAt(position: Int): S? {
        return items.elementAt(position)
    }

    /**
     * 아이템 변경
     * @param position
     * @param item
     */
    fun updateItemAt(position: Int, item: S) {
        if (position != -1) {
            items[position] = item
            notifyDataSetChanged()
        }
    }

    /**
     * 리스트 클리어
     */
    fun clearAdapter() {
        val size = items.size
        items.clear()
        notifyItemRangeRemoved(0, size)
    }
}

interface ItemClickListener<S> {
    fun onItemClick(item:S?)
}