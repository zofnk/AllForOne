package com.allforone.ui.main

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.allforone.bean.BannerBean
import com.allforone.bean.ListResponse
import com.allforone.bean.News
import com.allforone.bean.egbean.TopResult
import com.allforone.core.vm.BaseViewModel
import com.allforone.http.function.NetObservable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  11.21. 22:46
 */
class MainViewModel(app: Application) : BaseViewModel(app) {

    val content = MutableLiveData<String>()
    private val mainRepo: MainRepository by lazy { MainRepository() }

    override fun loadData() {
        //根据接口获取数据并反馈给v层(activity/fragment/xml)
        mainRepo.getBannerList(
            type = 1,
            area = 9,
            obs = object : NetObservable<ListResponse<BannerBean>>() {

                override fun onSuccess(t: ListResponse<BannerBean>) {
                    content.value = t.List[0].Content


                }

                override fun onError(msg: String) {
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
}