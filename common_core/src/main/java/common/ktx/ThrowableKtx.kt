package common.ktx

import common.http.ApiException


/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  12.12. 23:07
 */
fun Throwable.exceptionTransformer(): ApiException {
    return if (this is ApiException) {
        this
    } else {
        ApiException(this, 0, message ?: "")
    }
}