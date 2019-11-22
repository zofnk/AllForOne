package com.allforone.ui.main

import com.allforone.bean.*
import com.allforone.bean.egbean.TopBean
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  11.21. 22:53
 */
interface MainApi {

    @POST("toutiao/index")
    fun postNews(@Query("type") version: String, @Query("key") key: String): Observable<newss>

    @GET("toutiao/index")
    fun getNews(@Query("type") version: String, @Query("key") key: String): Observable<TopBean<List<News>>>

    @GET("/animes?AdList")
    fun banner(
        @Query("areaType") type: Int,
        @Query("pageIndex") page: Int = 1,
        @Query("pageSize") size: Int = 10,
        @Query("area") area: Int
    ): Observable<ApiBaseResp<ListResponse<BannerBean>>>
}