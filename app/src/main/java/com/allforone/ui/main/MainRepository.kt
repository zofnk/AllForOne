package com.allforone.ui.main

import com.allforone.bean.BannerBean
import com.allforone.bean.ListResponse
import com.allforone.core.repo.BaseRepository
import com.allforone.http.createApi
import com.allforone.ktx.convers
import io.reactivex.Observer
import io.reactivex.observers.DisposableObserver

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  11.21. 22:51
 */
class MainRepository : BaseRepository() {

    //main界面api接口 , 这里可以和mvp模式拓展一下
    private val api: MainApi by lazy { createApi(MainApi::class.java) }

    //获取请求来的数据
    fun getBannerList(
        type: Int,
        area: Int,
        obs: Observer<ListResponse<BannerBean>>
    ) {
        api.banner(type = type, area = area)
            .convers
            .subscribe(obs)
    }

    //获取数据库数据 eg:
//    fun getData2Database() = "..."

}