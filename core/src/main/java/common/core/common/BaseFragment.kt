package common.core.common

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Create Time :  2020-7-28. 09:37
 */
abstract class BaseFragment : Fragment() {

    protected inline fun <reified T : ViewDataBinding> binding(
        inflater: LayoutInflater,
        @LayoutRes resId: Int,
        container: ViewGroup?
    ): T = DataBindingUtil.inflate(inflater, resId, container, false)

    protected inline fun <reified T : ViewModel> viewModels(): Lazy<T> = lazy {
        ViewModelProvider(requireActivity()).get(T::class.java)
    }
}