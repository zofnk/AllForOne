package common.ktx

import com.socks.library.KLog
import common.core.CommonConfig

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  2019-11-6. 14:24
 */
fun Any?.logV(tag: String = CommonConfig.defaultTagLog) {
    KLog.v(tag, this ?: "null")
}

fun Any?.logD(tag: String = CommonConfig.defaultTagLog) {
    KLog.d(tag, this ?: "null")
}

fun Any?.logI(tag: String = CommonConfig.defaultTagLog) {
    KLog.i(tag, this ?: "null")
}

fun Any?.logW(tag: String = CommonConfig.defaultTagLog) {
    KLog.w(tag, this ?: "null")
}

fun Any?.logE(tag: String = CommonConfig.defaultTagLog) {
    KLog.e(tag, this ?: "null")
}

fun Throwable?.printTrace() {
    if (CommonConfig.debug) this?.printStackTrace()
}