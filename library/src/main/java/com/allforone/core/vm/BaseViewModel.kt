package com.allforone.core.vm

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import com.allforone.core.common.IBaseViewModel
import com.trello.rxlifecycle3.LifecycleProvider
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import java.lang.ref.WeakReference

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  11.21. 22:47
 */
abstract class BaseViewModel(app: Application) : AndroidViewModel(app), IBaseViewModel {

    //弱引用持有
    private var lifecycle: WeakReference<LifecycleProvider<*>>? = null
    private val compositeDisposable: CompositeDisposable by lazy { CompositeDisposable() }

    fun injectLifecycleProvider(lifecycle: LifecycleProvider<*>) {
        this.lifecycle = WeakReference(lifecycle)
    }

    val lifecycleProvider get() = lifecycle?.get()



    fun addDisposables(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

    override fun onAny(owner: LifecycleOwner, event: Lifecycle.Event) {
    }

    override fun onCreate() {
    }

    override fun onDestroy() {
    }

    override fun onStart() {
    }

    override fun onStop() {
    }

    override fun onResume() {
    }

    override fun onPause() {
    }
}