package common.ktx

import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import common.http.GlideApp
import common.http.GlideRequest
import common.http.ProgressAppGlideModule
import common.http.listener.ImageLoadHandler

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
        GlideApp.with(context)
            .asBitmap()
            .load(url)
            .apply(options)
            .into(this)
    } else {
        GlideApp.with(context)
            .load(url)
            .apply(options)
            .apply { if (isCrossFade) transition(DrawableTransitionOptions.withCrossFade()) }
            .into(this)
    }
}

//todo 添加缩略图加载功能
fun ImageView.loadThumbnail(
    url: Any?
): GlideRequest<Drawable> {
    return GlideApp.with(ctx).load(url)
}

/**
 * ImageView带进度加载URL
 *
 * loadProgress     加载进度 value1:加载大小 value2:总大小
 * loadFailed       加载失败
 * loadReady        加载成功
 */
fun ImageView.loadProgress(
    url: String?,
    block: ImageLoadHandler.() -> Unit
) {
    val handler = ImageLoadHandler()
        .apply {
            block()
        }

    ProgressAppGlideModule.expect(url, object : ProgressAppGlideModule.UIonProgressListener {
        override fun onProgress(bytesRead: Long, expectedLength: Long) {
            handler.loadProgress?.invoke(
                bytesRead,
                expectedLength,
                (100 * bytesRead / expectedLength).toInt()
            )
        }

        override fun getGranualityPercentage(): Float = 1.0f
    })

    GlideApp.with(ctx)
        .load(url)
        .transition(DrawableTransitionOptions.withCrossFade())
        .listener(object : RequestListener<Drawable> {
            override fun onLoadFailed(
                e: GlideException?,
                model: Any?,
                target: Target<Drawable>?,
                isFirstResource: Boolean
            ): Boolean {
                ProgressAppGlideModule.forget(url.toString())
                handler.loadFailed?.invoke()
                return false
            }

            override fun onResourceReady(
                resource: Drawable?,
                model: Any?,
                target: Target<Drawable>?,
                dataSource: DataSource?,
                isFirstResource: Boolean
            ): Boolean {
                ProgressAppGlideModule.forget(url.toString())
                handler.loadReady?.invoke()
                return false
            }
        })
        .into(this)

}