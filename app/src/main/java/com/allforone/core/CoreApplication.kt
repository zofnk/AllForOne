package com.allforone.core

import android.app.Application
import com.xuexiang.xaop.XAOP
import common.core.CommonConfig

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Create Time :  2019-12-17. 10:44
 */
class CoreApplication : Application() {

    companion object {
        lateinit var application: Application
    }

    override fun onCreate() {
        super.onCreate()
        application = this

        CommonConfig.init(this, true, "Alkaid")

        XAOP.init(this)
        XAOP.setICacheKeyCreator {

            return@setICacheKeyCreator ""
        }
    }
}