package common.http;

import android.content.Context;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.Registry;
import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader;
import com.bumptech.glide.load.engine.cache.ExternalPreferredCacheDiskCacheFactory;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.module.AppGlideModule;

import org.jetbrains.annotations.NotNull;

import java.io.InputStream;

import okhttp3.OkHttpClient;

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Create Time :  2019-12-10. 13:24
 */
//@GlideModule
public class OkHttp3GlideModule extends AppGlideModule {

    private OkHttpClient.Builder manager;

    public OkHttp3GlideModule(OkHttpClient.Builder manager) {
        this.manager = manager;
    }

    @Override
    public void registerComponents(@NotNull Context context, Glide glide, @NotNull Registry registry) {
        OkHttpUrlLoader.Factory factory = new OkHttpUrlLoader.Factory(manager.build());
        glide.getRegistry().replace(GlideUrl.class, InputStream.class, factory);
    }

    @Override
    public void applyOptions(@NonNull Context context, @NonNull GlideBuilder builder) {
        long diskCacheSize = 500 * 1024 * 1024;
        builder
                .setDiskCache(new ExternalPreferredCacheDiskCacheFactory(context, diskCacheSize))
                .setMemoryCache(new LruResourceCache(diskCacheSize));
    }

    @Override
    public boolean isManifestParsingEnabled() {
        return false;
    }
}
