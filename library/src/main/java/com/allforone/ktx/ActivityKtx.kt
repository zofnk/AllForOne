package com.allforone.ktx

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  2019-11-11. 13:21
 */
fun <T : ViewModel> AppCompatActivity.createVM(clazz: Class<T>) =
    ViewModelProviders.of(this).get(clazz)

val AppCompatActivity.activity
    get() = this