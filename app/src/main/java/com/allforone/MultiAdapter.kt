package com.allforone

import com.allforone.core.adapter.QuickBindingMultiAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.chad.library.adapter.base.entity.MultiItemEntity

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  2019-11-28. 10:23
 */
data class MultiBean(val type: Int, val name: String) : MultiItemEntity {
    companion object {
        const val TYPE_TEXT = 1
        const val TYPE_IMAGE = 2
    }

    override fun getItemType() = type
}

class MultiAdapter : QuickBindingMultiAdapter<MultiBean, BaseViewHolder>() {

    init {
        addItemType(MultiBean.TYPE_TEXT, R.layout.item_binding_text)
        addItemType(MultiBean.TYPE_IMAGE, R.layout.item_binding_image)
    }

    override fun convert(helper: BaseViewHolder, item: MultiBean) {
    }
}