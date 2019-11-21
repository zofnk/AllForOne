package com.allforone.ktx

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  11.21. 23:01
 */
val <T> Observable<T>.schedule: Observable<T>
    get() = subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())

