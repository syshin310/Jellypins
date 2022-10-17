package jellypins.org.view.fragments.main

import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import jellypins.org.R
import jellypins.org.base.BaseFragment
import jellypins.org.databinding.FragmentSettingsBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * packageName    : jellypins.org.view.fragments.main
 * fileName       : SettingsFragment
 * author         : syshinpins
 * date           : 2022/06/09
 * description    :
 * ========================================================================================
 * VERSION      DATE             AUTHOR             NOTE
 * ----------------------------------------------------------------------------------------
 * 0.0.0        2022-06-13       syshinpins         최초 생성
 */
@AndroidEntryPoint
abstract class SettingsFragment: BaseFragment<FragmentSettingsBinding>(R.layout.fragment_settings) {
//    private val viewmodel: SecondFragmentViewModel by viewModels()

    override fun initView() {
        binding.apply {
            NavigationUI.setupWithNavController(binding.settingsToolbar, findNavController())
        }
    }

    override fun observeViewModel(){
    }
}
