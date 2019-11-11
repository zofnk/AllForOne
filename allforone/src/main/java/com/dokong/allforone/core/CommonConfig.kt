package com.dokong.allforone.core

import android.annotation.SuppressLint
import android.content.Context
import com.dokong.allforone.BuildConfig

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  11.11. 19:36
 */
@SuppressLint("StaticFieldLeak")
object CommonConfig {

    lateinit var context: Context
    var debug: Boolean = BuildConfig.DEBUG
    var defaultTagLog = "All4One"

    fun init(
        ctx: Context,
        isDebug: Boolean = BuildConfig.DEBUG,
        defaultTagLog: String = CommonConfig.defaultTagLog
    ) {
        this.context = ctx
        this.debug = isDebug
        this.defaultTagLog = defaultTagLog
    }

}