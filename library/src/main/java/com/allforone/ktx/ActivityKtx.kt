package com.allforone.ktx

import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.allforone.core.common.BaseActivity

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  2019-11-11. 13:21
 */
fun <T : ViewModel> AppCompatActivity.createViewModel(clazz: Class<T>) =
    ViewModelProviders.of(this).get(clazz)

fun <T : ViewDataBinding> AppCompatActivity.createDataBinding(layoutId: Int) = DataBindingUtil
    .bind<T>(LayoutInflater.from(activity).inflate(layoutId, null, false))!!

val AppCompatActivity.activity
    get() = this