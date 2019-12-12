package com.allforone.ktx

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import com.allforone.core.vm.BaseViewModel

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Create Time :  2019-11-22. 16:23
 */
val AndroidViewModel.ctx: Context get() = getApplication<Application>().applicationContext

fun AndroidViewModel.resString(resId: Int): String = ctx.resources.getString(resId)

fun <T> BaseViewModel.bindLifecycle() = lifecycleProvider?.bindToLifecycle<T>()
