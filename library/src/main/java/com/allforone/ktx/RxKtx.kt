package com.allforone.ktx

import com.allforone.data.NetResponse
import com.allforone.http.ApiConvers
import com.allforone.http.NetExceptionObservable
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  11.21. 23:01
 */
//切换线程
val <T> Observable<T>.schedule: Observable<T>
    get() = subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())

//项目实体类转换
val <T, R : NetResponse<T>> Observable<R>.convers: Observable<T>
    get() = schedule
        .map(ApiConvers())
        .onErrorResumeNext(NetExceptionObservable())