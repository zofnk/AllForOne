package com.allforone.ui.click

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.allforone.R
import com.allforone.core.common.BaseActivity
import com.allforone.databinding.ActClickBinding
import com.allforone.ktx.createViewModel

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Create Time :  2019-12-9. 10:48
 */
class ClickActivity : BaseActivity<ActClickBinding>() {

    companion object {
        fun start(ctx: Context) {
            ctx.startActivity(Intent(ctx, ClickActivity::class.java))
        }
    }

    private lateinit var clickViewModel: ClickViewModel

    override fun bindLayoutId() = R.layout.act_click

    override fun onCreated(savedInstanceState: Bundle?) {
        clickViewModel = createViewModel(ClickViewModel::class.java)
        layoutBinding.vm = clickViewModel
    }
}