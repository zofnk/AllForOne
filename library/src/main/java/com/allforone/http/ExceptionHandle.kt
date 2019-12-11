package com.allforone.http

import android.net.ParseException
import com.google.gson.JsonParseException
import com.google.gson.stream.MalformedJsonException
import org.apache.http.conn.ConnectTimeoutException
import org.json.JSONException
import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import javax.net.ssl.SSLException

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Create Time :  2019-12-11. 10:45
 */
object ExceptionHandle {

    private const val UNAUTHORIZED = 401
    private const val FORBIDDEN = 403
    private const val NOT_FOUND = 404
    private const val REQUEST_TIMEOUT = 408
    private const val INTERNAL_SERVER_ERROR = 500
    private const val SERVICE_UNAVAILABLE = 503

    fun handleException(e: Throwable): ApiException {
        return ApiException(
            when (e) {
                is HttpException -> when (e.code()) {
                    UNAUTHORIZED -> "操作未授权"
                    FORBIDDEN -> "请求被拒绝"
                    NOT_FOUND -> "资源不存在"
                    REQUEST_TIMEOUT -> "服务器执行超时"
                    INTERNAL_SERVER_ERROR -> "服务器内部错误"
                    SERVICE_UNAVAILABLE -> "服务器不可用"
                    else -> "网络错误"
                }
                is JsonParseException, is JSONException, is ParseException, is MalformedJsonException -> "解析错误"
                is ConnectException -> "连接失败"
                is SSLException -> "证书验证失败"
                is ConnectTimeoutException, is SocketTimeoutException -> "连接超时"
                is UnknownHostException -> "主机地址未知"
                else -> "未知错误"
            }
        )
    }
}