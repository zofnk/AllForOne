package com.allforone.http

import com.allforone.core.repo.BaseRepository

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  2019-11-22. 10:33
 */

//项目api url 添加进createApi的baseUrl的默认值内
const val BASE_URL = "http://all.api.acgneta.com"

//项目必须加一下这个来配置retrofit
//todo 可拓展header/拦截器/缓存/等等....
fun <T> BaseRepository.createApi(clazz: Class<T>, baseUrl: String = BASE_URL): T =
    config(baseUrl, clazz)