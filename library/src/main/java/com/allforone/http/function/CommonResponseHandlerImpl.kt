package com.allforone.http.function

import com.allforone.http.ApiException

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Create Time :  2019-12-13. 13:40
 */
interface CommonResponseHandlerImpl<T> {

    var onStart: (() -> Unit)?

    var onSuccess: ((T) -> Unit)?

    var onError: ((ApiException) -> Unit)?

    var onComplete: (() -> Unit)?
}