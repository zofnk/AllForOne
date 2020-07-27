package common.ext

import android.content.Context
import android.graphics.Point
import android.util.DisplayMetrics
import android.view.WindowManager

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  2019-11-11. 13:05
 */
val Context.screenWidth: Int
    get() {
        val point = Point()
        val windowsManager = getSystemService(Context.WINDOW_SERVICE) as WindowManager
        windowsManager.defaultDisplay.getSize(point)
        return point.x
    }

val Context.screenHeight: Int
    get() {
        val point = Point()
        val windowsManager = getSystemService(Context.WINDOW_SERVICE) as WindowManager
        windowsManager.defaultDisplay.getSize(point)
        return point.y
    }

//或者也可以试一下下面的方法
val Context.screenWidthByMetrics: Int
    get() {
        val metrics = DisplayMetrics()
        val windowsManager = getSystemService(Context.WINDOW_SERVICE) as WindowManager
        windowsManager.defaultDisplay.getMetrics(metrics)
        return metrics.widthPixels
    }

val Context.screenHeightByMetrics: Int
    get() {
        val metrics = DisplayMetrics()
        val windowsManager = getSystemService(Context.WINDOW_SERVICE) as WindowManager
        windowsManager.defaultDisplay.getMetrics(metrics)
        return metrics.heightPixels
    }