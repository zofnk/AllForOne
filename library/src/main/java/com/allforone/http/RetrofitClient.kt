package com.allforone.http

import com.allforone.core.CommonConfig
import com.allforone.http.interceptor.HttpLoggingInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import java.util.logging.Level

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  11.11. 18:52
 */
object RetrofitClient {

    private const val timeOutValue = 10L
    val globalHeaders = arrayListOf<Pair<String, String>>()

    val retrofitBuilder: Retrofit.Builder by lazy {
        Retrofit.Builder()
            .client(okHttpManager.build())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
    }

    private val okHttpManager by lazy {
        OkHttpClient().newBuilder()
            .connectTimeout(timeOutValue, TimeUnit.SECONDS)
            .readTimeout(timeOutValue, TimeUnit.SECONDS)
            .writeTimeout(timeOutValue, TimeUnit.SECONDS)
            .addInterceptor(
                HttpLoggingInterceptor(CommonConfig.defaultTagLog)
                    .apply {
                        setPrintLevel(HttpLoggingInterceptor.Level.BODY)
                        setColorLevel(Level.INFO)
                    })

        /* HttpCacheInterceptor().apply {
             addInterceptor(this)
             addNetworkInterceptor(this)
         }

         val cacheFile = File(BaseApp.getAppContext().cacheDir, Constants.PATH_REQUEST_CACHE)
         cache(Cache(cacheFile, Constants.OKHTTP_CACHE_SIZE))*/


    }
}