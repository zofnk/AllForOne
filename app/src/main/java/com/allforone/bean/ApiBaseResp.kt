package com.allforone.bean

import com.allforone.data.NetResponse

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
    override fun getResult() = Data
    override fun isSuccess() = Code == 0
}