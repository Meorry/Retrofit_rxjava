package cn.com.ljy.retrofitrxjavademo.mvp;

import java.util.List;

/**
 * Created by lijiyuan on 2017/7/25.
 */

public interface MvpView {
    void initPresenter(List<MvpPresenter> presenters);
}
