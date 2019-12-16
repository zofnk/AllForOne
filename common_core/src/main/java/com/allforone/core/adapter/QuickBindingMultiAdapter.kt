package com.allforone.core.adapter

import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.chad.library.adapter.base.entity.MultiItemEntity

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  2019-11-28. 10:17
 */
abstract class QuickBindingMultiAdapter<T : MultiItemEntity, K : BaseViewHolder> :
    BaseMultiItemQuickAdapter<T, K>(null) {

    var layoutResId = 0

    override fun getItemView(layoutResId: Int, parent: ViewGroup?): View {
        this.layoutResId = layoutResId
        val viewBinding =
            DataBindingUtil.inflate<ViewDataBinding?>(mLayoutInflater, layoutResId, parent, false)
        return viewBinding?.run {
            root.setTag(layoutResId, this)
            root
        } ?: super.getItemView(layoutResId, parent)
    }
}