package com.allforone

import com.allforone.http.ApiService
import com.allforone.http.RetrofitClient
import com.allforone.ui.test.TestRepository
import com.allforone.ui.test.TestViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Create Time :  2020-7-27. 14:30
 */
val httpModule = module {
    single {
        RetrofitClient
            .retrofitBuilder
            .baseUrl("http://all.api.acgneta.com")
            .build()
            .create(ApiService::class.java)
    }
}

val testModule = module {
    single { TestRepository(get()) }
    viewModel { TestViewModel(get()) }
}