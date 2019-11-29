package com.allforone.databinding

import android.view.View
import androidx.databinding.BindingAdapter
import com.allforone.ktx.click
import com.allforone.ktx.longClick

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  2019-11-29. 10:08
 */
class ViewBindingAdapter {
    companion object {

        @JvmStatic
        @BindingAdapter(VIEW_CLICK)
        fun View.viewOnClick(onClick: () -> Unit) {
            click { onClick() }
        }

        @JvmStatic
        @BindingAdapter(VIEW_LONG_CLICK)
        fun View.viewOnLongClick(onLongClick: () -> Boolean) {
            //xml里注意要这样写:
            //app:view_longClick="@{() -> vm.longClick()}"
            longClick { onLongClick() }
        }
    }
}