package com.allforone.bean

import com.allforone.data.NetResponse

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  11.21. 23:16
 */
data class ApiBaseResp<T>(
    val message: String,
    val code: Int,
    val data: T
) : NetResponse<T>() {
    override fun getResult() = data
    override fun isSuccess() = code == 0
}