package common.http.listener

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  12.18. 22:30
 */
class ImageLoadHandler {
    var loadProgress: ((Long, Long, Int) -> Unit)? = null
    var loadFailed: (() -> Unit)? = null
    var loadReady: (() -> Unit)? = null
}