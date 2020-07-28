package common.binding.view

import android.view.View
import androidx.databinding.BindingAdapter
import common.binding.VIEW_CLICK
import common.binding.VIEW_LONG_CLICK
import common.ext.click
import common.ext.longClick

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Create Time :  2019-11-29. 10:08
 */
object ViewAdapter {

    @JvmStatic
    @BindingAdapter(VIEW_CLICK)
    fun View.viewOnClick(listener: View.OnClickListener) {
        click { listener.onClick(this) }
    }

    @JvmStatic
    @BindingAdapter(VIEW_LONG_CLICK)
    fun View.viewOnLongClick(listener: View.OnLongClickListener) {
        listener.onLongClick(this)
    }
}