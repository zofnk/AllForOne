package mvvm.ktx

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import common.http.ApiException
import common.http.ExceptionHandle
import common.http.function.CoroutineResponseHandler
import common.ktx.errorHandler
import common.ktx.exceptionTransformer
import kotlinx.coroutines.CoroutineScope
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

//在ViewModel中启动协程域
fun ViewModel.launchUI(func: suspend CoroutineScope.() -> Unit) {
    viewModelScope.launch { func() }
}

//普通的请求方式封装
fun <T> AndroidViewModel.createRequest(func: CoroutineResponseHandler<T>.() -> Unit) {
    val responseHandler = CoroutineResponseHandler<T>()
        .apply {
            func()
        }

    launchUI {
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
            responseHandler.onError?.invoke(e.errorHandler())
        } finally {
            responseHandler.onComplete?.invoke()
        }
    }
}

//Flow流封装请求
@ExperimentalCoroutinesApi
fun <T> AndroidViewModel.flowRequest(func: CoroutineResponseHandler<T>.() -> Unit) {
    val responseHandler = CoroutineResponseHandler<T>()
        .apply {
            func()
        }
    launchUI {
        emitFlow {
            responseHandler.onRequest?.invoke()
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
                responseHandler.onError?.invoke(it.errorHandler())
            }
            .collect {
                responseHandler.onSuccess?.invoke(it!!)
            }
    }
}