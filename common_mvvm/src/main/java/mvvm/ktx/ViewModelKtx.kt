package mvvm.ktx

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import common.http.ExceptionHandle
import common.http.function.CoroutineResponseHandler
import common.ktx.exceptionTransformer
import mvvm.core.BaseViewModel
import kotlinx.coroutines.launch

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Create Time :  2019-11-22. 16:23
 */

fun <T> BaseViewModel.injectLifecycle() = lifecycleProvider?.bindToLifecycle<T>()

fun <T> AndroidViewModel.createRequest(func: CoroutineResponseHandler<T>.() -> Unit) {

    val responseHandler = CoroutineResponseHandler<T>()
        .apply {
            func()
        }

    viewModelScope.launch {
        scheduleMain {
            responseHandler.onStart?.invoke()
        }
        try {
            val response = scheduleIO {
                responseHandler.onRequest?.invoke()
            }
            scheduleMain {
                responseHandler.onSuccess?.invoke(response!!)
            }
        } catch (e: Exception) {
            e.printStackTrace()
            val ex = ExceptionHandle.handleException(e)
            responseHandler.onError?.invoke(ex.exceptionTransformer())
        } finally {
            responseHandler.onComplete?.invoke()
        }
    }
}