package com.allforone.bean

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  2019-11-22. 09:58
 */
data class BannerResponse(
    val Id: Int,
    val Title: String,
    val Content: String,
    val AreaType: Int,
    val AnimeName: String,
    val AnimeId: Int,
    val Url: String,
    val BeginTime: String,
    val EndTime: String,
    val OrderBy: Int,
    val Img: String,
    val InsertTime: String,
    val Type: Int,
    val TypeId: Int
)

data class ListResponse<T>(
    val TotalCount: Int,
    val TotalPage: Int,
    val StateCode: Int,
    val List: List<T>
)