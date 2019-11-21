package com.allforone.core.vm

import android.app.Application
import androidx.lifecycle.AndroidViewModel

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  11.21. 22:47
 */
abstract class BaseViewModel(app: Application) : AndroidViewModel(app) {

    abstract fun loadData()
}