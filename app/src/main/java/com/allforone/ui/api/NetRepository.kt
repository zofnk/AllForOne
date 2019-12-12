package com.allforone.ui.api

import com.allforone.core.repo.BaseRepository
import com.allforone.http.createApi
import com.allforone.ktx.responseTransformer
import com.allforone.ktx.scheduleTransformer

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
        area: Int
    ) = api
        .banner(type = type, area = area)
        .scheduleTransformer()
        .responseTransformer()

    fun getNews(
        type: String = "top",
        key: String = "9f552a8aca577737335c7106f1236a97"
    ) = api2
        .getNews(type, key)
        .scheduleTransformer()
        .responseTransformer()
        .map { it.data }


    //获取数据库数据 eg:
//    fun getData2Database() = "..."

}