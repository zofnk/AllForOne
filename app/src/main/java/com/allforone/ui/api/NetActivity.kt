package com.allforone.ui.api

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.allforone.R
import com.allforone.core.common.BaseActivity
import com.allforone.databinding.ActNetBinding
import com.allforone.ktx.*
import kotlinx.android.synthetic.main.act_net.*
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  11.28. 22:18
 */
class NetActivity : BaseActivity<ActNetBinding>() {

    private lateinit var netVm: NetViewModel

    companion object {
        fun start(ctx: Context) {
            ctx.startActivity(Intent(ctx, NetActivity::class.java))
        }
    }

    override fun bindLayoutId() = R.layout.act_net

    override fun onCreated(savedInstanceState: Bundle?) {
        netVm = createViewModel(NetViewModel::class.java)
        layoutBinding.vm = netVm

        tvApiRxGet.click { netVm.loadDataWithRx() }
        netVm.content.observe(this, Observer { tvApiResult.text = it })
    }
}