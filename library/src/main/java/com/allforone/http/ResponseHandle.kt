package com.allforone.http

import com.allforone.data.NetResponse
import com.allforone.ktx.responseTransformer
import io.reactivex.functions.Function

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  11.21. 23:42
 */
class ResponseHandle<T> : Function<NetResponse<T>, T> {
    override fun apply(t: NetResponse<T>): T = t.responseTransformer()
}