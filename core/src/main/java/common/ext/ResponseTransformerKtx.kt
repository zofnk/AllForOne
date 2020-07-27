package common.ext

import common.data.NetIResponse
import common.http.ApiException
import common.http.ExceptionHandle
import common.http.ResponseException

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Create Time :  11.21. 23:01
 */
//异常处理器
fun Throwable.exceptionTransformer(): ApiException {
    return if (this is ApiException) {
        this
    } else {
        ApiException(this, 0, message ?: "")
    }
}

//错误处理器
fun Throwable.errorHandler(): ApiException =
    ExceptionHandle
        .handleException(this)
        .exceptionTransformer()

fun <T> NetIResponse<T>.responseTransformer(): T {
    if (!isSuccess()) throw ResponseException(toJson())
    return response()
}