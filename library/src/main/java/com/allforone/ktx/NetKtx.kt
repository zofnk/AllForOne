package com.allforone.ktx

import android.content.Context
import android.view.View
import androidx.fragment.app.Fragment
import com.allforone.utils.NetworkUtils

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  11.21. 20:38
 */
val Context.netAvailable
    get() = NetworkUtils.isNetWorkAvailable(this)

val Fragment.netAvailable
    get() = ctx.netAvailable

val View.netAvailable
    get() = ctx.netAvailable