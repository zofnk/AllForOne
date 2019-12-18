package com.allforone.ui.image

import android.app.Application
import mvvm.core.BaseViewModel

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Create Time :  2019-12-10. 10:29
 */
class ImageViewModel(app: Application) : BaseViewModel(app) {

    val imageAdapter: ImageAdapter by lazy { ImageAdapter() }

    init {
        val imageData = mutableListOf(
            "https://images5.alphacoders.com/442/442617.jpg"
        )
        imageAdapter.setNewData(imageData)
    }
}