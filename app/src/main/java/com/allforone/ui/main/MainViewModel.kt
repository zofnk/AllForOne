package com.allforone.ui.main

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.allforone.bean.BannerBean
import com.allforone.bean.ListResponse
import com.allforone.core.vm.BaseViewModel
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
            obs = object : Observer<ListResponse<BannerBean>> {
                override fun onSubscribe(d: Disposable) {
                }

                override fun onComplete() {
                }

                override fun onNext(t: ListResponse<BannerBean>) {
                    content.value = t.List[0].Content
                }

                override fun onError(e: Throwable) {

                }
            })
    }
}