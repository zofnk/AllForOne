package com.allforone.ui.api

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.allforone.R

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  11.28. 22:18
 */
class ApiActivity : AppCompatActivity() {

    fun start(ctx: Context) {
        ctx.startActivity(Intent(ctx, ApiActivity::class.java).apply {
        })
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.act_api)
    }


}