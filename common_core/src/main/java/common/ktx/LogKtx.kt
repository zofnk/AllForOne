package common.ktx

import com.socks.library.KLog
import common.core.CommonConfig

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  2019-11-6. 14:24
 */
private enum class Level {
    V, D, I, W, E
}

fun Any?.logV(msg: String?, tag: String = CommonConfig.defaultTagLog) {
    intervalLog(Level.V, tag, msg)
}

fun Any?.logD(msg: String?, tag: String = CommonConfig.defaultTagLog) {
    intervalLog(Level.D, tag, msg)
}

fun Any?.logI(msg: String?, tag: String = CommonConfig.defaultTagLog) {
    intervalLog(Level.I, tag, msg)
}

fun Any?.logW(msg: String?, tag: String = CommonConfig.defaultTagLog) {
    intervalLog(Level.W, tag, msg)
}

fun Any?.logE(msg: String?, tag: String = CommonConfig.defaultTagLog) {
    intervalLog(Level.E, tag, msg)
}

fun String?.logV(prefix: String = "") {
    logV(tag = CommonConfig.defaultTagLog, msg = "$prefix$this")
}

fun String?.logD(prefix: String = "") {
    logD(tag = CommonConfig.defaultTagLog, msg = "$prefix$this")
}

fun String?.logI(prefix: String = "") {
    logI(tag = CommonConfig.defaultTagLog, msg = "$prefix$this")
}

fun String?.logW(prefix: String = "") {
    logW(tag = CommonConfig.defaultTagLog, msg = "$prefix$this")
}

fun String?.logE(prefix: String = "") {
    logE(tag = CommonConfig.defaultTagLog, msg = "$prefix$this")
}

fun Throwable?.printTrace() {
    if (CommonConfig.debug) this?.printStackTrace()
}

private fun intervalLog(level: Level, tag: String, msg: String?) {
    if (CommonConfig.debug) {
        when (level) {
            Level.V -> KLog.v(tag, msg ?: "")
            Level.D -> KLog.d(tag, msg ?: "")
            Level.I -> KLog.i(tag, msg ?: "")
            Level.W -> KLog.w(tag, msg ?: "")
            Level.E -> KLog.e(tag, msg ?: "")
        }
    }
}