package jellypins.org.view

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import androidx.activity.viewModels
import androidx.annotation.NonNull
import androidx.core.app.ActivityCompat
import jellypins.org.R
import jellypins.org.base.BaseActivity
import jellypins.org.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * packageName    : jellypins.org.view
 * fileName       : MainActivity
 * author         : syshinpins
 * date           : 2022/06/06
 * description    :
 * ========================================================================================
 * VERSION      DATE             AUTHOR             NOTE
 * ----------------------------------------------------------------------------------------
 * 0.0.0        2022-06-06       syshinpins         최초 생성
 */
@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    private val viewmodel by viewModels<MainViewModel>()

    override fun init() {
//        acceptPermission()
    }

    private fun acceptPermission(): Boolean {
        return if (Build.VERSION.SDK_INT >= 23) {
            if ( checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
                && checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
                && checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED
            /*&& checkSelfPermission(Manifest.permission.MANAGE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED*/) {
                doActionWhenPermissioGrant()
                true
            } else {
                if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED ||
                    checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED ||
                    checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_DENIED) {
                    ActivityCompat.requestPermissions(
                        this,
                        arrPermissions,
                        REQUEST_PERMISSION
                    )
                }
                else
                {
                    doActionWhenPermissioGrant()
                }
                false
            }
        } else {
            true
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        @NonNull permissions: Array<String>,
        @NonNull grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (Build.VERSION.SDK_INT >= 23) {
            when(requestCode)
            {
                REQUEST_PERMISSION->
                {
                    if(!checkAllPermissions())
                    {
                    }
                    else
                    {
                        doActionWhenPermissioGrant()
                    }
                }
            }
        }
    }

    fun doActionWhenPermissioGrant()
    {

    }

    override fun observeViewModel(){
//        mainViewModel.mutableScreenState.observe(this) {
//            Log.d("로그", "$it")
//            when (it) {
//                ScreenState.RENDER -> shortShowToast("성공!")
//                ScreenState.ERROR -> shortShowToast("에러 발생!!")
//                else -> shortShowToast("알수없는 에러 발생!!")
//            }
//        }
//
//        mainViewModel.eventUserRepo.observe(this) {
//            it.let {
//                binding.responseTxt.text = it.id
//            }
//        }
    }
}