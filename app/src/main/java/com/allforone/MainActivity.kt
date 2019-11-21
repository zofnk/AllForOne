package com.allforone

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.allforone.bean.newss
import com.allforone.http.NetSubscribe
import com.allforone.http.listener.OnSuccessAndFaultListener
import com.allforone.http.listener.OnSuccessAndFaultSub
import com.allforone.ktx.activity
import com.allforone.ktx.logE
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  11.21. 20:12
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    private fun initViews() {

        tv_get.setOnClickListener {
            NetSubscribe.getNews(
                activity,
                "top",
                "9f552a8aca577737335c7106f1236a97",
                OnSuccessAndFaultSub(object : OnSuccessAndFaultListener<newss> {

                    override fun onSuccess(result: newss) {
                        tv_get.text = result.result.data[0].title
                    }

                    override fun onFault(errorMsg: String) {
                        Log.e("zbf", "错误信息:$errorMsg")
                        "错误信息:$errorMsg".logE()
                    }
                })
            )
        }

        tv_post.setOnClickListener {
            NetSubscribe.postNews(
                activity,
                "top",
                "9f552a8aca577737335c7106f1236a97",
                OnSuccessAndFaultSub(object : OnSuccessAndFaultListener<newss> {
                    override fun onSuccess(result: newss) {
                        tv_post.text = result.result.data[0].title
                    }

                    override fun onFault(errorMsg: String) {
                        "错误信息:$errorMsg".logE()
                    }
                })
            )
        }
    }
}