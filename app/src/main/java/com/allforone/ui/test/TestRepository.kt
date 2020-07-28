package com.allforone.ui.test

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.asLiveData
import androidx.lifecycle.liveData
import com.allforone.App
import com.allforone.http.ApiService
import common.core.repo.BaseRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart
import okhttp3.Dispatcher
import kotlin.math.log

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Create Time :  2020-7-27. 14:29
 */
class TestRepository(
    private val api: ApiService
) : BaseRepository() {

    fun requireBanner() =
        flow {
            emit(api.banner(1, 1, 10, 0))
        }
            .onStart { Log.e("", "start") }
            .flowOn(Dispatchers.Main)
            .asLiveData(Dispatchers.IO)
}