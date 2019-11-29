package com.allforone.databinding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.allforone.ktx.load

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  2019-11-28. 13:21
 * requireAll表示所有参数必须都要
 */
class ImageViewBindingAdapter {
    companion object {

        @JvmStatic
        @BindingAdapter(value = [IMAGE_URL, IMAGE_PLACEHOLDER, IMAGE_ERROR], requireAll = false)
        fun ImageView.loadUrl(url: Any?, placeholder: Int = 0, error: Int = 0) {
            load(url = url, placeholder = placeholder, error = error)
        }
    }
}