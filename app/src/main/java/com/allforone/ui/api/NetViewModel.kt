package com.allforone.ui.api

import android.app.Application
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import com.allforone.core.vm.BaseViewModel
import com.allforone.ktx.injectLifecycle
import com.allforone.ktx.responseSubscribe
import com.allforone.ktx.toast

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  2019-11-29. 09:03
 */
class NetViewModel(app: Application) : BaseViewModel(app) {

    val content = MutableLiveData<String>()
    val viewContent = ObservableField<String>()
    private val mainRepo by lazy { NetRepository() }

    fun loadDataWithRx() {
        mainRepo
            .getBannerList(type = 1, area = 9)
            .compose(injectLifecycle())
            .responseSubscribe {

                onStart = {
                    toast("开始请求")
                }

                onSuccess = {
                    content.value = it.List.toString()
                    viewContent.set(it.List.toString())
                }

                onError = {
                    content.value = it.msg
                    viewContent.set(it.msg)
                    toast(it.msg)
                }

                onComplete = {
                    toast("请求结束")
                }
            }
    }
}