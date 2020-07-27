package common.ext

import android.app.Application
import android.content.Context
import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.lifecycle.AndroidViewModel
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import common.http.ProgressAppGlideModule
import common.http.listener.ImageLoadHandler
import common.http.listener.ImageProgress

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
    isBitmap: Boolean = false,
    thumbSize: Float = 1f
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
            .priority(Priority.LOW)
            .load(url)
            .thumbnail(thumbSize)
            .apply(options)
            .into(this)
    } else {
        Glide.with(context)
            .load(url)
            .apply(options)
            .thumbnail(thumbSize)
            .apply { if (isCrossFade) transition(DrawableTransitionOptions.withCrossFade()) }
            .into(this)
    }
}

fun String.submitImage(
    context: Context,
    url: Any?,
    width: Int = Target.SIZE_ORIGINAL,
    height: Int = Target.SIZE_ORIGINAL
): Drawable {
    return Glide
        .with(context)
        .load(url)
        .submit(width, height)
        .get()
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

    val prog = ImageProgress()

    ProgressAppGlideModule.expect(url, object : ProgressAppGlideModule.UIonProgressListener {
        override fun onProgress(bytesRead: Long, expectedLength: Long) {
            handler.loadProgress?.invoke(prog.apply {
                current = bytesRead
                total = expectedLength
                progress = (100 * bytesRead / expectedLength).toInt()
            })
        }

        override fun getGranualityPercentage(): Float = 1.0f
    })

    Glide.with(ctx)
        .load(url)
        .thumbnail(0.5f)
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