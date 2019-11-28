package com.allforone.core.vm

import android.app.Application

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  2019-11-28. 09:24
 */
abstract class BaseListViewModel(app: Application) : BaseViewModel(app) {

    var page: Int = 1
    var size: Int = 10

    abstract fun onLoadMore(offset: Int)

    abstract fun onReload()

    fun initPage() {
        page = 10
    }

    val nextPage get() = page++
}