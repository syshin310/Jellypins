package jellypins.org.base

import android.app.ActionBar
import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.view.*
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import jellypins.org.BuildConfig
import jellypins.org.view.MainViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers


/**
 * packageName    : jellypins.org.base
 * fileName       : BaseFragment
 * author         : syshin310
 * date           : 2022-06-14
 * description    :
 * ========================================================================================
 * VERSION      DATE             AUTHOR             NOTE
 * ----------------------------------------------------------------------------------------
 * 0.0.0        2022-06-14       syshin310          최초 생성
 */

abstract class BaseFragment <T: ViewDataBinding>(@LayoutRes private val layoutId: Int): BaseLogFragment() {
    abstract fun initView()
    abstract fun observeViewModel()
    abstract fun observeViewModelError()
    abstract fun observeApiNetworkError()
    protected fun showShortToast(msg: String) = Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    protected fun showLongToast(msg: String) = Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
    protected lateinit var sharedViewModel: MainViewModel
//    protected val compositeDisposable = CompositeDisposable()

    /**
     * CoroutineScope 내부 Exception 처리 Handler
     */
    private val coroutineExceptionHandler = CoroutineExceptionHandler { context , throwable ->
        Log.w("$this", "$context ${throwable.message}")
        if(BuildConfig.DEBUG)
            throwable.printStackTrace()
    }
    protected val dispatchersMain = Dispatchers.Main + coroutineExceptionHandler
    protected val dispatchersIO = Dispatchers.IO + coroutineExceptionHandler

    protected lateinit var binding: T
        private set

    private var rootView: View? = null
    private var isFirstInit = true
    private var isHideKeyboardByTouchEvent = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setWindowSoftInputMode()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return if (rootView == null) {
            DataBindingUtil.inflate<T>(inflater, layoutId, container, false).apply{
                binding = this
                rootView = this.root
            }.root
        } else {
            rootView
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        if (isFirstInit) {
            isFirstInit = false
            sharedViewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
            initView()
            observeViewModel()
            observeViewModelError()
            observeApiNetworkError()
        }
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onDestroy() {
//        compositeDisposable.clear()
        super.onDestroy()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        Log.v("$this","onConfigurationChanged  -  $newConfig")
        super.onConfigurationChanged(newConfig)
    }


    /**
     * 앱 백키 제어 위한 콜백 분기 처리
     * 각 화면별로 Override
     */
    open fun onBackPressed(): Boolean {
        return true
    }

    open fun hideKeyboard() {
        getInputMethodManager().hideSoftInputFromWindow(view?.windowToken, 0)
        view?.clearFocus()
    }

    protected fun finish() {
        getMainNavController()?.navigateUp()
    }

    protected fun getActionBar(): ActionBar? = activity?.actionBar

    protected fun getInputMethodManager(): InputMethodManager =
        activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

    protected fun getMainNavController(): NavController? =
        activity?.supportFragmentManager?.primaryNavigationFragment?.findNavController()

    protected fun setWindowSoftInputMode(mode: Int = WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN){
        activity?.window?.setSoftInputMode(mode)
    }

    private fun hideSystemUI() {
        //        dialog?.window?.setFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE, WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE)
        //        dialog?.window?.addFlags(WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM or WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        activity?.window?.addFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN
                    or WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

//        val flag = (View.SYSTEM_UI_FLAG_LOW_PROFILE
//                or View.SYSTEM_UI_FLAG_FULLSCREEN
//                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
//                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)
//        activity?.window?.decorView?.systemUiVisibility = flag
//
//        activity?.window?.clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE)
    }
}