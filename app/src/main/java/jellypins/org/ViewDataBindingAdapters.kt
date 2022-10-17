package jellypins.org

import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.text.HtmlCompat
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import jellypins.org.base.BaseViewModel
import jellypins.org.widget.utils.EndlessRecyclerViewScrollListener
import com.bumptech.glide.Glide

/**
 * packageName    : jellypins.org
 * fileName       : ViewDataBindingAdapters
 * author         : syshinpins
 * date           : 2022/06/06
 * description    :
 * ========================================================================================
 * VERSION      DATE             AUTHOR             NOTE
 * ----------------------------------------------------------------------------------------
 * 0.0.0        2022-06-06       syshinpins         최초 생성
 */

@BindingAdapter("htmlText")
fun TextView.setHtmlText(html: String) {
    text = HtmlCompat.fromHtml(html, HtmlCompat.FROM_HTML_MODE_COMPACT)
}

@BindingAdapter("profileImageUrl")
fun profileImageUrl(imageView: AppCompatImageView, url: String?) {
    if (url?.isNotEmpty() == true) {
        Glide.with(imageView.context)
            .load(url)
            .placeholder(R.mipmap.avatar)
            .into(imageView)
    }
}

@BindingAdapter("endlessScroll")
fun RecyclerView.setEndlessScroll(
    viewModel: BaseViewModel
) {
    val scrollListener =
        object : EndlessRecyclerViewScrollListener(layoutManager as LinearLayoutManager) {
            override fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView?) {
                viewModel.pagingEventListener(totalItemsCount + 1)
            }
        }
    addOnScrollListener(scrollListener)
}
