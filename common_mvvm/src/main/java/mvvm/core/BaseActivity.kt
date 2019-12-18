package mvvm.core

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import common.core.common.CommonActivity
import mvvm.ktx.createDataBinding
import mvvm.ktx.createViewModel
import java.lang.reflect.ParameterizedType

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  2019-11-29. 09:25
 */
abstract class BaseActivity<T : ViewDataBinding, V : BaseViewModel> : CommonActivity() {

    lateinit var layoutBinding: T
    lateinit var viewModel: V

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        createBinding()
        createVM()
        onCreated(savedInstanceState)
    }

    private fun createBinding() {
        layoutBinding = createDataBinding(bindLayoutId())
        setContentView(layoutBinding.root)
    }

    @Suppress("UNCHECKED_CAST")
    private fun createVM() {
        val type = javaClass.genericSuperclass
        if (type is ParameterizedType) {
            val tp = type.actualTypeArguments[1]
            val tClass = tp as Class<V>
            viewModel = createViewModel(tClass)
        }

        //为ViewModel注入生命周期感知
        lifecycle.addObserver(viewModel)
        viewModel.injectLifecycleProvider(this)
    }
}