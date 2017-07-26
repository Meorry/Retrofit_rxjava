package cn.com.ljy.retrofitrxjavademo.presenter;

import cn.com.ljy.retrofitrxjavademo.mvp.MvpModel;
import cn.com.ljy.retrofitrxjavademo.mvp.MvpPresenter;
import cn.com.ljy.retrofitrxjavademo.mvp.MvpView;

/**
 * Created by lijiyuan on 2017/7/25.
 */

public abstract class BasePresenter<T extends MvpView, M extends MvpModel> implements MvpPresenter<T, M> {
    private T mvpView;

    @Override
    public void attachView(T view) {
        this.mvpView = view;
    }

    @Override
    public void detachView() {
        this.mvpView = null;
    }

    public T getView(){
        return mvpView;
    }
}
