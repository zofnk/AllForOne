package common.ktx

import android.content.Context
import android.view.View
import androidx.fragment.app.Fragment
import com.google.gson.Gson
import common.data.NetResponse
import common.http.RetrofitClient
import retrofit2.Retrofit

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  11.21. 20:38
 */
val Net: Retrofit.Builder get() = RetrofitClient.retrofitBuilder

fun Retrofit.Builder.url(url: String) {
    baseUrl(url)
}

fun <T> NetResponse<T>.toJson(): String = Gson().toJson(this)

val Context.netAvailable
    get() = common.utils.NetworkUtils.isNetWorkAvailable(this)

val Fragment.netAvailable
    get() = ctx.netAvailable

val View.netAvailable
    get() = ctx.netAvailable