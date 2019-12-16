package mvvm.ktx

import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import common.ktx.activity

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Create Time :  2019-12-16. 11:53
 */
fun <T : ViewModel> AppCompatActivity.createViewModel(clazz: Class<T>) =
    ViewModelProviders.of(this).get(clazz)

fun <T : ViewDataBinding> AppCompatActivity.createDataBinding(layoutId: Int) = DataBindingUtil
    .bind<T>(LayoutInflater.from(activity).inflate(layoutId, null, false))!!