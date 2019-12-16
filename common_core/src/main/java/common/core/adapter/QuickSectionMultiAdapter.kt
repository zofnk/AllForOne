package common.core.adapter

import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.chad.library.adapter.base.BaseSectionMultiItemQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.chad.library.adapter.base.entity.SectionMultiEntity

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  2019-11-28. 10:46
 */
abstract class QuickSectionMultiAdapter<T : SectionMultiEntity<T>, K : BaseViewHolder> :
    BaseSectionMultiItemQuickAdapter<T, K>(0, null) {

    var layoutResId: Int = 0

    override fun getItemView(layoutResId: Int, parent: ViewGroup?): View {
        this.layoutResId =layoutResId
        val viewBinding =
            DataBindingUtil.inflate<ViewDataBinding?>(mLayoutInflater, layoutResId, parent, false)
        return viewBinding?.run {
            root.setTag(layoutResId, this)
            root
        } ?: super.getItemView(layoutResId, parent)
    }
}