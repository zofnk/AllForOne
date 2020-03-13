package com.allforone.ui.click

import android.app.Application
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import com.allforone.ui.api.NetRepository
import common.ktx.toast
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*
import mvvm.core.BaseViewModel
import mvvm.ktx.*

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Create Time :  2019-12-9. 10:49
 */
class ClickViewModel(app: Application) : BaseViewModel(app) {

    val funValue = "value"
    val countDownStr = ObservableField<String>("5秒")
    val viewEnabled = ObservableBoolean(true)

    val countDownStrRx = ObservableField<String>("5秒")
    val viewEnabledRx = ObservableBoolean(true)
    private val netRepo by lazy { NetRepository() }

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

    @FlowPreview
    @ExperimentalCoroutinesApi
    fun onCountDownClick() {
        launchUI {
            scheduleMain {
                emitFlow {
                    netRepo.searchAnimation2(key = "一")
                }
                    .flatMapMerge {
                        (4 downTo 0)
                            .asFlow()
                            .map { "${it}秒" }
                            .delayEach(1000)
                    }
                    .flowOn(Dispatchers.IO)
                    .onStart {
                        viewEnabled.set(false)
                        countDownStr.set("5秒")
                    }
                    .onCompletion {
                        viewEnabled.set(true)
                        countDownStr.set("5秒")
                    }
                    .onError {
                        viewEnabled.set(true)
                        countDownStr.set("请重试")
                        toast(it.msg)
                    }
                    .collect {
                        viewEnabled.set(false)
                        countDownStr.set(it)
                    }
            }
        }
    }

}











