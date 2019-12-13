package com.allforone.ui.api

import com.allforone.core.repo.BaseRepository
import com.allforone.http.BASE_URL_JUHE
import com.allforone.http.createApi
import com.allforone.ktx.responseTransformer
import com.allforone.ktx.scheduleTransformer

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Create Time :  2019-11-29. 09:02
 */
class NetRepository : BaseRepository() {

    private val api by lazy { createApi(NetApi::class.java) }

    private val api2 by lazy { createApi(NetApi::class.java, BASE_URL_JUHE) }

    //获取请求来的数据
    fun getBannerList(
        type: Int,
        area: Int
    ) = api
        .banner(type = type, area = area)
        .scheduleTransformer()
        .responseTransformer()

    fun searchAnimation(
        key: String,
        page: Int = 1,
        size: Int = 1000,
        token: String = ""
    ) = api
        .searchAnimation(key, page, size, token)
        .scheduleTransformer()
        .responseTransformer()

    suspend fun searchAnimation2(
        key: String,
        page: Int = 1,
        size: Int = 1000,
        token: String = ""
    ) = api
        .searchAnimation2(key, page, size, token)
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