package jellypins.org.view.fragments.main

import android.os.Bundle
import android.view.View
import androidx.activity.addCallback
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import jellypins.org.R
import jellypins.org.base.BaseFragment
import jellypins.org.databinding.DrawerMenuHeaderBinding
import jellypins.org.databinding.FragmentFrameDrawerBinding
import jellypins.org.widget.exetensions.setupWithNavController

/**
 * packageName    : jellypins.org.view.fragments.main
 * fileName       : DrawerFragment
 * author         : syshinpins
 * date           : 2022/06/10
 * description    :
 * ========================================================================================
 * VERSION      DATE             AUTHOR             NOTE
 * ----------------------------------------------------------------------------------------
 * 0.0.0        2022-06-10       syshinpins         최초 생성
 */
class DrawerFragment : BaseFragment<FragmentFrameDrawerBinding>(R.layout.fragment_frame_drawer) {
    private val TAG = DrawerFragment::class.simpleName

    private lateinit var drawerLayout: DrawerLayout
    private val drawerSelectedItemIdKey = "DRAWER_SELECTED_ITEM_ID_KEY"
    private var drawerSelectedItemId = R.id.navigation_home

    override fun initView() {
        setupDrawer()
        setBackPressedHandler()
    }

    override fun observeViewModel(){
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        savedInstanceState?.let {
            drawerSelectedItemId = it.getInt(drawerSelectedItemIdKey, drawerSelectedItemId)
        }
    }

    private fun setBackPressedHandler() {
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            if (drawerLayout.isOpen) {
                drawerLayout.close()
            } else {
                findNavController().popBackStack()
            }
        }
    }

    // Needed to maintain correct state over rotations
    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(drawerSelectedItemIdKey, drawerSelectedItemId)
        super.onSaveInstanceState(outState)
    }

    private fun setupDrawer() {
        drawerLayout = binding.drawerLayout

        // Your navGraphIds must have the same ids as your menuItem ids
        val navGraphIds = listOf(R.navigation.navigation_home)

        val controller = binding.drawerNavView.setupWithNavController(
            navGraphIds = navGraphIds,
            fragmentManager = childFragmentManager,
            containerId = R.id.drawer_container,
            currentItemId = drawerSelectedItemId, // Needed to maintain correct state over rotations
            parentNavController = findNavController(), // Optional: only if you need to
            // navigate to external destinations
            intent = requireActivity().intent
        )

        controller.observe(viewLifecycleOwner) { navController ->
            NavigationUI.setupWithNavController(binding.drawerToolbar, navController, drawerLayout)
            drawerSelectedItemId = navController.graph.id
        }

        val viewHeader = binding.drawerNavView.getHeaderView(0)
        val navViewHeaderBinding : DrawerMenuHeaderBinding = DrawerMenuHeaderBinding.bind(viewHeader)

        navViewHeaderBinding.tvInfo.setOnClickListener {
            findNavController().navigate(R.id.settingsFragment)
        }

        navViewHeaderBinding.tvName.setOnClickListener {
            findNavController().navigate(R.id.settingsFragment)
        }

        binding.logout.setOnClickListener {
            findNavController().navigate(R.id.loginFragment)
        }
    }

    override fun observeViewModelError() {
    }

    override fun observeApiNetworkError() {
    }

}
