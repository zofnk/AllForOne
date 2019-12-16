package common.http

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.Registry
import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.module.LibraryGlideModule
import java.io.InputStream


/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Create Time :  2019-12-10. 10:53
 */
//@GlideModule
@Deprecated(
    message = "kotlin kapt in glide had some bug",
    replaceWith = ReplaceWith(expression = "OkHttp3GlideModule()")
)
internal class OkHttpLibraryGlideModule : LibraryGlideModule() {

    override fun registerComponents(context: Context, glide: Glide, registry: Registry) {
        registry.replace(GlideUrl::class.java, InputStream::class.java, OkHttpUrlLoader.Factory())
    }
}