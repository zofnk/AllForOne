package com.allforone.bean

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  12.12. 21:23
 */
data class SearchListBean<T>(
    val TotalNewsCount: Int = 0,
    val TotalQuestionCount: Int = 0,
    val TotalAnimeCount: Int = 0,
    val TotalCount: Int = 0,
    val TotalPage: Int = 0,
    val List: List<T> = ArrayList()
)

data class SearchBean(
    val Name: String,
    val JpName: String,
    val CoverImg: String,
    val Author: String
)