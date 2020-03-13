package common.core.common

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Create Time :  2019-12-16. 11:31
 */
abstract class CommonActivity : AppCompatActivity() {

    abstract fun bindLayoutId(): Int

    abstract fun onCreated(savedInstanceState: Bundle?)
}