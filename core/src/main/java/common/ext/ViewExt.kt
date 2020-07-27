package common.ext

import android.content.Context
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  2019-11-11. 13:21
 */
val AppCompatActivity.activity: AppCompatActivity
    get() = this

val Fragment.context: Context
    get() = requireContext()

val Fragment.activity: FragmentActivity
    get() = requireActivity()

val View.ctx: Context
    get() = context

val View.gone: Unit
    get() {
        visibility = View.GONE
    }

val View.visible: Unit
    get() {
        visibility = View.VISIBLE
    }

val View.invisible: Unit
    get() {
        visibility = View.INVISIBLE
    }

val View.toggleVisible: Unit
    get() {
        if (isVisible) gone else visible
    }

val View.isGone: Boolean get() = visibility == View.GONE

val View.isVisible: Boolean get() = visibility == View.VISIBLE

val View.isInvisible: Boolean get() = visibility == View.INVISIBLE

//点击
fun View.click(action: (v: View) -> Unit) {
    //之后需要修改为防抖点击
    setOnClickListener { action.invoke(it) }
}

fun View.longClick(action: (v: View) -> Boolean) {
    setOnLongClickListener {
        return@setOnLongClickListener action.invoke(it)
    }
}