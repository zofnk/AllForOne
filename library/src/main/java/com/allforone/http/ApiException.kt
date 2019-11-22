package com.allforone.http

import java.lang.RuntimeException

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  2019-11-22. 09:03
 */
class ApiException(val msg: String) : RuntimeException()