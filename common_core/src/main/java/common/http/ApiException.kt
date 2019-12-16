package common.http

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Create Time :  2019-11-22. 09:03
 */
class ApiException(throwable: Throwable, var code: Int, var msg: String) : Exception(throwable)