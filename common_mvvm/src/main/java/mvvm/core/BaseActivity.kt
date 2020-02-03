package mvvm.core

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import common.core.common.CommonActivity
import mvvm.ktx.createViewModel
import java.lang.reflect.ParameterizedType

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  2019-11-29. 09:25
 */
abstract class BaseActivity<T : ViewDataBinding, V : BaseViewModel> : CommonActivity() {

    open val layoutBinding: T by lazy {
        DataBindingUtil.inflate<T>(layoutInflater, bindLayoutId(), null, false)
    }

    @Suppress("UNCHECKED_CAST")
    protected val viewModel: V by lazy {
        val type = javaClass.genericSuperclass
        val tp = (type as ParameterizedType).actualTypeArguments[1]
        val tClass = tp as Class<V>
        createViewModel(tClass)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        layoutBinding.lifecycleOwner = this
        //为ViewModel注入生命周期感知
        lifecycle.addObserver(viewModel)
        viewModel.injectLifecycleProvider(this)

        onCreated(savedInstanceState)
    }

    override fun onDestroy() {
        layoutBinding.unbind()
        super.onDestroy()
    }
}