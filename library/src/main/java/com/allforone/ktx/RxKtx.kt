package com.allforone.ktx

import com.allforone.data.NetResponse
import com.allforone.http.ApiException
import com.allforone.http.ResponseHandle
import com.allforone.http.function.NetExceptionObservable
import com.allforone.http.function.HandleResponseObservable
import io.reactivex.Observable
import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Create Time :  11.21. 23:01
 */

/**
 * 线程调度器
 */
fun <T> Observable<T>.scheduleTransformer(): Observable<T> =
    subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())

/**
 * 请求转换器
 */
fun <T, R : NetResponse<T>> Observable<R>.responseTransformer(): Observable<T> =
    scheduleTransformer()
        .map(ResponseHandle())
        .onErrorResumeNext(NetExceptionObservable())

fun <T> schedulersTransformer(): ObservableTransformer<T, T> {
    return ObservableTransformer { upstream ->
        upstream
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}

fun <T : NetResponse<T>> responseTransformer(): ObservableTransformer<T, T> {
    return ObservableTransformer { upstream ->
        upstream
            .map<T>(ResponseHandle())
            .onErrorResumeNext(NetExceptionObservable())
    }
}

inline fun <T> Observable<T>.responseSubscribe(func: HandleResponseObservable<T>.() -> Unit) {
    subscribe(HandleResponseObservable<T>()
        .apply {
            func()
        })
}

fun <T> Observable<T>.handleError(func: (ApiException) -> Unit): Observable<T> = doOnError {
    func.invoke(it.exceptionTransformer())
}

fun <T> Observable<T>.handleNext(func: (T) -> Unit): Observable<T> = doOnNext { func.invoke(it) }