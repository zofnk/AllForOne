package com.allforone.ktx

import android.content.Context
import android.opengl.Visibility
import android.view.View

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  2019-11-11. 11:38
 */
val View.ctx: Context
    get() = context

fun View.gone() {
    visibility = View.GONE
}

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

val View.isGone: Boolean get() = visibility == View.GONE

val View.isVisible: Boolean get() = visibility == View.VISIBLE

val View.isInvisible: Boolean get() = visibility == View.INVISIBLE

fun View.toggleVisible() {
    if (isVisible) gone() else visible()
}

//点击
fun View.click(click: (v: View) -> Unit) {
    setOnClickListener { click(it) }
}

fun View.longClick(click: (v: View) -> Boolean) {
    setOnLongClickListener { click(it) }
}