package com.allforone.bean.egbean

import common.data.NetResponse


/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  2019-11-22. 17:03
 */
data class TopBean<R>(
    val reason: String,
    val result: TopResult<R>

) : NetResponse<TopResult<R>>() {

    override fun response() = result

    override fun isSuccess() = result.stat == 1
}

data class TopResult<T>(
    val stat: Int,
    val data: T
)