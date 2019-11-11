package com.dokong.allforone.ktx

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  2019-11-11. 11:16
 */
fun ImageView.load(
    url: Any?,
    placeholder: Int = 0,//todo: 可以在库里加一张占位图,以下错误同理
    error: Int = 0,
    isCircle: Boolean = false,
    isCenterCrop: Boolean = false,
    roundRadius: Int = 0,
    isCrossFade: Boolean = false,
    isOriginalSize: Boolean = false,
    isBitmap: Boolean = false
) {
    val options = RequestOptions().placeholder(placeholder).error(error).apply {
        if (isCenterCrop && scaleType != ImageView.ScaleType.CENTER_CROP)
            scaleType = ImageView.ScaleType.CENTER_CROP
        if (isCircle) {
            if (scaleType == ImageView.ScaleType.CENTER_CROP) {
                transform(CenterCrop(), CircleCrop())
            } else {
                transform(CircleCrop())
            }
        } else if (roundRadius != 0) {
            if (scaleType == ImageView.ScaleType.CENTER_CROP) {
                transform(
                    CenterCrop(),
                    RoundedCorners(context.dp2px(roundRadius.toFloat()))
                )
            } else {
                transform(RoundedCorners(context.dp2px(roundRadius.toFloat())))
            }
        }
        if (isOriginalSize) {
            override(Target.SIZE_ORIGINAL)
        }
    }
    if (isBitmap) {
        Glide.with(context)
            .asBitmap()
            .load(url)
            .apply(options)
            .into(this)
    } else {
        Glide.with(context)
            .load(url)
            .apply(options)
            .apply { if (isCrossFade) transition(DrawableTransitionOptions.withCrossFade()) }
            .into(this)
    }
}