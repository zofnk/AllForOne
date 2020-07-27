package common.http

import java.lang.RuntimeException

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  12.11. 21:29
 */
class ResponseException(var msg: String) : RuntimeException()