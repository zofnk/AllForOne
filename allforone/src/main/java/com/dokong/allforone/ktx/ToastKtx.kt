package com.dokong.allforone.ktx

import android.content.Context
import android.widget.Toast

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  2019-11-6. 11:47
 */
fun String.toast(ctx: Context, time: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(ctx, this, time).show()
}