package com.allforone.ktx

import android.content.Context
import android.graphics.Point
import android.view.Display
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.allforone.utils.DpUtil
import com.allforone.utils.Toaster
import com.allforone.utils.WindowsUtil
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

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

fun AppCompatActivity.dp2px(dip: Float): Int = DpUtil.dp2px(this, dip)

fun AppCompatActivity.px2dp(px: Int): Int = DpUtil.px2dp(this, px)

fun AppCompatActivity.px2sp(px: Float): Int = DpUtil.px2sp(this, px)

fun AppCompatActivity.sp2px(sp: Float): Int = DpUtil.sp2px(this, sp)

fun Fragment.dp2px(dip: Float): Int = ctx.dp2px(dip)

fun Fragment.px2dp(px: Int): Int = ctx.px2dp(px)

fun Fragment.px2sp(px: Float): Int = ctx.px2sp(px)

fun Fragment.sp2px(sp: Float): Int = ctx.sp2px(sp)

fun View.dp2px(dip: Float): Int = ctx.dp2px(dip)

fun View.px2dp(px: Int): Int = ctx.px2dp(px)

fun View.px2sp(px: Float): Int = ctx.px2sp(px)

fun View.sp2px(sp: Float): Int = ctx.sp2px(sp)

/**
 * Toast
 */
fun Context.toast(str: CharSequence) {
    Toaster.toast(this, str)
}

fun Context.longToast(str: CharSequence) {
    Toaster.toast(this, str, Toast.LENGTH_LONG)
}

fun AppCompatActivity.toast(str: CharSequence) {
    Toaster.toast(this, str)
}

fun AppCompatActivity.longToast(str: CharSequence) {
    Toaster.toast(this, str, Toast.LENGTH_LONG)
}

fun Fragment.toast(str: CharSequence) {
    ctx.toast(str)
}

fun Fragment.longToast(str: CharSequence) {
    ctx.longToast(str)
}

fun View.toast(str: CharSequence) {
    ctx.toast(str)
}

fun View.longToast(str: CharSequence) {
    ctx.longToast(str)
}

/**
 * windows
 */
fun Context.windowsWidth(): Int = WindowsUtil.windowsWidth(this)

fun Context.windowsHeight(): Int = WindowsUtil.windowsHeight(this)

fun AppCompatActivity.windowsWidth(): Int = WindowsUtil.windowsWidth(this)

fun AppCompatActivity.windowsHeight(): Int = WindowsUtil.windowsHeight(this)

fun Fragment.windowsWidth(): Int = WindowsUtil.windowsWidth(ctx)

fun Fragment.windowsHeight(): Int = WindowsUtil.windowsHeight(ctx)

fun View.windowsWidth(): Int = WindowsUtil.windowsWidth(ctx)

fun View.windowsHeight(): Int = WindowsUtil.windowsHeight(ctx)

/**
 *
 */
fun Any.toJson(): String = Gson().toJson(this)

inline fun <reified T> String.toBean(): T = Gson().fromJson<T>(this, object : TypeToken<T>() {}.type)
