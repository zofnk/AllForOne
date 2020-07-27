package common.ext

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import common.utils.DpUtil

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  2019-11-11. 11:19
 */

/**
 *  get dip trans about
 */
fun Context.dp2px(dip: Float): Int = DpUtil.dp2px(this, dip)

fun Context.px2dp(px: Int): Int = DpUtil.px2dp(this, px)

fun Context.px2sp(px: Float): Int = DpUtil.px2sp(this, px)

fun Context.sp2px(sp: Float): Int = DpUtil.sp2px(this, sp)

/**
 *
 */
fun Any.toJson(): String = Gson().toJson(this)

inline fun <reified T> String.toBean(): T = Gson().fromJson<T>(this, object : TypeToken<T>() {}.type)

