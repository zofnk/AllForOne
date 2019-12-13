package com.allforone.http.function

import com.allforone.http.ApiException
import com.allforone.ktx.exceptionTransformer
import io.reactivex.observers.DisposableObserver

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  2019-11-22. 14:58
 */
class HandleResponseObservable<T> : DisposableObserver<T>(), CommonResponseHandlerImpl<T> {

    override var onStart: (() -> Unit)? = null

    override var onSuccess: ((T) -> Unit)? = null

    override var onError: ((ApiException) -> Unit)? = null

    override var onComplete: (() -> Unit)? = null

    override fun onStart() {
        onStart?.invoke()
    }

    override fun onComplete() {
        onComplete?.invoke()
    }

    override fun onNext(t: T) {
        onSuccess?.invoke(t)
    }

    override fun onError(e: Throwable) {
        e.apply {
            printStackTrace()
            onError?.invoke(exceptionTransformer())
        }
    }
}