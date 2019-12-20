package com.allforone.ui.download

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.allforone.R
import com.allforone.databinding.ActDownLoadBinding
import kotlinx.android.synthetic.main.act_down_load.*
import mvvm.core.BaseActivity

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Create Time :  2019-12-20. 11:43
 */
class DownLoadActivity : BaseActivity<ActDownLoadBinding, DownLoadViewModel>() {

    companion object {
        fun start(ctx: Context) {
            ctx.startActivity(Intent(ctx, DownLoadActivity::class.java))
        }
    }

    override fun bindLayoutId(): Int = R.layout.act_down_load

    override fun onCreated(savedInstanceState: Bundle?) {
        rvDownLoad.adapter = viewModel.fileAdapter
    }

}