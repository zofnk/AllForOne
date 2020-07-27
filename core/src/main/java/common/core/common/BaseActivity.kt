package common.core.common

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Create Time :  2019-12-16. 11:31
 */
abstract class BaseActivity : AppCompatActivity(), CoroutineScope by MainScope() {

    protected inline fun <reified T : ViewDataBinding> binding(
        @LayoutRes layoutId: Int
    ): Lazy<T> = lazy {
        DataBindingUtil.setContentView<T>(this, layoutId)
    }

    protected inline fun <reified T : ViewModel> viewModels(): Lazy<T> = lazy {
        ViewModelProvider(this).get(T::class.java)
    }

    abstract fun init(savedInstanceState: Bundle?)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init(savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()
        cancel()
    }
}