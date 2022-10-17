package jellypins.org.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import jellypins.org.domain.utils.ErrorType
import jellypins.org.domain.utils.RemoteErrorEmitter
import jellypins.org.widget.utils.ScreenState
import jellypins.org.widget.utils.SingleLiveEvent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * packageName    : jellypins.org.base
 * fileName       : BaseViewModel
 * author         : syshin310
 * date           : 2022-06-14
 * description    : ViewModel 클래스를 상속받은 BaseViewModel 추상 클래스
 *                  API 에러 처리 인터페이스 작성
 * ========================================================================================
 * VERSION      DATE             AUTHOR             NOTE
 * ----------------------------------------------------------------------------------------
 * 0.0.0        2022-06-14       syshin310          최초 생성
 */
abstract class BaseViewModel : ViewModel(), RemoteErrorEmitter {
    val mutableScreenState = SingleLiveEvent<ScreenState>()
    val mutableErrorMessage = SingleLiveEvent<String>()
    val mutableErrorType = SingleLiveEvent<ErrorType>()

    override fun onError(msg: String) {
        mutableErrorMessage.postValue(msg)
    }

    override fun onError(errorType: ErrorType) {
        mutableErrorType.postValue(errorType)
    }

    /**
     * CoroutineScope Main 확장 함수
     * @param body
     * @return
     */
    inline fun ViewModel.onMain(
        crossinline body: suspend CoroutineScope.() -> Unit
    ) = viewModelScope.launch {
        body(this)
    }

    /**
     * CoroutineScope IO 확장 함수
     * @param body
     * @return
     */
    inline fun ViewModel.onIO(
        crossinline body: suspend CoroutineScope.() -> Unit
    ) = viewModelScope.launch(Dispatchers.IO) {
        body(this)
    }

    /**
     * CoroutineScope Default 확장함수
     * @param body
     * @return
     */
    inline fun ViewModel.onDefault(
        crossinline body: suspend CoroutineScope.() -> Unit
    ) = viewModelScope.launch(Dispatchers.Default) {
        body(this)
    }

    /**
     * 스크롤 페이징 이벤트 발생 시 처리(Load more)
     * @param offset : 다음 index
     */
    open fun pagingEventListener(offset: Int) {
        onPagingListener(offset)
    }

    protected open fun onPagingListener(offset: Int) { }
}