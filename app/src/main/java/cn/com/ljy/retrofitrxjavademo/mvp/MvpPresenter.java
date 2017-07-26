package cn.com.ljy.retrofitrxjavademo.mvp;

/**
 * Created by lijiyuan on 2017/7/25.
 */

public interface MvpPresenter<T extends MvpView, M extends MvpModel> {
    //    绑定View控件
    void attachView(T view);
    //    注销View控件
    void detachView();
}
