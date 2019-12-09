package com.allforone.binding.view

import android.view.View
import androidx.databinding.BindingAdapter
import com.allforone.binding.VIEW_CLICK
import com.allforone.binding.VIEW_CLICK_WITH_VALUE
import com.allforone.binding.VIEW_LONG_CLICK
import com.allforone.binding.VIEW_LONG_CLICK_WITH_VALUE
import com.allforone.ktx.click
import com.allforone.ktx.longClick

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  2019-11-29. 10:08
 */
class ViewAdapter {
    companion object {

        /**
         * 单击不携带参数的方法
         */
        @JvmStatic
        @BindingAdapter(VIEW_CLICK)
        fun View.viewOnClick(onClick: () -> Unit) {
            click { onClick() }
        }

        /**
         * 单击携带参数的方法
         */
        @JvmStatic
        @BindingAdapter(VIEW_CLICK_WITH_VALUE)
        fun View.viewOnClickWithValue(listener: View.OnClickListener) {
            click { listener.onClick(this) }
        }

        /**
         * 长按不携带的参数方法
         */
        @JvmStatic
        @BindingAdapter(VIEW_LONG_CLICK)
        fun View.viewOnLongClick(onLongClick: () -> Unit) {
            longClick { onLongClick() }
        }

        /**
         * 长按携带参数的方法
         */
        @JvmStatic
        @BindingAdapter(VIEW_LONG_CLICK_WITH_VALUE)
        fun View.viewOnLongClickWithValue(listener: View.OnClickListener) {
            longClick { listener.onClick(this) }
        }
    }
}