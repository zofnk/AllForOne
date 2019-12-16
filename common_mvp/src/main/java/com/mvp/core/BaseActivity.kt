package com.mvp.core

import android.os.Bundle
import com.allforone.core.common.CommonActivity

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Create Time :  2019-12-16. 13:45
 */
abstract class BaseActivity : CommonActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(bindLayoutId())
        onCreated(savedInstanceState)
    }
}