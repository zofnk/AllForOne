package com.allforone.bean

import common.http.listener.IResponse


/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  11.21. 23:16
 */
data class ApiBaseResp<out T>(
    val Message: String,
    val Code: Int,
    val Data: T
) : IResponse<T> {
    override fun response() = Data
    override fun isSuccess() = Code == 0
}