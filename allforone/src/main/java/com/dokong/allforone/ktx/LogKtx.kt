package com.dokong.allforone.ktx

import com.dokong.allforone.core.CommonConfig
import com.socks.library.KLog

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  2019-11-6. 14:24
 */
private enum class Level {
    V, D, I, W, E
}

fun Any.logV(tag: String = CommonConfig.defaultTagLog, msg: String) {
    intervalLog(Level.V, tag, msg)
}

fun Any.logD(tag: String = CommonConfig.defaultTagLog, msg: String) {
    intervalLog(Level.D, tag, msg)
}

fun Any.logI(tag: String = CommonConfig.defaultTagLog, msg: String) {
    intervalLog(Level.I, tag, msg)
}

fun Any.logW(tag: String = CommonConfig.defaultTagLog, msg: String) {
    intervalLog(Level.W, tag, msg)
}

fun Any.logE(tag: String = CommonConfig.defaultTagLog, msg: String) {
    intervalLog(Level.E, tag, msg)
}

fun String.logV(tag: String = CommonConfig.defaultTagLog) {
    logV(tag, this)
}

fun String.logD(tag: String = CommonConfig.defaultTagLog) {
    logD(tag, this)
}

fun String.logI(tag: String = CommonConfig.defaultTagLog) {
    logI(tag, this)
}

fun String.logW(tag: String = CommonConfig.defaultTagLog) {
    logW(tag, this)
}

fun String.logE(tag: String = CommonConfig.defaultTagLog) {
    logE(tag, this)
}

fun Throwable?.printStackTrace() {
    if (CommonConfig.debug) this?.printStackTrace()
}

private fun intervalLog(level: Level, tag: String, msg: String) {
    if (CommonConfig.debug) {
        when (level) {
            Level.V -> KLog.v(tag, msg)
            Level.D -> KLog.d(tag, msg)
            Level.I -> KLog.i(tag, msg)
            Level.W -> KLog.w(tag, msg)
            Level.E -> KLog.e(tag, msg)
        }
    }
}