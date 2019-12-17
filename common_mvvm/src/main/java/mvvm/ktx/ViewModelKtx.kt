package mvvm.ktx

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import common.http.ExceptionHandle
import common.http.function.CoroutineResponseHandler
import common.ktx.exceptionTransformer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import mvvm.core.BaseViewModel
import kotlinx.coroutines.launch

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Create Time :  2019-11-22. 16:23
 */

fun <T> BaseViewModel.injectLifecycle() = lifecycleProvider?.bindToLifecycle<T>()

//普通封装
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

//Flow封装
@ExperimentalCoroutinesApi
fun <T> AndroidViewModel.flowRequest(func: CoroutineResponseHandler<T>.() -> Unit) {
    val responseHandler = CoroutineResponseHandler<T>()
        .apply {
            func()
        }
    viewModelScope.launch {
        flow {
            emit(responseHandler.onRequest?.invoke())
        }
            .flowOn(Dispatchers.IO)
            .onStart {
                responseHandler.onStart?.invoke()
            }
            .onCompletion {
                responseHandler.onComplete?.invoke()
            }
            .catch {
                it.printStackTrace()
                val ex = ExceptionHandle.handleException(it)
                responseHandler.onError?.invoke(ex.exceptionTransformer())
            }
            .collect {
                responseHandler.onSuccess?.invoke(it!!)
            }
    }
}