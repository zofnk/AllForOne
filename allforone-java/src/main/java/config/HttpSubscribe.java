package config;

import android.content.Context;
import android.widget.Toast;


import bean.newss;
import io.reactivex.Observable;
import io.reactivex.observers.DisposableObserver;
import netUtils.NetworkUtils;
import netUtils.RetrofitFactory;

/**
 * Created by Administrator on 2019/11/19.
 */

public class HttpSubscribe {

    public static void getNews(Context context,String type,String key,DisposableObserver<newss> subscriber){
        if (NetworkUtils.isNetWorkAvailable(context)){
            Observable<newss> news = RetrofitFactory.getInstance().create(HttpApi.class).getNews(type,key);
            RetrofitFactory.getInstance().toSubscribe(news,subscriber);
        }else{
            Toast.makeText(context,"网络连接错误,请检查网络",Toast.LENGTH_LONG).show();
        }
    }


    public static void postNews(Context context,String type,String key,DisposableObserver<newss> subscriber){
        if (NetworkUtils.isNetWorkAvailable(context)){
            Observable<newss> news = RetrofitFactory.getInstance().create(HttpApi.class).postNews(type,key);
            RetrofitFactory.getInstance().toSubscribe(news,subscriber);
        }else{
            Toast.makeText(context,"网络连接错误,请检查网络",Toast.LENGTH_LONG).show();
        }
    }

}
