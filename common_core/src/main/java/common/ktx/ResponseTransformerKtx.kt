package common.ktx

import common.data.NetResponse
import common.http.ResponseException

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Create Time :  11.21. 23:01
 */

/**
 * 线程调度器
 */

//实体类转换器
fun <T> NetResponse<T>.responseTransformer(): T {
    if (!isSuccess()) throw ResponseException(toJson())
    return response()
}
