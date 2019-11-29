package com.allforone.databinding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter.base.BaseQuickAdapter

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  2019-11-29. 10:55
 */
class RecyclerViewBindingAdapter {
    companion object {

        @JvmStatic
        @BindingAdapter(RECYCLER_BIND_ITEMS)
        fun <T> RecyclerView.bindItems(data: List<T>) {
            adapter?.let {
                val quickAdapter = it as BaseQuickAdapter<T, *>
                quickAdapter.setNewData(data)
            }
        }

    }
}