package jellypins.org.view.fragments.home

import jellypins.org.base.BaseViewModel
import jellypins.org.widget.utils.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * packageName    : jellypins.org.view.fragments.home
 * fileName       : FirstFragmentViewModel
 * author         : syshinpins
 * date           : 2022/06/09
 * description    :
 * ========================================================================================
 * VERSION      DATE             AUTHOR             NOTE
 * ----------------------------------------------------------------------------------------
 * 0.0.0        2022-06-09       syshinpins         최초 생성
 */
@HiltViewModel
class FirstFragmentViewModel @Inject constructor(
) : BaseViewModel() {

    /**
     * ViewModel 에러 메시지
     */
    enum class ViewModelError(val message:String) {
    }

    //뷰모델 오퍼레이션 에러 처리
    val mutableViewModelError = SingleLiveEvent<ViewModelError>()

    /**
     * 페이징 이벤트
     * @param offset
     */
    override fun onPagingListener(offset: Int) {
        super.onPagingListener(offset)

    }
}