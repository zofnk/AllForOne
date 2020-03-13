package com.allforone.ui.api

import com.allforone.bean.*
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  11.21. 22:53
 */
interface NetApi {

    /**
     * Kotlin Coroutine
     */

    @GET("/animes?AdList")
    suspend fun banner2(
        @Query("areaType") type: Int,
        @Query("pageIndex") page: Int = 1,
        @Query("pageSize") size: Int = 10,
        @Query("area") area: Int
    ): ApiBaseResp<ListResponse<BannerBean>>

    @GET("/animes?search")
    suspend fun searchAnimation2(
        @Query("keyword") key: String,
        @Query("pageIndex") page: Int,
        @Query("pageSize") size: Int,
        @Query("loginToken") token: String
    ): ApiBaseResp<SearchListBean<SearchBean>>
}