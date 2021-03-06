package com.allforone.bean

import common.data.NetResponse


/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  11.21. 23:16
 */
data class ApiBaseResp<T>(
    val Message: String,
    val Code: Int,
    val Data: T
) : NetResponse<T>() {
    override fun response() = Data
    override fun isSuccess() = Code == 0
}