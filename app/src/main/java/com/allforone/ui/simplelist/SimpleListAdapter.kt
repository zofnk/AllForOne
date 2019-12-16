package com.allforone.ui.simplelist

import com.allforone.R
import com.allforone.core.adapter.QuickBindingAdapter
import com.allforone.core.viewholder.BaseBindingViewHolder
import com.allforone.databinding.ItemBindingTextBinding

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  11.30. 00:36
 */

data class SimpleTestBean(
    var title: String? = null
)

class SimpleListAdapter : QuickBindingAdapter<SimpleTestBean, ItemBindingTextBinding>(R.layout.item_binding_text) {

    override fun convert(hepler: BaseBindingViewHolder<ItemBindingTextBinding>, item: SimpleTestBean) {
        hepler.viewBinding.apply {
            this.item = item
            executePendingBindings()
        }
    }
}