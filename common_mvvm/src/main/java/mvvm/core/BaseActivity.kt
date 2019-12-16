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
        layoutBinding = createDataBinding(bindLayoutId())
        setContentView(layoutBinding.root)

        val type = javaClass.genericSuperclass
        val modelClass = ((type as ParameterizedType).actualTypeArguments)[1] as Class<V>
        viewModel = createViewModel(modelClass)
        lifecycle.addObserver(viewModel)
        viewModel.injectLifecycleProvider(this)

        onCreated(savedInstanceState)
    }
}