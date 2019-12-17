package com.allforone.ui.api

import android.app.Application
import com.allforone.bean.SearchBean
import com.allforone.bean.SearchListBean
import common.ktx.*
import io.reactivex.Observable
import kotlinx.coroutines.ExperimentalCoroutinesApi
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
    private val mainRepo by lazy { NetRepository() }

    //rx基本请求
    fun loadDataWithRx() {
        mainRepo
            .searchAnimation("一")
            .compose(injectLifecycle())
            .responseSubscribe {


                onSuccess = {
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

        flowRequest<SearchListBean<SearchBean>> {

            onStart = {
                Thread.currentThread().name.logE("onStart Thread : ")
            }

            onRequest = {
                Thread.currentThread().name.logE("onRequest Thread : ")
                mainRepo
                    .searchAnimation2(key = "一")
                    .responseTransformer()
            }

            onSuccess = {
                Thread.currentThread().name.logE("onSuccess Thread : ")
                resultTask.postValue(it.List[0].Name)
            }

            onError = {
                Thread.currentThread().name.logE("onError Thread : ")
                it.msg.logE()
                toast(it.msg)
            }

            onComplete = {
                Thread.currentThread().name.logE("onComplete Thread : ")
            }
        }

        /*createRequest<SearchListBean<SearchBean>> {

            onRequest = {
                mainRepo.searchAnimation2(key = "一")
            }

            onSuccess = {
                resultTask.postValue(it.List[0].Name)
            }

            onError = {
                toast(it.msg)
            }
        }*/
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
                mainRepo
                    .searchAnimation2("一")
                    .responseTransformer()
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
}