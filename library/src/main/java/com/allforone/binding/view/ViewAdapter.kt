package com.allforone.binding.view

import android.view.View
import androidx.databinding.BindingAdapter
import com.allforone.binding.VIEW_CLICK
import com.allforone.binding.VIEW_LONG_CLICK
import com.allforone.ktx.click
import com.allforone.ktx.longClick

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  2019-11-29. 10:08
 */
class ViewAdapter {
    companion object {

        @JvmStatic
        @BindingAdapter(VIEW_CLICK)
        fun View.viewOnClick(listener: View.OnClickListener) {
            click { listener.onClick(this) }
        }

        @JvmStatic
        @BindingAdapter(VIEW_LONG_CLICK)
        fun View.viewOnLongClick(listener: View.OnClickListener) {
            longClick { listener.onClick(this) }
        }
    }
}