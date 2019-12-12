package com.allforone.ui.simplelist

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.allforone.R
import com.allforone.core.common.BaseActivity
import com.allforone.databinding.ActListBinding
import com.allforone.ui.main.ListViewModel
import kotlinx.android.synthetic.main.act_list.*

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  11.21. 20:12
 */
class ListActivity : BaseActivity<ActListBinding, ListViewModel>() {

    companion object {
        fun start(ctx: Context) {
            ctx.startActivity(Intent(ctx, ListActivity::class.java))
        }
    }

    override fun bindLayoutId() = R.layout.act_list

    override fun onCreated(savedInstanceState: Bundle?) {
        layoutBinding.vm = viewModel

        rvTest.adapter = viewModel.simpleAdapter
    }
}