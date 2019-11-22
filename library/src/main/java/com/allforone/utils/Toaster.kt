package com.allforone.utils

import android.content.Context
import android.widget.Toast

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  2019-11-11. 11:51
 */
class Toaster {
    companion object {
        fun toast(ctx: Context, str: CharSequence, time: Int = Toast.LENGTH_SHORT) {
            Toast.makeText(ctx.applicationContext, str, time).show()
        }
    }
}