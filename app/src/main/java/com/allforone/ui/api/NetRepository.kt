package com.allforone.ui.api

import com.allforone.http.BASE_URL_JUHE
import com.allforone.http.createApi
import common.core.repo.BaseRepository
import common.ktx.logE
import common.ktx.responseTransformer
import common.ktx.scheduleTransformer

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Create Time :  2019-11-29. 09:02
 */
class NetRepository : BaseRepository() {

    private val api by lazy { createApi(NetApi::class.java) }

    private val api2 by lazy { createApi(NetApi::class.java, BASE_URL_JUHE) }

    /**
     * RxJava
     */
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


    /**
     * Kotlin
     */
    suspend fun getBanner(
        type: Int,
        area: Int
    ) = api
        .banner2(type = type, area = area)
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