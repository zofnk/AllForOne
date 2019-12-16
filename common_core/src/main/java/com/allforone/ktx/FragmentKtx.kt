package com.allforone.ktx

import android.content.Context
import androidx.fragment.app.Fragment

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  2019-11-11. 11:33
 */
val Fragment.ctx: Context
    get() = requireContext()