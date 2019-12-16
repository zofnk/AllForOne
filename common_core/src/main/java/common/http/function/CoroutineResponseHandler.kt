package common.http.function

import common.http.ApiException


/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Create Time :  2019-12-13. 13:46
 */
class CoroutineResponseHandler<T> : CommonResponseHandlerImpl<T> {

    var onRequest: (suspend () -> T)? = null

    override var onStart: (() -> Unit)? = null

    override var onSuccess: ((T) -> Unit)? = null

    override var onError: ((ApiException) -> Unit)? = null

    override var onComplete: (() -> Unit)? = null
}