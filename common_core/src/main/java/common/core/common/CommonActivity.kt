package common.core.common

import android.os.Bundle
import com.trello.rxlifecycle3.components.support.RxAppCompatActivity

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Create Time :  2019-12-16. 11:31
 */
abstract class CommonActivity : RxAppCompatActivity() {

    abstract fun bindLayoutId(): Int

    abstract fun onCreated(savedInstanceState: Bundle?)
}