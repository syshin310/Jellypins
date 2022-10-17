package jellypins.org.widget.utils

import android.util.Log
import androidx.annotation.MainThread
import androidx.annotation.Nullable
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import java.util.concurrent.atomic.AtomicBoolean

/**
 * packageName    : jellypins.org.widget.utils
 * fileName       : ScreenState
 * author         : syshinpins
 * date           : 2022/06/06
 * description    :
 * ========================================================================================
 * VERSION      DATE             AUTHOR             NOTE
 * ----------------------------------------------------------------------------------------
 * 0.0.0        2022-06-06       syshinpins         최초 생성
 */
class SingleLiveEvent<T> : MutableLiveData<T>() {
    companion object {
        private const val TAG = "SingleLiveEvent"
    }

    val mPending:AtomicBoolean = AtomicBoolean(false)

    override fun observe(owner: LifecycleOwner, observer: Observer<in T>) {
        if(hasActiveObservers()) {
            Log.w(TAG, "Multiple observers registered but only one will be notified of changes.")
        }

        super.observe(owner) { t ->
            if (mPending.compareAndSet(true, false)) {
                observer.onChanged(t)
            }
        }
    }

    @MainThread
    override fun setValue(@Nullable t: T?) {
        mPending.set(true)
        super.setValue(t)
    }

    @MainThread
    fun call() {
        value = null
    }
}