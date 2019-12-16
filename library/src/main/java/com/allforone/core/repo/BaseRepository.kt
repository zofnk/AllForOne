package com.allforone.core.repo

import com.allforone.ktx.Net

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  11.21. 22:50
 */
//仓库类 用于分流获取数据途径
open class BaseRepository {

    suspend fun <T> doRequest(req: suspend () -> T): T {
        return req.invoke()
    }

    fun <T> config(baseUrl: String, clazz: Class<T>): T = Net.baseUrl(baseUrl).build().create(clazz)
}