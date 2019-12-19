package com.allforone.ui.api

import android.R
import android.app.Application
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import com.allforone.bean.SearchBean
import com.allforone.bean.SearchListBean
import common.ktx.*
import io.reactivex.Observable
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

    //rx基本请求
    fun loadDataWithRx() {
        mainRepo
            .searchAnimation("一")
            .compose(injectLifecycle())
            .responseSubscribe {

                onSuccess = {

                    Thread.currentThread()
                        .name.logE("rx onComplete Thread id : ${Thread.currentThread().id}  name : ")
                    resultTask.postValue(it.List[0].Name)
                }

                onError = {
                    toast(it.msg)
                }
            }
    }

    //kotlin基本请求
    @ExperimentalCoroutinesApi
    fun loadDataWithKotlin() {

        createRequest<SearchListBean<SearchBean>> {

            onStart = {
                Thread.currentThread()
                    .name.logE("kt onStart Thread id : ${Thread.currentThread().id}  name : ")
            }

            onRequest = {
                Thread.currentThread()
                    .name.logE("kt onRequest Thread id : ${Thread.currentThread().id}  name : ")
                mainRepo.searchAnimation2(key = "一")
            }

            onSuccess = {
                Thread.currentThread()
                    .name.logE("kt onSuccess Thread id : ${Thread.currentThread().id}  name : ")
                resultTask.postValue(it.List[0].Name)
            }

            onError = {
                Thread.currentThread()
                    .name.logE("kt onError Thread id : ${Thread.currentThread().id}  name : ")
                it.msg.logE()
                toast(it.msg)
            }

            onComplete = {
                Thread.currentThread()
                    .name.logE("kt onComplete Thread id : ${Thread.currentThread().id}  name : ")
            }
        }
    }

    //rx嵌套请求
    fun nestedRequestWithRxjava() {
        val sb = StringBuffer()
        mainRepo
            .getBannerList(type = 1, area = 9)
            .map {
                sb.append("第一层请求结果: \n")
                    .append(it.List[0].Title)
                    .append("\n\n")
                it
            }
            .flatMap { mainRepo.searchAnimation("一") }
            .compose(injectLifecycle())
            .responseSubscribe {

                onSuccess = {
                    sb.append("第二层请求结果:\n")
                        .append(it.List[0].Name)
                    resultTask.postValue(sb.toString())
                }

                onError = {
                    sb.append(it.msg)
                    resultTask.postValue(sb.toString())
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

    //rx合并请求
    fun mergeRequestWithRxjava() {
        val sb = StringBuffer()

        Observable.mergeDelayError(
            mainRepo.getBannerList(type = 1, area = 9)
                .handleNext {
                    sb.append(it.List[0].Title + '\n')
                }
                .handleError {
                    sb.append(it.msg + '\n')
                },
            mainRepo.searchAnimation(key = "一")
                .handleNext {
                    sb.append(it.List[0].Name + '\n')
                }
                .handleError {
                    sb.append(it.msg + '\n')
                }
        )
            .compose(injectLifecycle())
            .responseSubscribe {

                onComplete = {
                    resultTask.postValue(sb.toString())
                }

                onError = {
                    resultTask.postValue(sb.toString())
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
                                emit(ColorDrawable(ContextCompat.getColor(ctx, R.color.white)))
                            }
                    }
                    .flowOn(Dispatchers.IO)
                    .onStart { "开始下载图片".logE() }
                    .onCompletion { "图片下载结束".logE() }
                    .collect { it.toString().logE("下载成功") }
            }
        }

        //RxJava实现方式
        /*Observable
                .fromIterable(ims)
            .flatMap {
                Observable
                    .just(it)
                    .map { url ->
                        GlideApp.with(ctx)
                            .load(url)
                            .submit(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
                            .get()
                    }
                    .onErrorReturnItem(ColorDrawable(ContextCompat.getColor(ctx, R.color.white)))
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .responseSubscribe {

                onStart = { "开始下载图片".logE() }

                onSuccess = { it.toString().logE("下载成功") }

                onComplete = { "图片下载结束".logE() }
            }*/


    }
}