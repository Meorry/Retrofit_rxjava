package cn.com.ljy.retrofitrxjavademo.model;

import android.util.Log;

import cn.com.ljy.retrofitrxjavademo.entry.BaseResultBean;
import cn.com.ljy.retrofitrxjavademo.mvp.MvpModel;
import rx.Subscriber;

/**
 * Created by lijiyuan on 2017/7/21.
 * 统一封装请求结果封装
 */

public class ProgressResultSubscriber<T> extends Subscriber<T> implements MvpModel{

    public static final int RESULT_SUCCESS = 1;   //请求成功
    public static final int RESULT_MESSAGE = 2;   //提示消息
    public static final int RESULT_SYS_ERR = 3;   //系统异常

    private OnResult mResult;

    public interface OnResult<V> {
        void result(V response);
        void onFaild(String faildMsg);
    }
    public ProgressResultSubscriber(OnResult result){
        mResult = result;
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        Log.d("main", "错误= " + e.getMessage());
    }

    @Override
    public void onNext(T t) {
        BaseResultBean resultBean = (BaseResultBean) t;
        switch (resultBean.getStatus()) {
            case RESULT_SUCCESS:
                if (resultBean.getData() == null) {
                    mResult.result(resultBean);
                } else {
                    mResult.result(resultBean.getData());
                }
                break;
            case RESULT_MESSAGE:
                Log.d("OkHttp", "Service Message : " + resultBean.getMessage());
                mResult.onFaild(resultBean.getMessage());
                break;
            case RESULT_SYS_ERR:
                Log.e("OkHttp", "Service Fail : " + resultBean.getMessage());
                mResult.onFaild(resultBean.getMessage());
                break;
        }
    }
}
