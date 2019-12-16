package common.core.viewholder

import android.view.View
import androidx.databinding.ViewDataBinding
import com.chad.library.adapter.base.BaseViewHolder
import com.dokong.allforone.R

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  2019-11-28. 08:57
 */
class BaseBindingViewHolder<B : ViewDataBinding>(v: View) : BaseViewHolder(v) {

    val viewBinding: B
        @Suppress("UNCHECKED_CAST")
        get() = itemView.getTag(R.id.BaseQuickAdapter_databinding_support) as B
}