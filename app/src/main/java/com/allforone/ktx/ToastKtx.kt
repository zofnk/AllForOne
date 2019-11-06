package com.allforone.ktx

import android.content.Context
import android.widget.Toast

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  2019-11-6. 11:47
 */
fun String.toast(ctx: Context, msg: String?) {
    Toast.makeText(ctx, msg, Toast.LENGTH_SHORT).show()
}