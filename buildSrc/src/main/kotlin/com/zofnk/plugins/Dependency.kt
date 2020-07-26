package com.zofnk.plugins

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  2020/7/26. 00:48
 */
internal object Versions {

    const val Gradle = "4.0.1"
    const val Maven = "2.1"
    const val CheckVersionPlugin = "0.29.0"
    const val Aop = "2.0.4"

    const val Kotlin = "1.3.72"
    const val KotlinCore = "1.3.0"
    const val Coroutines = "1.2.1"

    const val Appcompat = "1.0.0"
    const val RecyclerView = "1.0.0"
    const val ConstraintLayout = "1.1.3"
    const val Material = "1.0.0"

    const val Paging = "3.0.0-alpha02"
    const val DataBinding = "4.0.1"
    const val Lifecycle = "2.1.0"

    const val KLog = "1.6.0"
    const val OkDownload = "1.0.6"

    const val OkHttp = "4.2.2"
    const val Retrofit = "2.7.0"
    const val GsonConverter = "2.6.0"
    const val LogInterceptor = "3.11.0"

    const val Koin = "2.1.6"
    const val Glide = "4.10.0"

    const val Bravh = "3.0.4"
}

object Build {
    const val Gradle = "com.android.tools.build:gradle:${Versions.Gradle}"
    const val Plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.Kotlin}"
    const val Maven = "com.github.dcendents:android-maven-gradle-plugin:${Versions.Maven}"
    const val CheckVersionPlugin = "com.github.ben-manes:gradle-versions-plugin:${Versions.CheckVersionPlugin}"
    const val Aop = "com.hujiang.aspectjx:gradle-android-plugin-aspectjx:${Versions.Aop}"
    const val Koin = "org.koin:koin-gradle-plugin:${Versions.Koin}"
}

object Kotlin {
    const val Jdk = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.Kotlin}"
    const val Core = "androidx.core:core-ktx:${Versions.KotlinCore}"

    object Coroutines {
        const val Core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.Coroutines}"
        const val Android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.Coroutines}"
    }
}

object Appcompat {
    const val Appcompat = "androidx.appcompat:appcompat:${Versions.Appcompat}"
    const val RecyclerView = "androidx.recyclerview:recyclerview:${Versions.RecyclerView}"
    const val ConstraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.ConstraintLayout}"
    const val Material = "com.google.android.material:material:${Versions.Material}"
}

object JetPack {
    const val DataBinding = "com.android.databinding:compiler:${Versions.DataBinding}"
    const val Paging = "androidx.paging:paging-runtime:${Versions.Paging}"

    object Lifecycle {
        const val Extensions = "androidx.lifecycle:lifecycle-extensions:${Versions.Lifecycle}"
        const val ViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.Lifecycle}"
        const val LiveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.Lifecycle}"
    }
}

object Tool {
    const val KLog = "com.github.zhaokaiqiang.klog:library:${Versions.KLog}"
    const val Brvah = "com.github.CymChad:BaseRecyclerViewAdapterHelper:${Versions.Bravh}"

    object OkDownload {
        const val Core = "com.liulishuo.okdownload:okdownload:${Versions.OkDownload}"
        const val SQL = "com.liulishuo.okdownload:sqlite:${Versions.OkDownload}"
        const val Ktx = "com.liulishuo.okdownload:ktx:${Versions.OkDownload}"
    }

    object Koin {
        // Koin for Kotlin
        const val Core = "org.koin:koin-core:${Versions.Koin}"
        // Koin extended & experimental features
        const val CoreExt = "org.koin:koin-core-ext:${Versions.Koin}"
        // Koin AndroidX Scope features
        const val Scope = "org.koin:koin-androidx-scope:${Versions.Koin}"
        // Koin AndroidX ViewModel features
        const val ViewModel = "org.koin:koin-androidx-viewmodel:${Versions.Koin}"
        // Koin AndroidX Fragment features
        const val Fragment = "org.koin:koin-androidx-fragment:${Versions.Koin}"
        // Koin AndroidX Experimental features
        const val Ext = "org.koin:koin-androidx-ext:${Versions.Koin}"
        // Koin for Ktor Kotlin
        const val Koter = "org.koin:koin-ktor:${Versions.Koin}"
    }
}

object Http {
    const val OkHttp = "com.squareup.okhttp3:okhttp:${Versions.OkHttp}"
    const val Retrofit = "com.squareup.retrofit2:retrofit:${Versions.Retrofit}"
    const val GsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.GsonConverter}"
    const val LogInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.LogInterceptor}"
}

object Glide {
    const val Glide = "com.github.bumptech.glide:glide:${Versions.Glide}"
    const val Compiler = "com.github.bumptech.glide:compiler:${Versions.Glide}"
    const val Integration = "com.github.bumptech.glide:okhttp3-integration:${Versions.Glide}"
}