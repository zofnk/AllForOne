package com.allforone.http.function

import com.allforone.http.ApiException
import com.allforone.ktx.printTrace
import com.google.gson.JsonSyntaxException
import io.reactivex.observers.DisposableObserver
import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import java.util.concurrent.TimeoutException

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  2019-11-22. 14:58
 */
abstract class NetObservable<T> : DisposableObserver<T>() {

    abstract fun onError(msg: String)

    abstract fun onSuccess(t: T)

    override fun onComplete() {
    }

    override fun onNext(t: T) {
        onSuccess(t)
    }

    override fun onError(e: Throwable) {
        e.printTrace()
        onError(
            when (e) {
                is SocketTimeoutException -> "网络连接失败，请连接网络！"
                is ConnectException -> "服务器异常,请稍后重试！"
                is UnknownHostException -> "服务器连接异常，请重试！"
                is TimeoutException -> "网络连接超时,请重试！"
                is SocketException -> "HTTP连接异常,请重试！"
                is HttpException -> "网络连接失败，请连接网络！"
                is JsonSyntaxException -> "JSON解析异常,请重试！"
                is ApiException -> e.msg
                else -> "未知异常"
            }
        )
    }
}