package jellypins.org.base

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

/**
 * packageName    : jellypins.org.base
 * fileName       : BaseLogFragment
 * author         : syshin310
 * date           : 2022-06-14
 * description    : 프래그먼트 생명주기 로깅
 * ========================================================================================
 * VERSION      DATE             AUTHOR             NOTE
 * ----------------------------------------------------------------------------------------
 * 0.0.0        2022-06-14       syshin310          최초 생성
 */
open class BaseLogFragment : Fragment(){
    companion object {
        const val TAG_LOGGER_LIFE = "[LifeCycle]"
    }

    /**
     *  Fragment Lifecycle Start
     */
    // @Deprecated
    override fun onAttachFragment(childFragment: Fragment) {
        Log.v("$this $TAG_LOGGER_LIFE", "onAttachFragment - childFragment $childFragment")
        super.onAttachFragment(childFragment)
    }

    override fun onAttach(context: Context) {
        Log.v("$this $TAG_LOGGER_LIFE", "onAttach ")
        super.onAttach(context)
    }

    // @Deprecated
    override fun onAttach(activity: Activity) {
        Log.v("$this $TAG_LOGGER_LIFE", "onAttach on activity $activity")
        super.onAttach(activity)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.v("$this $TAG_LOGGER_LIFE", "onCreate / $savedInstanceState")
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.v("$this $TAG_LOGGER_LIFE", "onCreateView / $savedInstanceState")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.v("$this $TAG_LOGGER_LIFE", "onViewCreated / $savedInstanceState")
        super.onViewCreated(view, savedInstanceState)
    }

    // @Deprecated
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Log.v("$this $TAG_LOGGER_LIFE", "onActivityCreated / $savedInstanceState")
        super.onActivityCreated(savedInstanceState)
    }

    // State Save
    override fun onSaveInstanceState(outState: Bundle) {
        Log.v("$this $TAG_LOGGER_LIFE", "onSaveInstanceState / $outState")
        super.onSaveInstanceState(outState)
    }

    // State Restore
    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        Log.v("$this $TAG_LOGGER_LIFE", "onViewStateRestored / $savedInstanceState")
        super.onViewStateRestored(savedInstanceState)
    }

    override fun onStart() {
        Log.v("$this $TAG_LOGGER_LIFE", "onStart ")
        super.onStart()
    }

    override fun onResume() {
        Log.v("$this $TAG_LOGGER_LIFE", "onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.v("$this $TAG_LOGGER_LIFE", "onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.v("$this $TAG_LOGGER_LIFE", "onStop ")
        super.onStop()
    }

    override fun onDestroyView() {
        Log.v("$this $TAG_LOGGER_LIFE", "onDestroyView")
        super.onDestroyView()
    }

    override fun onDestroy() {
        Log.v("$this $TAG_LOGGER_LIFE", "onDestroy ")
        super.onDestroy()
    }

    override fun onDetach() {
        Log.v("$this $TAG_LOGGER_LIFE", "onDetach")
        super.onDetach()
    }

    /**
     *  Fragment Lifecycle Finish
     */

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        Log.v("$this $TAG_LOGGER_LIFE", "onActivityResult requestCode:$requestCode resultCode:$resultCode data=$data")
        super.onActivityResult(requestCode, resultCode, data)
    }

    override fun onHiddenChanged(hidden: Boolean) {
        Log.v("$this $TAG_LOGGER_LIFE", "onHiddenChanged hidden:$hidden")
        super.onHiddenChanged(hidden)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        Log.v("$this $TAG_LOGGER_LIFE", "onRequestPermissionsResult requestCode:$requestCode permissions:$permissions grantResults:$grantResults")
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

//    override fun onCreateContextMenu(menu: ContextMenu, v: View, menuInfo: ContextMenu.ContextMenuInfo?) {
//         Log.v("$this $TAG_LOGGER_LIFE", "onCreateContextMenu - $menu")
//        super.onCreateContextMenu(menu, v, menuInfo)
//    }
//    override fun onContextItemSelected(item: MenuItem): Boolean {
//         Log.v("$this $TAG_LOGGER_LIFE", "onContextItemSelected - $item")
//        return super.onContextItemSelected(item)
//    }
//
//    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
//         Log.v("$this $TAG_LOGGER_LIFE", "onCreateOptionsMenu - $menu")
//        super.onCreateOptionsMenu(menu, inflater)
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//         Log.v("$this $TAG_LOGGER_LIFE", "onOptionsItemSelected - $item")
//        return super.onOptionsItemSelected(item)
//    }
//
//    override fun onPrepareOptionsMenu(menu: Menu) {
//         Log.v("$this $TAG_LOGGER_LIFE", "onPrepareOptionsMenu - $menu")
//        super.onPrepareOptionsMenu(menu)
//    }
//
//    override fun onOptionsMenuClosed(menu: Menu) {
//         Log.v("$this $TAG_LOGGER_LIFE", "onOptionsMenuClosed - $menu")
//        super.onOptionsMenuClosed(menu)
//    }
//
//    override fun onDestroyOptionsMenu() {
//         Log.v("$this $TAG_LOGGER_LIFE", "onDestroyOptionsMenu")
//        super.onDestroyOptionsMenu()
//    }
//
//    override fun onCreateAnimation(transit: Int, enter: Boolean, nextAnim: Int): Animation? {
//         Log.v("$this $TAG_LOGGER_LIFE", "onCreateAnimation $this $transit")
//        return super.onCreateAnimation(transit, enter, nextAnim)
//    }
//
//    override fun onCreateAnimator(transit: Int, enter: Boolean, nextAnim: Int): Animator? {
//         Log.v("$this $TAG_LOGGER_LIFE", "onCreateAnimator $this $transit")
//        return super.onCreateAnimator(transit, enter, nextAnim)
//    }

    override fun onLowMemory() {
        Log.v("$this $TAG_LOGGER_LIFE", "onLowMemory -")
        super.onLowMemory()
    }

    override fun toString(): String {
        super.toString()
        val sb = StringBuilder(128)
        val cls: Class<*> = javaClass
        sb.append(cls.simpleName)
        sb.append("{")
        sb.append(Integer.toHexString(System.identityHashCode(this)))
        sb.append("}")
        return sb.toString()
    }
}