package com.allforone.bean

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  2019-11-22. 11:12
 */
class ListResponse<T> {
    val TotalCount: Int = 0
    val TotalPage: Int = 0
    val List: List<T> = ArrayList()
}