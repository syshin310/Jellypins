package jellypins.org.view

import androidx.lifecycle.viewModelScope
import jellypins.org.domain.usecases.PinnerUseCase
import jellypins.org.base.BaseViewModel
import jellypins.org.widget.utils.ScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * packageName    : jellypins.org.view
 * fileName       : MainViewModel
 * author         : syshinpins
 * date           : 2022/06/09
 * description    :
 * ========================================================================================
 * VERSION      DATE             AUTHOR             NOTE
 * ----------------------------------------------------------------------------------------
 * 0.0.0        2022-06-09       syshinpins         최초 생성
 */
@HiltViewModel
class MainViewModel @Inject constructor(
    private val pinnerUseCase: PinnerUseCase
) : BaseViewModel() {

    fun getPinner() = viewModelScope.launch {
        val response = pinnerUseCase.executeGetPinner(this@MainViewModel, "syshin.pins@gmail.com")
        if(response == null) mutableScreenState.postValue(ScreenState.ERROR) else {
            mutableScreenState.postValue(ScreenState.RENDER)
        }
    }
}