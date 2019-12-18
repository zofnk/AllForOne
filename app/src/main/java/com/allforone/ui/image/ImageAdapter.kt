package com.allforone.ui.image

import com.allforone.R
import com.allforone.databinding.ItemImageBinding
import common.core.adapter.QuickBindingAdapter
import common.core.viewholder.BaseBindingViewHolder
import common.ktx.gone
import common.ktx.loadProgress
import common.ktx.logE


/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Create Time :  2019-12-10. 11:54
 */
class ImageAdapter : QuickBindingAdapter<String, ItemImageBinding>(R.layout.item_image) {

    override fun convert(hepler: BaseBindingViewHolder<ItemImageBinding>, item: String) {
        hepler.viewBinding.apply {
            ivImage.loadProgress(item) {

                loadProgress = { current, total, progress ->
                    "current -> $current , total -> $total , progress -> $progress".logE()
                    tvMask.text = "$progress %"
                }

                loadFailed = {
                    "loadFailed".logE()
                    tvMask.gone()
                }

                loadReady = {
                    "loadReady".logE()
                    tvMask.gone()
                }

                executePendingBindings()
            }
        }
    }
}