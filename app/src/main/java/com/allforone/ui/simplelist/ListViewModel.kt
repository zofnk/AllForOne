package com.allforone.ui.main

import android.app.Application
import androidx.databinding.ObservableArrayList
import com.allforone.bean.BannerBean
import com.allforone.core.vm.BaseViewModel
import com.allforone.ui.simplelist.SimpleListAdapter
import com.allforone.ui.simplelist.SimpleTestBean
import kotlin.random.Random

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  11.21. 22:46
 */
class ListViewModel(app: Application) : BaseViewModel(app) {


    val simpleAdapter = SimpleListAdapter()
    val dataList = ObservableArrayList<SimpleTestBean>()

    init {
        loadLocaleData()
    }

    fun removeItem() {
        val index = Random.nextInt(dataList.size)
        dataList.removeAt(index)
    }

    private fun loadLocaleData() {

        for (index in 0..20) {
            dataList += SimpleTestBean("title $index")
        }

    }

}