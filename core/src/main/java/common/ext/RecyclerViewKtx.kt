package common.ext

import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.chad.library.adapter.base.BaseQuickAdapter

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  2019-11-11. 14:08
 */

fun <T : View> RecyclerView.childView(position: Int, viewId: Int): T =
    getChildAt(position).findViewById(viewId)

fun RecyclerView.scrollTop() {
    (layoutManager as LinearLayoutManager).scrollToPositionWithOffset(0, 0)
}

fun RecyclerView.fixedSize() = apply { setHasFixedSize(true) }

fun RecyclerView.vertical(spanCount: Int = 0, isStaggered: Boolean = false): RecyclerView {
    layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    if (spanCount != 0) {
        layoutManager = GridLayoutManager(context, spanCount)
    }
    if (isStaggered) {
        layoutManager = StaggeredGridLayoutManager(spanCount, StaggeredGridLayoutManager.VERTICAL)
    }
    return this
}

fun RecyclerView.horizontal(spanCount: Int = 0, isStaggered: Boolean = false): RecyclerView {
    layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
    if (spanCount != 0) {
        layoutManager = GridLayoutManager(context, spanCount, GridLayoutManager.HORIZONTAL, false)
    }
    if (isStaggered) {
        layoutManager = StaggeredGridLayoutManager(spanCount, StaggeredGridLayoutManager.HORIZONTAL)
    }
    return this
}

val RecyclerView.data: List<Any?>
    get() = (adapter as BaseQuickAdapter<*, *>).data

fun RecyclerView.itemClick(listener: (data: List<*>, view: View, position: Int) -> Unit): RecyclerView {
    adapter?.apply {
        (adapter as BaseQuickAdapter<*, *>).setOnItemClickListener { _, view, position ->
            listener(data as List<*>, view, position)
        }
    }
    return this
}