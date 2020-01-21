package common.ktx

import android.content.Context

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Create Time :  2020-1-21. 10:23
 */
fun String.toast(ctx : Context){
    ctx.toast(this)
}