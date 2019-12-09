package com.allforone.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.allforone.R
import com.allforone.ktx.activity
import com.allforone.ktx.click
import com.allforone.ktx.createViewModel
import com.allforone.ui.api.NetActivity
import com.allforone.ui.click.ClickActivity
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  11.21. 20:12
 */
class MainActivity : AppCompatActivity() {

    private lateinit var mainVM: ListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainVM = createViewModel(ListViewModel::class.java)
        initViews()
    }

    private fun initViews() {
        btnNet.click { NetActivity.start(activity) }
        btnList.click { ListActivity.start(activity) }
        btnClick.click { ClickActivity.start(activity) }
    }
}