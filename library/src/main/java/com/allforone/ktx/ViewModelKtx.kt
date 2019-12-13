package com.allforone.ktx

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.allforone.core.vm.BaseViewModel
import com.allforone.http.ExceptionHandle
import com.allforone.http.function.CoroutineResponseHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Create Time :  2019-11-22. 16:23
 */
val AndroidViewModel.ctx: Context get() = getApplication<Application>().applicationContext

fun AndroidViewModel.resString(resId: Int): String = ctx.resources.getString(resId)

fun <T> BaseViewModel.injectLifecycle() = lifecycleProvider?.bindToLifecycle<T>()

suspend fun <T> AndroidViewModel.dispatchersIO(
    dispatcher: CoroutineContext = Dispatchers.IO,
    func: suspend () -> T
): T =
    withContext(dispatcher) {
        func.invoke()
    }

suspend fun <T> AndroidViewModel.dispatchersMain(
    func: suspend () -> T
): T =
    dispatchersIO(Dispatchers.Main) {
        func.invoke()
    }


fun <T> AndroidViewModel.createRequest(func: CoroutineResponseHandler<T>.() -> Unit) {

    val responseHandler = CoroutineResponseHandler<T>()
        .apply {
            func()
        }

    viewModelScope.launch {
        dispatchersMain {
            responseHandler.onStart?.invoke()
        }
        try {
            val response = dispatchersIO {
                responseHandler.onRequest?.invoke()
            }
            dispatchersMain {
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