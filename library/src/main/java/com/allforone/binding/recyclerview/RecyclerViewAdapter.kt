package com.allforone.binding.recyclerview

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.allforone.binding.RECYCLER_BIND_ITEMS
import com.chad.library.adapter.base.BaseQuickAdapter

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Create Time :  2019-11-29. 10:55
 */
object RecyclerViewAdapter {

    @JvmStatic
    @BindingAdapter(RECYCLER_BIND_ITEMS)
    fun <T> RecyclerView.bindItems(data: List<T>) {
        adapter?.let {
            val quickAdapter = it as BaseQuickAdapter<T, *>
            quickAdapter.setNewData(data)
        }
    }
}