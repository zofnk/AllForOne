package com.allforone.data

import com.allforone.http.listener.ResponseImpl
import com.google.gson.Gson

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  11.21. 21:44
 */
abstract class NetResponse<T> : ResponseImpl<T> {
    fun toJson(): String = Gson().toJson(this)
}