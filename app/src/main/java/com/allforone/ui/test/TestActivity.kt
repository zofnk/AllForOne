package com.allforone.ui.test

import android.os.Bundle
import com.allforone.R
import com.allforone.databinding.ActivityTestBinding
import common.core.common.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Create Time :  2020-7-27. 11:28
 */
class TestActivity : BaseActivity() {

    private val binding: ActivityTestBinding by binding(R.layout.activity_test)
    private val viewModel: TestViewModel by viewModel()

    override fun init(savedInstanceState: Bundle?) {
        binding
    }

}