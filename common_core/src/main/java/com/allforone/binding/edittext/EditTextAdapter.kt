package com.allforone.binding.edittext

import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.widget.EditText
import androidx.databinding.BindingAdapter
import com.allforone.binding.EDIT_TOGGLE_PASSWORD

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  11.30. 00:21
 */
object EditTextAdapter {

    @JvmStatic
    @BindingAdapter(EDIT_TOGGLE_PASSWORD)
    fun EditText.togglePassword(show: Boolean) {
        transformationMethod =
            if (show) HideReturnsTransformationMethod.getInstance() else PasswordTransformationMethod.getInstance()
    }
}