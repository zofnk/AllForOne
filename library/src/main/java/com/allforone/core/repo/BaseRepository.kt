package com.allforone.core.repo

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  11.21. 22:50
 */
open class BaseRepository {

    suspend fun <T> doRequest(req: suspend () -> T): T {
        return req.invoke()
    }
}