package mvvm.ktx

import common.http.ApiException
import common.ktx.errorHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlin.coroutines.CoroutineContext

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  12.17. 22:26
 */

/**
 * 创建并发射流事件
 *
 * 弃用(ctx: CoroutineContext = Dispatchers.IO 参数)说明:
 * 在每次emitFlow{}之前需要指定定接受者线程flowOn(ctx),如果只有1个就以那个为主
 * 所以此处如果添加了接受者线程,后续每次都在IO的话就都需要重新指定,比较不方便
 */
//@ExperimentalCoroutinesApi
fun <T> emitFlow(/*ctx: CoroutineContext = Dispatchers.IO,*/ func: suspend () -> T): Flow<T> =
    flow {
        emit(func.invoke())
    }
//        .flowOn(ctx)

//代替flow.catch{}
@ExperimentalCoroutinesApi
fun <T> Flow<T>.onError(func: (ApiException) -> Unit): Flow<T> {
    return catch {
        it.printStackTrace()
        func.invoke(it.errorHandler())
    }
}