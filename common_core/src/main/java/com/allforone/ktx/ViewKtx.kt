package com.allforone.ktx

import android.content.Context
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
fun View.click(action: (v: View) -> Unit) {
    //之后需要修改为防抖点击
    setOnClickListener { action(it) }
}

fun View.longClick(action: (v: View) -> Unit) {
    setOnLongClickListener {
        action(it)
        return@setOnLongClickListener true
    }
}