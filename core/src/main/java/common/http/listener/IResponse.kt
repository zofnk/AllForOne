package common.http.listener

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  11.21. 21:45
 */
interface IResponse<out T> {
    fun isSuccess(): Boolean
    fun response(): T
}