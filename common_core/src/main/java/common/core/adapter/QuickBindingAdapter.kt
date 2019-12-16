package common.core.adapter

import android.os.Build
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.chad.library.adapter.base.BaseQuickAdapter
import com.dokong.allforone.R
import common.core.viewholder.BaseBindingViewHolder

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  2019-11-28. 09:04
 */
abstract class QuickBindingAdapter<T, B : ViewDataBinding>(layoutResId: Int) :
    BaseQuickAdapter<T, BaseBindingViewHolder<B>>(layoutResId) {

    abstract override fun convert(hepler: BaseBindingViewHolder<B>, item: T)

    override fun getItemView(layoutResId: Int, parent: ViewGroup): View {
        val viewBinding =
            DataBindingUtil.inflate<ViewDataBinding?>(mLayoutInflater, layoutResId, parent, false)
        return viewBinding?.run {
            root.setTag(R.id.BaseQuickAdapter_databinding_support, this)
            root
        } ?: super.getItemView(layoutResId, parent)
    }
}