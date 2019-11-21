package com.allforone.ui.main

import com.allforone.bean.newss
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
    fun getNews(@Query("type") version: String, @Query("key") key: String): Observable<newss>
}