package com.allforone.ui.download

import android.app.Application
import mvvm.core.BaseViewModel

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Create Time :  2019-12-20. 11:44
 */
class DownLoadViewModel(app: Application) : BaseViewModel(app) {

    val fileAdapter: FileAdapter by lazy { FileAdapter() }

    init {
        val list = mutableListOf(
            FileBean(
                "Arknights",
                "http://k4.leaderhero.com/20190820/com.hypergryph.arknights19082017.apk",
                "http://im5.pandahelp.vip/panda/201908/3e685801-a.jpg"
            ),
            FileBean(
                "BoBoiBoy",
                "http://k4.leaderhero.com/20190911/com.alkemis.boboiboy19091116.apk",
                "http://im5.pandahelp.vip/panda/201909/94a9b8fc-6.jpg"
            ),
            FileBean(
                "元气骑士",
                "http://k4.leaderhero.com/20191205/com.ChillyRoom.DungeonShooter19120515.apk",
                "http://im5.pandahelp.vip/panda/201902/37550ad7-8.jpg"
            )
        )
        fileAdapter.setNewData(list)
    }
}