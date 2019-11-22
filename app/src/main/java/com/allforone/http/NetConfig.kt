package com.allforone.http

import com.allforone.core.repo.BaseRepository

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  2019-11-22. 10:33
 */
const val BASE_URL = "http://all.api.acgneta.com"

fun <T> BaseRepository.createApi(baseUrl: String = BASE_URL, clazz: Class<T>): T =
    config(baseUrl, clazz)