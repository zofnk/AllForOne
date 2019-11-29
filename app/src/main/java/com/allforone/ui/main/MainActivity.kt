package com.allforone.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.allforone.R
import com.allforone.ktx.activity
import com.allforone.ktx.click
import com.allforone.ktx.createViewModel
import com.allforone.ui.api.NetActivity
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  11.21. 20:12
 */
class MainActivity : AppCompatActivity() {

    private lateinit var mainVM: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainVM = createViewModel(MainViewModel::class.java)
        initViews()
    }

    private fun initViews() {
        tv_get.click { NetActivity.start(activity) }
    }
}