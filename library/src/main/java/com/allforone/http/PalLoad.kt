package com.allforone.http

import com.allforone.data.NetResponse
import io.reactivex.functions.Function
import java.lang.NullPointerException

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  11.21. 23:42
 */
class PalLoad<T> : Function<NetResponse<T>, T> {

    override fun apply(t: NetResponse<T>): T {
        if (!t.isSuccess()) {
            throw NullPointerException()
        }
        return t.getResult()
    }
}