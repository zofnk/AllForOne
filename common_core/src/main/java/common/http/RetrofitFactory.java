package common.http;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by zbf on 2019/8/26.
 */

public class RetrofitFactory {

    public String TAG = "RetrofitFactory";

    private static final int DEFAULT_CONNECT_TIMEOUT = 30;  // 链接超时时间
    private static final int DEFAULT_WRITE_TIMEOUT = 30;    // 写超时时间
    private static final int DEFAULT_READ_TIMEOUT = 30;     // 读超时时间
    private  Retrofit mRetrofit = null;

    private RetrofitFactory(){

            OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder();
            okHttpBuilder.connectTimeout(DEFAULT_CONNECT_TIMEOUT, TimeUnit.SECONDS);
            okHttpBuilder.writeTimeout(DEFAULT_WRITE_TIMEOUT,TimeUnit.SECONDS);
            okHttpBuilder.readTimeout(DEFAULT_READ_TIMEOUT,TimeUnit.SECONDS);
            //错误重连
            okHttpBuilder.retryOnConnectionFailure(true);
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                @Override
                public void log(String message) {
                    Log.d(TAG,message);
                }


            });
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            //网络请求日志
            okHttpBuilder.addInterceptor(loggingInterceptor);

            mRetrofit = new Retrofit.Builder()
                    .client(okHttpBuilder.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .baseUrl("https://v.juhe.cn/")
                    .build();
    }


    //  单实例
    private static class SignletonHolder{
        private static final RetrofitFactory INSTANCE = new RetrofitFactory();
    }

    public static RetrofitFactory getInstance(){
        return SignletonHolder.INSTANCE;
    }

    /**
     * 获取对应的Service
     */
    public<T> T create(Class<T> servicr){
        return mRetrofit.create(servicr);
    }

    /**
     * 设置订阅 和 所在的线程环境
     */
    public <T> void toSubscribe(Observable<T> o, DisposableObserver<T> s) {
        o.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s);
    }


}
