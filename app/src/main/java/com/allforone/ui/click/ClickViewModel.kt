package com.allforone.ui.click

import android.app.Application
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.viewModelScope
import common.ktx.toast
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import mvvm.core.BaseViewModel
import mvvm.ktx.ctx
import mvvm.ktx.scheduleDefault

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Create Time :  2019-12-9. 10:49
 */
class ClickViewModel(app: Application) : BaseViewModel(app) {

    val funValue = "value"
    val countDownStr = ObservableField<String>("5秒")
    val viewEnabled = ObservableBoolean(true)

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

    @ExperimentalCoroutinesApi
    fun onCountDownClick() {
        viewModelScope.launch {
            scheduleDefault {
                flow {
                    (5 downTo 0).forEach {
                        emit("${it}秒")
                        delay(1000)
                    }
                }
                    .flowOn(Dispatchers.Main)
                    .onStart {
                        viewEnabled.set(false)
                        countDownStr.set("5秒")
                    }
                    .onCompletion {
                        viewEnabled.set(true)
                        countDownStr.set("5秒")
                    }
                    .collect {
                        viewEnabled.set(false)
                        countDownStr.set(it)
                    }
            }
        }
    }
}