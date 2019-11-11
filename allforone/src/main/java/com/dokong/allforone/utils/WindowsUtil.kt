package com.dokong.allforone.utils

import android.content.Context
import android.graphics.Point
import android.util.DisplayMetrics
import android.view.WindowManager

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  2019-11-11. 13:05
 */
class WindowsUtil {
    companion object {
        fun windowsWidth(ctx: Context): Int {
            val point = Point()
            val windowsManager = ctx.getSystemService(Context.WINDOW_SERVICE) as WindowManager
            windowsManager.defaultDisplay.getSize(point)
            return point.x
        }

        fun windowsHeight(ctx: Context): Int {
            val point = Point()
            val windowsManager = ctx.getSystemService(Context.WINDOW_SERVICE) as WindowManager
            windowsManager.defaultDisplay.getSize(point)
            return point.y
        }

        //或者也可以试一下下面的方法
        fun windowsWidthByMetrics(ctx: Context): Int {
            val metrics = DisplayMetrics()
            val windowsManager = ctx.getSystemService(Context.WINDOW_SERVICE) as WindowManager
            windowsManager.defaultDisplay.getMetrics(metrics)
            return metrics.widthPixels
        }
        fun windowsHeightByMetrics(ctx: Context): Int {
            val metrics = DisplayMetrics()
            val windowsManager = ctx.getSystemService(Context.WINDOW_SERVICE) as WindowManager
            windowsManager.defaultDisplay.getMetrics(metrics)
            return metrics.heightPixels
        }
    }
}