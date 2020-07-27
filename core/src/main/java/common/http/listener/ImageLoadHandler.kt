package common.http.listener

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  12.18. 22:30
 */
class ImageLoadHandler {
    var loadProgress: ((ImageProgress) -> Unit)? = null
    var loadFailed: (() -> Unit)? = null
    var loadReady: (() -> Unit)? = null
}

class ImageProgress {
    var current: Long = 0L
    var total: Long = 0L
    var progress: Int = 0
}