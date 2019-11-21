package com.allforone.ui.main

import com.allforone.core.repo.BaseRepository
import com.allforone.ktx.Net

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  11.21. 22:51
 */
class MainRepository : BaseRepository() {

    val api: MainApi by lazy { Net.create(MainApi::class.java) }

    fun getNews(type:String ,
                token : String){

    }

}