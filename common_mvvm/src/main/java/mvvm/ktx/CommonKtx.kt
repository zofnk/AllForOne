package mvvm.ktx

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import common.ktx.toast
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Create Time :  2019-12-16. 11:27
 */

val AndroidViewModel.ctx: Context get() = getApplication<Application>().applicationContext

fun AndroidViewModel.resString(resId: Int): String = ctx.resources.getString(resId)

fun AndroidViewModel.toast(str: CharSequence) {
    ctx.toast(str)
}

fun AndroidViewModel.toast(str: String) {
    ctx.toast(str)
}

suspend fun <T> AndroidViewModel.scheduleIO(
    dispatcher: CoroutineContext = Dispatchers.IO,
    func: suspend () -> T
): T =
    withContext(dispatcher) {
        func.invoke()
    }

suspend fun <T> AndroidViewModel.scheduleMain(
    func: suspend () -> T
): T =
    scheduleIO(Dispatchers.Main) {
        func.invoke()
    }

suspend fun <T> AndroidViewModel.scheduleDefault(
    func: suspend () -> T
): T =
    scheduleIO(Dispatchers.Default) {
        func.invoke()
    }

/*
 * SingleLiveData 发送空消息需 postValue(Unit)
 */
fun <T> MutableLiveData<T>.ofObserver(owner: LifecycleOwner, block: (T) -> Unit) =
    observe(owner, Observer { block.invoke(it) })