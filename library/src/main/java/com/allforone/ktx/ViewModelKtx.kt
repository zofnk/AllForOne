package com.allforone.ktx

import androidx.lifecycle.AndroidViewModel
import com.allforone.data.NetResponse

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  2019-11-22. 16:23
 */
class data<T> {
    val message: String = ""
    val code: Int = 0
    val data: nest? = null

    inner class nest {
        val message: String = ""
        val code: Int = 0
        val data: T? = null
    }
}

class Outter : NetResponse<ApiResult>() {

    val jsonrpc: String = ""
    val id: String = ""
    val resultXXX: ApiResult = ApiResult()

    override fun isSuccess() = resultXXX.success

    override fun response(): ApiResult = resultXXX

}

class ApiResult {
    val result: String = ""
    val resultMessage = ""
    val success: Boolean = false
}

