package com.allforone.ktx

import com.allforone.data.NetResponse
import com.allforone.http.ApiConverts
import com.allforone.http.function.NetExceptionObservable
import com.allforone.http.function.NetObservable
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  11.21. 23:01
 */

/**
 * 线程调度器
 */
val <T> Observable<T>.scheduleTransformer: Observable<T>
    get() = subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())

/**
 * 请求转换器
 */
val <T, R : NetResponse<T>> Observable<R>.responseTransformer: Observable<T>
    get() = scheduleTransformer
        .map(ApiConverts())
        .onErrorResumeNext(NetExceptionObservable())

inline fun <T> Observable<T>.toSubscribe(func: NetObservable<T>.() -> Unit) {
    subscribe(NetObservable<T>().apply { func() })
}