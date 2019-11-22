package com.allforone.http.function

import io.reactivex.Observable
import io.reactivex.functions.Function

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  2019-11-22. 09:15
 */
class NetExceptionObservable<T> : Function<Throwable, Observable<T>> {
    override fun apply(t: Throwable): Observable<T> = Observable.error(t)
}