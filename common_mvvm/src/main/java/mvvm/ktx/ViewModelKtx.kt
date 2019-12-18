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
/**
 * 注入生命周期感知能力
 */
fun <T> BaseViewModel.injectLifecycle() = lifecycleProvider?.bindToLifecycle<T>()

//在ViewModel中启动协程域
fun ViewModel.launchUI(func: suspend CoroutineScope.() -> Unit) {
    viewModelScope.launch { func() }
}

/**
 * 普通的请求方式封装
 * Retrofit 2.6.2+ 支持协程,其本身动态代理应该自动做了切线程,
 * 故不需要再withContext(CoroutineContext = Dispatchers.IO)专门再指定请求的线程
 *
 */
fun <T> AndroidViewModel.createRequest(func: CoroutineResponseHandler<T>.() -> Unit) {
    val responseHandler = CoroutineResponseHandler<T>()
        .apply {
            func()
        }

    launchUI {
        responseHandler.onStart?.invoke()
        try {
            val response = responseHandler.onRequest?.invoke()
            responseHandler.onSuccess?.invoke(response!!)
        } catch (e: Exception) {
            e.printStackTrace()
            responseHandler.onError?.invoke(e.errorHandler())
        } finally {
            responseHandler.onComplete?.invoke()
        }
    }
}

/**
 * Flow流封装请求,类似RxJava的链式调用
 * 其实[createRequest]已经能满足大部分网络请求情况,
 * 这个[flowRequest]显得有些过度封装,不过在有些特定场景下会凸显其作用
 */
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