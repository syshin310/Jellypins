package jellypins.org.view.fragments.home

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import jellypins.org.R
import jellypins.org.base.BaseFragment
import jellypins.org.databinding.FragmentFirstBinding
import dagger.hilt.android.AndroidEntryPoint
import jellypins.org.domain.utils.ErrorType

/**
 * packageName    : jellypins.org.view.fragments.home
 * fileName       : FirstFragment
 * author         : syshinpins
 * date           : 2022/06/09
 * description    :
 * ========================================================================================
 * VERSION      DATE             AUTHOR             NOTE
 * ----------------------------------------------------------------------------------------
 * 0.0.0        2022-06-09       syshinpins         최초 생성
 */
@AndroidEntryPoint
class FirstFragment : BaseFragment<FragmentFirstBinding>(R.layout.fragment_first) {
    private val TAG = FirstFragment::class.simpleName
    private val viewModel: FirstFragmentViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.activity = this
    }

    override fun initView() {
        sharedViewModel.getPinner()
        binding.apply {
        }
    }

    /**
     * 뷰모델 옵저브 작업
     */
    override fun observeViewModel(){
    }

    /**
     * 뷰모델 작업중 발생하는 에러 처리
     */
    override fun observeViewModelError() {
        //뷰모델 작업 에러 처리
        viewModel.mutableViewModelError.observe(this) {
            val msg = it.message
            when (it) {
                else -> {}
            }

            showShortToast(msg)
        }
    }

    /**
     * API 관련 에러 처리
     */
    override fun observeApiNetworkError() {
        //API 통신 에러 처리
        viewModel.mutableErrorMessage.observe(this) {
            Log.d(TAG, "API 통신 에러, $it")
        }

        //Http Network Exception 에러 처리
        viewModel.mutableErrorType.observe(this) {
            when (it) {
                ErrorType.NETWORK -> {}
                ErrorType.SESSION_EXPIRED -> {}
                ErrorType.TIMEOUT -> {}
                ErrorType.UNKNOWN -> {}
            }
        }
    }
}