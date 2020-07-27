package common.core.repo

import common.ext.Net
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext


/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  11.21. 22:50
 */
open class BaseRepository {

    suspend fun <T> inIO(
        context: CoroutineContext = Dispatchers.IO,
        block: suspend CoroutineScope.() -> T
    ): T = withContext(context, block)

    fun <T> config(baseUrl: String, clazz: Class<T>): T = Net.baseUrl(baseUrl).build().create(clazz)
}