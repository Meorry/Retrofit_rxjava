package cn.com.ljy.retrofitrxjavademo.retrofit;

import java.util.concurrent.TimeUnit;

import cn.com.ljy.retrofitrxjavademo.BuildConfig;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by lijiyuan on 2017/7/20.
 */

public class OkHttpClientManage {
    public static final int HTTP_CONNECT_TIMEOUT = 30 * 1000;//毫秒数
    public static final int HTTP_READ_TIMEOUT = 30 * 1000;//毫秒数
    public static final int HTTP_WRITE_TIMEOUT = 30 * 1000;//毫秒数

    private static OkHttpClientManage mInstance;
    private OkHttpClient mOkHttpClient;

    public static OkHttpClientManage getInstance(){
        if(mInstance == null){
            synchronized (OkHttpClientManage.class){
                mInstance = new OkHttpClientManage();
            }
        }
        return mInstance;
    }

    /**
     * 创建OkHttpClient
     */
    private OkHttpClientManage() {
        OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder()
                .connectTimeout(HTTP_CONNECT_TIMEOUT, TimeUnit.MILLISECONDS)
                .readTimeout(HTTP_READ_TIMEOUT, TimeUnit.MILLISECONDS)
                .writeTimeout(HTTP_WRITE_TIMEOUT, TimeUnit.MILLISECONDS);
        if(BuildConfig.DEBUG){
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);
            okHttpBuilder.addInterceptor(logging);
        }
        mOkHttpClient = okHttpBuilder.build();
    }

    /**
     * 获取OkHttpClient实例
     * @return
     */
    public OkHttpClient getOkHttpClient(){
        return mOkHttpClient;
    }
}
