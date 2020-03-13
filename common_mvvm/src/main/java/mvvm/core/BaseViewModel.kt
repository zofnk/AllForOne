package mvvm.core

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import mvvm.impl.IBaseViewModel
import java.lang.ref.WeakReference

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  11.21. 22:47
 */
open class BaseViewModel(app: Application) : AndroidViewModel(app), IBaseViewModel {

    override fun onAny(owner: LifecycleOwner, event: Lifecycle.Event) {}

    override fun onCreate() {}

    override fun onDestroy() {}

    override fun onStart() {}

    override fun onStop() {}

    override fun onResume() {}

    override fun onPause() {}
}