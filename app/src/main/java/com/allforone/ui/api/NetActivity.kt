package com.allforone.ui.api

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import com.allforone.R
import mvvm.core.BaseActivity
import com.allforone.databinding.ActNetBinding
import com.lxj.xpopup.XPopup

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  11.28. 22:18
 */
class NetActivity : BaseActivity<ActNetBinding, NetViewModel>() {

    companion object {
        fun start(ctx: Context) {
            ctx.startActivity(Intent(ctx, NetActivity::class.java))
        }
    }

    override fun bindLayoutId() = R.layout.act_net

    override fun onCreated(savedInstanceState: Bundle?) {
        layoutBinding.vm = viewModel

        val pop = XPopup.Builder(this)

        viewModel.resultTask.observe(this, Observer {
            pop.asConfirm("result", it, null)
                .show()
        })
    }
}