package com.allforone.ui.click

import android.app.Application
import common.ktx.toast
import mvvm.core.BaseViewModel
import mvvm.ktx.ctx

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Create Time :  2019-12-9. 10:49
 */
class ClickViewModel(app: Application) : BaseViewModel(app) {

    val funValue = "value"

    fun simpleClick() {
        ctx.toast("基本单击事件")
    }

    fun valueClick(str: String) {
        ctx.toast("单击带参数事件 -->  $str")
    }

    fun simpleLongClick() {
        ctx.toast("基本长按事件")
    }

    fun valueLonClick(str: String) {
        ctx.toast("长按带参数事件 --> $str")
    }
}