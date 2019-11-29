package com.allforone.ui.api

import com.allforone.bean.BannerBean
import com.allforone.bean.ListResponse
import com.allforone.bean.News
import com.allforone.core.repo.BaseRepository
import com.allforone.http.createApi
import com.allforone.ktx.converts
import io.reactivex.Observer

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  2019-11-29. 09:02
 */
class NetRepository : BaseRepository() {

    private val api by lazy { createApi(NetApi::class.java) }

    private val api2 by lazy { createApi(NetApi::class.java, "https://v.juhe.cn/") }

    //获取请求来的数据
    fun getBannerList(
        type: Int,
        area: Int,
        obs: Observer<ListResponse<BannerBean>>
    ) {
        api.banner(type = type, area = area)
            .converts
            .subscribe(obs)
    }

    fun getNews(
        type: String = "top",
        key: String = "9f552a8aca577737335c7106f1236a97",
        obs: Observer<List<News>>
    ) {
        api2.getNews(type, key)
            .converts
            .map { it.data }
            .subscribe(obs)
    }

    //获取数据库数据 eg:
//    fun getData2Database() = "..."

}