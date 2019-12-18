package common.http

import android.net.ParseException
import com.google.gson.JsonParseException
import com.google.gson.stream.MalformedJsonException
import org.apache.http.conn.ConnectTimeoutException
import org.json.JSONException
import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import java.util.concurrent.ExecutionException
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

    private const val HTTP_ERROR = 1000
    private const val PARSE_ERROR = 1001
    private const val NETWORK_ERROR = 1002
    private const val SSL_ERROR = 1003
    private const val TIMEOUT_ERROR = 1004
    private const val UNKNOWN = 1005
    private const val RESPONSE = 888
    private const val GLIDE = 666

    fun handleException(e: Throwable): ApiException {
        return when (e) {
            is HttpException -> ApiException(
                throwable = e,
                code = HTTP_ERROR,
                msg = when (e.code()) {
                    UNAUTHORIZED -> "操作未授权"
                    FORBIDDEN -> "请求被拒绝"
                    NOT_FOUND -> "资源不存在"
                    REQUEST_TIMEOUT -> "服务器执行超时"
                    INTERNAL_SERVER_ERROR -> "服务器内部错误"
                    SERVICE_UNAVAILABLE -> "服务器不可用"
                    else -> "网络错误"
                }
            )
            is JsonParseException, is JSONException, is ParseException, is MalformedJsonException -> ApiException(e, PARSE_ERROR, "解析错误")
            is ConnectException -> ApiException(e, NETWORK_ERROR, "连接失败")
            is SSLException -> ApiException(e, SSL_ERROR, "证书验证失败")
            is ConnectTimeoutException, is SocketTimeoutException -> ApiException(e, TIMEOUT_ERROR, "连接超时")
            is UnknownHostException -> ApiException(e, TIMEOUT_ERROR, "未知主机地址")
            is ResponseException -> ApiException(e, RESPONSE, e.msg)
            is ExecutionException -> ApiException(e ,GLIDE , e.message?:"")
            else -> ApiException(e, UNKNOWN, "未知错误")
        }
    }
}