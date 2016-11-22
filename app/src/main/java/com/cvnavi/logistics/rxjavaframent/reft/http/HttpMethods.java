package com.cvnavi.logistics.rxjavaframent.reft.http;

import com.cvnavi.logistics.rxjavaframent.cache.httpcache.ForceCachedInterceptor;
import com.cvnavi.logistics.rxjavaframent.reft.httpapi.HttpApiService;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by liukun on 16/3/9.
 */
public class HttpMethods {

//    public static final String BASE_URL = "https://api.douban.com/v2/movie/";
    public static String Host_Url = "http://10.10.11.112:8090/api/Login/Login/";//外网
//    public static String Host_Url = "http://116.228.114.206/8090/api/Login/Login/";//外网

    private static final int DEFAULT_TIMEOUT = 5;

    private Retrofit retrofit;
    private HttpApiService movieService;
    private ForceCachedInterceptor mInterceptor=new ForceCachedInterceptor();//缓存拦截器
    //构造方法私有
    private HttpMethods() {
        HttpLoggingInterceptor interceptor=new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        //手动创建一个OkHttpClient并设置超时时间
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        builder.addInterceptor(interceptor);
        builder.addInterceptor(mInterceptor);
        builder.retryOnConnectionFailure(true);//错误重连
        retrofit = new Retrofit.Builder()
                .client(builder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(Host_Url)
                .build();

        movieService = retrofit.create(HttpApiService.class);
    }

    //在访问HttpMethods时创建单例
    private static class SingletonHolder{
        private static final HttpMethods INSTANCE = new HttpMethods();
    }

    //获取单例
    public static HttpMethods getInstance(){
        return SingletonHolder.INSTANCE;
    }

    public HttpApiService getHttpApiService(){
        return movieService;
    }

    public  <T> void toSubscribe(Observable<T> o, Subscriber<T> s){
        o.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s);
    }
}
