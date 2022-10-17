package jellypins.org.base

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.annotation.DimenRes
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import jellypins.org.view.MainViewModel


/**
 * packageName    : jellypins.org.base
 * fileName       : BaseDialogFragment
 * author         : syshin310
 * date           : 2022-06-14
 * description    :
 * ========================================================================================
 * VERSION      DATE             AUTHOR             NOTE
 * ----------------------------------------------------------------------------------------
 * 0.0.0        2022-06-14       syshin310          최초 생성
 */
abstract class BaseDialogFragment<T: ViewDataBinding>(@LayoutRes private val layoutId: Int, @DimenRes private val widthId:Int, @DimenRes private val heightId:Int): DialogFragment() {
    protected lateinit var binding: T
    protected lateinit var navController: NavController
    protected lateinit var sharedViewModel: MainViewModel   //데이터 공유 뷰모델
    private var isBackgroundPressed = true                  //백그라운드 터치 종료 시 네비게이션 백스텍 이동

    var m_strPopupTitle = ""

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return object : Dialog(requireContext()) {
            override fun onBackPressed() {
                //Back key 이벤트
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = findNavController()
        sharedViewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)

        //Dialog width, height 설정
        val params: ViewGroup.LayoutParams? = dialog?.window?.attributes
        params?.width = resources.getDimension(widthId).toInt()
        params?.height = resources.getDimension(heightId).toInt()
        dialog?.window?.attributes = params as WindowManager.LayoutParams
        initView()
        observeViewModel()
        observeViewModelError()
        observeApiNetworkError()
    }

    override fun onResume() {
        super.onResume()
        hideSystemUI()
    }

    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
        if(isBackgroundPressed) //백그라운드 터치에의한 종료일 경우
            findNavController().navigateUp()
    }

    open fun hideKeyboard(view:View) {
        getInputMethodManager().hideSoftInputFromWindow(view.windowToken, 0)
        view.clearFocus()
    }

    protected fun finish() {
        isBackgroundPressed = false
        findNavController().navigateUp()
    }

    abstract fun initView()
    abstract fun observeViewModel()
    abstract fun observeViewModelError()
    abstract fun observeApiNetworkError()

    protected fun setLayoutSize(widthId: Int, heightId: Int){
        //Dialog width, height 설정
        val params: ViewGroup.LayoutParams? = dialog?.window?.attributes
        params?.width = resources.getDimension(widthId).toInt()
        params?.height = resources.getDimension(heightId).toInt()
        dialog?.window?.attributes = params as WindowManager.LayoutParams
    }

    protected fun showShortToast(msg: String) = Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    protected fun showLongToast(msg: String) = Toast.makeText(context, msg, Toast.LENGTH_LONG).show()

    protected fun getInputMethodManager(): InputMethodManager =
        activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

    protected fun getMainNavController(): NavController? =
        activity?.supportFragmentManager?.primaryNavigationFragment?.findNavController()

    private fun hideSystemUI() {
        //        dialog?.window?.setFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE, WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE)
        //        dialog?.window?.addFlags(WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM or WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

        val flag = (View.SYSTEM_UI_FLAG_LOW_PROFILE
                or View.SYSTEM_UI_FLAG_FULLSCREEN
                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)
        dialog?.window?.decorView?.systemUiVisibility = flag
        dialog?.window?.clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE)
    }
}