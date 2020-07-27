package com.allforone

import com.allforone.ui.test.TestRepository
import com.allforone.ui.test.TestViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Create Time :  2020-7-27. 14:30
 */
val testModule = module {
    single { TestRepository() }
    viewModel { TestViewModel(get()) }
}