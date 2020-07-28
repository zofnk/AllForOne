package com.allforone.http

import com.allforone.bean.ApiBaseResp
import com.allforone.bean.BannerResponse
import com.allforone.bean.ListResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  2020/7/28. 19:04
 */
interface ApiService {

    @POST("/animes?AdList")
    suspend fun banner(
        @Query("areaType") areaType: Int,
        @Query("pageIndex") page: Int,
        @Query("pageSize") size: Int,
        @Query("area") area: Int
    ): ApiBaseResp<ListResponse<BannerResponse>>

}