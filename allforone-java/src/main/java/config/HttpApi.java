package config;


import bean.newss;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by zbf on 2018/3/27.
 * <p>
 * 存放所有的Api
 */

public interface HttpApi {
    @POST("toutiao/index")
    Observable<newss> postNews(@Query("type") String version, @Query("key") String key);

    @GET("toutiao/index")
    Observable<newss> getNews(@Query("type") String version, @Query("key") String key);

}
