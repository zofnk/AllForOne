package com.allforone.ktx

import androidx.databinding.ViewDataBinding
import com.chad.library.adapter.base.BaseViewHolder

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  2019-11-28. 10:41
 */
@Suppress("UNCHECKED_CAST")
fun <T : ViewDataBinding> BaseViewHolder.viewBinding(layoutResId: Int) =
    itemView.getTag(layoutResId) as T