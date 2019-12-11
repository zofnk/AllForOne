package com.allforone.ui.api

import android.app.Application
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import com.allforone.bean.BannerBean
import com.allforone.bean.ListResponse
import com.allforone.bean.News
import com.allforone.core.vm.BaseViewModel
import com.allforone.http.function.NetObservable
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
        //根据接口获取数据并反馈给v层(activity/fragment/xml)
        mainRepo.getBannerList(
            type = 1,
            area = 9,
            obs = object : NetObservable<ListResponse<BannerBean>>() {

                override fun onSuccess(t: ListResponse<BannerBean>) {
                    content.value = t.List.toString()
                    viewContent.set(t.List.toString())
                }

                override fun onError(msg: String) {
                    content.value = msg
                    viewContent.set(msg)
                }
            })
    }

    fun api2() {
        mainRepo.getNews(obs = object : NetObservable<List<News>>() {

            override fun onSuccess(t: List<News>) {
                content.value = t[0].title
            }

            override fun onError(msg: String) {
            }
        })
    }

    fun api3() {
        mainRepo.getNews(obs = object : NetObservable<List<News>>() {

            override fun onSuccess(t: List<News>) {
                content.value = t[0].title
            }

            override fun onError(msg: String) {
            }
        })
    }
}