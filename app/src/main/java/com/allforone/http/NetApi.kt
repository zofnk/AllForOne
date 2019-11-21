package com.allforone.http

import com.allforone.bean.newss

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

/**
 * Created by zbf on 2018/3/27.
 *
 *
 * 存放所有的Api
 */

interface NetApi {

    @POST("toutiao/index")
    fun postNews(@Query("type") version: String, @Query("key") key: String): Observable<newss>

    @GET("toutiao/index")
    fun getNews(@Query("type") version: String, @Query("key") key: String): Observable<newss>

}
