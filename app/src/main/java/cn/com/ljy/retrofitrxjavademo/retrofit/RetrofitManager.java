package cn.com.ljy.retrofitrxjavademo.retrofit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

/**
 * Created by lijiyuan on 2017/7/20.
 */

public class RetrofitManager {

    private static  final String BASEURL = "http://japi.juhe.cn";
    private static RetrofitManager mInstance;
    private OkHttpClient mOkHttpClient;
    private Retrofit mRetrofit;

    /**
     * 创建retrofit
     */
    private RetrofitManager() {
        mOkHttpClient = OkHttpClientManage.getInstance().getOkHttpClient();
        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASEURL)
                .client(mOkHttpClient)
                .addConverterFactory(ToStringConverterFactory.create())
                .addConverterFactory(ToGsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    public static RetrofitManager getInstance(){
        if(mInstance == null){
            synchronized (RetrofitManager.class){
                mInstance = new RetrofitManager();
            }
        }
        return mInstance;
    }

    /**
     * 获取retrofit
     * @return
     */
    public Retrofit getRetrofit(){
        return mRetrofit;
    }
}
