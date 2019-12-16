package com.allforone.ktx

import android.content.Context
import android.content.SharedPreferences
import androidx.collection.ArraySet
import androidx.fragment.app.Fragment

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  2019-11-22. 16:00
 */
fun Context.sp(name: String): SharedPreferences = getSharedPreferences(name, Context.MODE_PRIVATE)

fun Fragment.sp(name: String) {
    ctx.sp(name)
}

inline fun <reified T> SharedPreferences.getObj(key: String): T? {
    val value = getString(key, null)
    if (value.isNullOrEmpty()) return null
    return value.toBean<T>()
}

fun SharedPreferences.edit(action: SharedPreferences.Editor.() -> Unit) {
    edit().apply { action() }.apply()
}

/**
 * put
 *
 * get直接用sp(name: String).getxxx()就行
 */

fun SharedPreferences.putString(key: String, value: String?) {
    edit { putString(key, value ?: "") }
}

fun SharedPreferences.putInt(key: String, value: Int?) {
    edit { putInt(key, value ?: 0) }
}

fun SharedPreferences.putFloat(key: String, value: Float?) {
    edit { putFloat(key, value ?: 0.toFloat()) }
}

fun SharedPreferences.putLong(key: String, value: Long?) {
    edit { putLong(key, value ?: 0.toLong()) }
}

fun SharedPreferences.putBoolean(key: String, value: Boolean?) {
    edit { putBoolean(key, value ?: false) }
}

fun SharedPreferences.putStringSet(key: String, value: Set<String>?) {
    edit { putStringSet(key, value ?: ArraySet<String>()) }
}

fun SharedPreferences.putObj(key: String, value: Any?) {
    putString(key, value?.toJson() ?: "")
}

fun SharedPreferences.clear() {
    edit { clear() }
}