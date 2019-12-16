package com.allforone.ui.api

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import com.allforone.R
import com.allforone.core.common.BaseActivity
import com.allforone.databinding.ActNetBinding
import com.allforone.ktx.click
import com.demo.dokong.componentmvvm.core.hh
import com.lxj.xpopup.XPopup
import kotlinx.android.synthetic.main.act_net.*

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

        val aa =1
        val bb = aa hh 1
        viewModel.resultTask.observe(this, Observer {
            pop.asConfirm("result", it, null)
                .show()
        })
    }
}