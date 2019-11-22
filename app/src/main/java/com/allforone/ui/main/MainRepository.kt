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

    private val api: MainApi by lazy { createApi(clazz = MainApi::class.java) }

    fun getBannerList(
        type: Int,
        area: Int,
        obs: Observer<ListResponse<BannerBean>>
    ) {
        api.banner(type = type, area = area)
            .convers
            .subscribe(obs)
    }
}