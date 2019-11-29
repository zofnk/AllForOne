package com.allforone.core.common

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding
import com.allforone.ktx.createDataBinding

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  2019-11-29. 09:25
 */
abstract class BaseActivity<T : ViewDataBinding> : AppCompatActivity() {

    abstract fun bindLayoutId(): Int
    abstract fun onCreated(savedInstanceState: Bundle?)
    lateinit var layoutBinding: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        layoutBinding = createDataBinding(bindLayoutId())
        setContentView(layoutBinding.root)
        onCreated(savedInstanceState)
    }
}