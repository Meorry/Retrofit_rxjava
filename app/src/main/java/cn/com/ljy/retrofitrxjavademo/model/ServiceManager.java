package cn.com.ljy.retrofitrxjavademo.model;

import cn.com.ljy.retrofitrxjavademo.retrofit.RetrofitManager;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by lijiyuan on 2017/7/20.
 */

public class ServiceManager {

    private ApiService mApiService;
    private static ServiceManager mInstance;

    public static ServiceManager getInstance(){
        if(mInstance == null){
            synchronized (ServiceManager.class){
                mInstance = new ServiceManager();
            }
        }
        return mInstance;
    }
    private ServiceManager() {
        mApiService = RetrofitManager.getInstance().getRetrofit().create(ApiService.class);
    }

    public static  <T> Observable callResult(Observable<T> observable, Subscriber<T> subscriber){
       observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
        return observable;
    }

    public ApiService getApiserVice(){
        return mApiService;
    }
}
