package common.binding.imageview

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import common.binding.IMAGE_ERROR
import common.binding.IMAGE_PLACEHOLDER
import common.binding.IMAGE_URL
import common.ktx.load

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  2019-11-28. 13:21
 * requireAll表示所有参数必须都要
 */
object ImageViewAdapter {

    @JvmStatic
    @BindingAdapter(value = [IMAGE_URL, IMAGE_PLACEHOLDER, IMAGE_ERROR], requireAll = false)
    fun ImageView.loadUrl(url: Any?, placeholder: Int = 0, error: Int = 0) {
        load(url = url, placeholder = placeholder, error = error)
    }
}