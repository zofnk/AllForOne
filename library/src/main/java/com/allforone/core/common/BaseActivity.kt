package com.allforone.core.common

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import com.allforone.core.vm.BaseViewModel
import com.allforone.ktx.createDataBinding
import com.allforone.ktx.createViewModel
import com.trello.rxlifecycle3.components.support.RxAppCompatActivity
import java.lang.reflect.ParameterizedType

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  2019-11-29. 09:25
 */
abstract class BaseActivity<T : ViewDataBinding, V : BaseViewModel> : RxAppCompatActivity() {

    abstract fun bindLayoutId(): Int
    abstract fun onCreated(savedInstanceState: Bundle?)
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