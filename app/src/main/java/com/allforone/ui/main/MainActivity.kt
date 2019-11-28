package com.allforone.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.allforone.R
import com.allforone.bean.newss
import com.allforone.http.NetSubscribe
import com.allforone.http.listener.OnSuccessAndFaultListener
import com.allforone.http.listener.OnSuccessAndFaultSub
import com.allforone.ktx.activity
import com.allforone.ktx.click
import com.allforone.ktx.createVM
import com.allforone.ktx.logE
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
        mainVM = createVM(MainViewModel::class.java)
        initViews()
    }

    private fun initViews() {

        rvMain.adapter = mainVM.mainAdapter

        //展示vm处理好的数据
        mainVM.content.observe(activity, Observer { tv_content.text = it })

        //点击加载数据
        tv_get.click { mainVM.loadData() }

        tv_post.click {

            mainVM.api2()


//            NetSubscribe.getNews(
//                activity,
//                "top",
//                "9f552a8aca577737335c7106f1236a97",
//                OnSuccessAndFaultSub(object : OnSuccessAndFaultListener<newss> {
//                    override fun onSuccess(result: newss) {
//                        tv_content.text = result.result.data[0].title
//                    }
//
//                    override fun onFault(errorMsg: String) {
//                        tv_content.text = "错误信息:$errorMsg"
//                    }
//                })
//            )
        }
    }
}