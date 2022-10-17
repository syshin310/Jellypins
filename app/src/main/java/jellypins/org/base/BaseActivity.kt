package jellypins.org.base

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding


/**
 * packageName    : jellypins.org.base
 * fileName       : BaseActivity
 * author         : syshin310
 * date           : 2022-06-14
 * description    : AppCompatActivity 클래스를 상속받은 BaseActivity 추상 클래스
 *                  DataBinding 결합
 * ========================================================================================
 * VERSION      DATE             AUTHOR             NOTE
 * ----------------------------------------------------------------------------------------
 * 0.0.0        2022-06-14       syshin310          최초 생성
 */
abstract class BaseActivity <T : ViewDataBinding>(@LayoutRes private val layoutResId: Int) : AppCompatActivity(){
    protected lateinit var binding: T
    private var waitTime = 0L

    companion object {
        //퍼미션
        const val REQUEST_PERMISSION = 100
    }

    //퍼미션 목록
    var arrPermissions:Array<String> = arrayOf()

    abstract fun init()
    abstract fun observeViewModel()

    protected fun showShortToast(msg: String) = Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    protected fun showLongToast(msg: String) = Toast.makeText(this, msg, Toast.LENGTH_LONG).show()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutResId)
        init()
        observeViewModel()
        //네비게이션 드로우메뉴 하단에 생기는 탐색 소프트키 잔상을 지우기 위한 플래그
//        window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        hideSystemUI()
    }

    //시스템 네비게이션 바 숨기기
    private fun hideSystemUI() {
        // Enables regular immersive mode.
        // For "lean back" mode, remove SYSTEM_UI_FLAG_IMMERSIVE.
        // Or for "sticky immersive," replace it with SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_IMMERSIVE
                // Set the content to appear under the system bars so that the
                // content doesn't resize when the system bars hide and show.
                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                // Hide the nav bar and status bar
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_FULLSCREEN)
    }

    /**
     * 뒤로가기 버튼 공통 처리
     */
    override fun onBackPressed() {
        super.onBackPressed()
//        if(System.currentTimeMillis() - waitTime >= 1500) {
//            waitTime = System.currentTimeMillis()
//            Toast.makeText(this, "뒤로가기 버튼을 한번 더 누르면 종료됩니다.", Toast.LENGTH_SHORT).show()
//        } else
//            finish()
    }

    /**
     * 퍼미션 체크
     * @param context
     * @return
     */
    fun checkAllPermissions():Boolean
    {
        //모든 퍼미션이 허용되어있다면 true
        var bPermissionChecked = true
        for (strPermission in arrPermissions) {
            bPermissionChecked = ContextCompat.checkSelfPermission(
                this,
                strPermission
            ) == 0
            if (!bPermissionChecked) {
                break
            }
        }

        return bPermissionChecked
    }
}