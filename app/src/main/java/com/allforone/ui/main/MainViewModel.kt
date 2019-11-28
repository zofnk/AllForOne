package com.allforone.ui.main

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.allforone.MultiAdapter
import com.allforone.MultiBean
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
    val mainAdapter by lazy { MultiAdapter() }

    init {
        val data = listOf(
            MultiBean(1, "TEXT"),
            MultiBean(
                2,
                "https://user-gold-cdn.xitu.io/2019/11/8/16e4926b45ab6d18?imageView2/0/w/1280/h/960/format/webp/ignore-error/1"
            ),
            MultiBean(1, "TEXT"),
            MultiBean(
                2,
                "https://user-gold-cdn.xitu.io/2019/11/8/16e4926b45ab6d18?imageView2/0/w/1280/h/960/format/webp/ignore-error/1"
            ),
            MultiBean(1, "TEXT"),
            MultiBean(
                2,
                "https://user-gold-cdn.xitu.io/2019/11/8/16e4926b45ab6d18?imageView2/0/w/1280/h/960/format/webp/ignore-error/1"
            )
        )
        mainAdapter.setNewData(data)
    }

    fun loadData() {
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