package com.allforone.ui.api

import android.app.Application
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import com.allforone.bean.SearchBean
import com.allforone.bean.SearchListBean
import common.ktx.logE
import common.ktx.submitImage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*
import mvvm.core.BaseViewModel
import mvvm.ktx.*
import mvvm.livedata.SingleLiveData

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  2019-11-29. 09:03
 */
class NetViewModel(app: Application) : BaseViewModel(app) {

    val resultTask = SingleLiveData<String>()
    val imageTask = SingleLiveData<Drawable>()
    private val mainRepo by lazy { NetRepository() }

    //kotlin基本请求
    @ExperimentalCoroutinesApi
    fun loadDataWithKotlin() {

        createRequest<SearchListBean<SearchBean>> {

            onStart = {
                "kt onStart Thread id : ${Thread.currentThread().id}  name : ${Thread.currentThread().name}".logE()
            }

            onRequest = {
                "kt onRequest Thread id : ${Thread.currentThread().id}  name : ${Thread.currentThread()}".logE()
                mainRepo.searchAnimation2(key = "一")
            }

            onSuccess = {
                "kt onSuccess Thread id : ${Thread.currentThread().id}  name : ${Thread.currentThread().name}".logE()
                resultTask.postValue(it.List[0].Name)
            }

            onError = {
                "kt onError Thread id : ${Thread.currentThread().id}  name : ${Thread.currentThread().name}".logE()
                it.msg.logE()
                toast(it.msg)
            }

            onComplete = {
                "kt onComplete Thread id : ${Thread.currentThread().id}  name : ${Thread.currentThread().name}".logE()
            }
        }
    }

    //Kotlin嵌套请求
    fun nestedRequestWithKotlin() {
        createRequest<SearchListBean<SearchBean>> {

            val sb = StringBuffer()

            onRequest = {
                val bean = mainRepo.getBanner(type = 1, area = 9)
                sb.append(bean.List[0].Title + '\n')
                mainRepo.searchAnimation2("一")
            }

            onSuccess = {
                sb.append(it.List[0].Name)
                resultTask.postValue(sb.toString())
            }

            onError = {
                toast(it.msg)
            }
        }
    }


    val ims = listOf(
        "http://img3.imgtn.bdimg.com/it/u=3543839312,2262585839&fm=26&gp=0.jpg",
        "http://img3.imgtn.bdimg.com/it/u=3543839312,2262585839&fm=26&gp=0.jpg",
        "httpimg3",
        "httpimg3",
        "http://img3.imgtn.bdimg.com/it/u=3543839312,2262585839&fm=26&gp=0.jpg",
        "http://img3.imgtn.bdimg.com/it/u=3543839312,2262585839&fm=26&gp=0.jpg"
    )

    @FlowPreview
    @ExperimentalCoroutinesApi
    fun downloadImage() {

        //Kotlin实现方式
        launchUI {
            scheduleMain {
                flow {
                    ims.forEach { emit(it) }
                }
                    .flatMapConcat {
                        emitFlow { submitImage(it) }
                            .catch {
                                emit(ColorDrawable(ContextCompat.getColor(ctx, android.R.color.white)))
                            }
                    }
                    .flowOn(Dispatchers.IO)
                    .onStart { "开始下载图片".logE() }
                    .onCompletion { "图片下载结束".logE() }
                    .collect { "下载成功 $it".logE() }
            }
        }
    }
}