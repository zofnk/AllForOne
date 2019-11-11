package com.dokong.allforone.http

import com.dokong.allforone.core.CommonConfig
import com.dokong.allforone.http.interceptor.HttpLoggingInterceptor
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.io.File
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

    //TODO()
    val retrofit by lazy {

    }

    private val okHttpManager by lazy {
        OkHttpClient().newBuilder()
            .connectTimeout(timeOutValue, TimeUnit.SECONDS)
            .readTimeout(timeOutValue, TimeUnit.SECONDS)
            .writeTimeout(timeOutValue, TimeUnit.SECONDS)
            .addInterceptor(HttpLoggingInterceptor(CommonConfig.defaultTagLog)
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