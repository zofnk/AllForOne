package com.allforone.http.function

import com.allforone.http.ApiException
import com.allforone.ktx.printTrace
import io.reactivex.observers.DisposableObserver

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  2019-11-22. 14:58
 */
class NetObservable<T> : DisposableObserver<T>() {

    lateinit var onStart: () -> Unit

    lateinit var onSuccess: (T) -> Unit

    lateinit var onError: (ApiException) -> Unit

    lateinit var onComplete: () -> Unit

    override fun onStart() {
        onStart.invoke()
    }

    override fun onComplete() {
        onComplete.invoke()
    }

    override fun onNext(t: T) {
        onSuccess.invoke(t)
    }

    override fun onError(e: Throwable) {
        e.printTrace()
        onError.invoke(e as ApiException)
    }
}