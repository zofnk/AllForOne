package common.ktx

import common.http.ApiException
import common.http.ExceptionHandle


/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  12.12. 23:07
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