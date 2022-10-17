package jellypins.org.view.fragments.main

import androidx.fragment.app.viewModels
import jellypins.org.R
import jellypins.org.base.BaseFragment
import jellypins.org.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * packageName    : jellypins.org.view.fragments.main
 * fileName       : LoginFragment
 * author         : syshinpins
 * date           : 2022/06/10
 * description    :
 * ========================================================================================
 * VERSION      DATE             AUTHOR             NOTE
 * ----------------------------------------------------------------------------------------
 * 0.0.0        2022-06-10       syshinpins         최초 생성
 */
@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding>(R.layout.fragment_login) {
//    private lateinit var viewmodel: LoginFragmentViewModel
    private val viewmodel: LoginFragmentViewModel by viewModels()
    override fun initView() {
        binding.apply {
            binding.btnLogin.setOnClickListener {
                getMainNavController()?.navigate(R.id.drawerFragment)
            }
        }
    }

    override fun observeViewModel() {
    }

    override fun observeViewModelError() {
    }

    override fun observeApiNetworkError() {
    }
}