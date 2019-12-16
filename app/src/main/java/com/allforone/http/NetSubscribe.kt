package com.allforone.http

import android.content.Context
import com.allforone.bean.newss
import common.ktx.netAvailable
import common.ktx.toast
import io.reactivex.observers.DisposableObserver

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  11.21. 20:43
 */
class NetSubscribe {

    companion object {
        fun getNews(
            context: Context,
            type: String,
            key: String,
            subscriber: DisposableObserver<newss>
        ) {
            if (context.netAvailable) {
                common.http.RetrofitFactory.getInstance().apply {
                    toSubscribe(create(NetApi::class.java).getNews(type, key), subscriber)
                }
            } else {
                context.toast("网络连接错误,请检查网络")
            }
        }

        fun postNews(
            context: Context,
            type: String,
            key: String,
            subscriber: DisposableObserver<newss>
        ) {
            if (context.netAvailable) {
                common.http.RetrofitFactory.getInstance().apply {
                    toSubscribe(create(NetApi::class.java).postNews(type, key), subscriber)
                }
            } else {
                context.toast("网络连接错误,请检查网络")
            }
        }
    }

}