package jellypins.org

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp

/**
 * packageName    : jellypins.org.di
 * fileName       : App
 * author         : syshinpins
 * date           : 2022/06/06
 * description    : Application 클래스
 *                  Hilt Components 생성
 * ========================================================================================
 * VERSION      DATE             AUTHOR             NOTE
 * ----------------------------------------------------------------------------------------
 * 0.0.0        2022-06-06       syshinpins         최초 생성
 */
@HiltAndroidApp
class App : Application() {
    companion object {
        private lateinit var application: App
        fun getInstance() : App = application
        fun ApplicationContext() : Context {
            return application.applicationContext
        }
    }

    override fun onCreate() {
        super.onCreate()
        application = this
    }
}