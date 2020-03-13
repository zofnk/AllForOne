package com.allforone.ui.api

import com.allforone.http.BASE_URL_JUHE
import com.allforone.http.createApi
import common.core.repo.BaseRepository
import common.ktx.responseTransformer

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Create Time :  2019-11-29. 09:02
 */
class NetRepository : BaseRepository() {

    private val api by lazy { createApi(NetApi::class.java) }

    private val api2 by lazy { createApi(NetApi::class.java, BASE_URL_JUHE) }

    /**
     * Kotlin
     */
    suspend fun getBanner(
        type: Int,
        area: Int
    ) = api
        .banner2(type = type, area = area)
        .responseTransformer()

    suspend fun searchAnimation2(
        key: String,
        page: Int = 1,
        size: Int = 1000,
        token: String = ""
    ) = api
        .searchAnimation2(key, page, size, token)
        .responseTransformer()
}