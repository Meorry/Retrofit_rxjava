package cn.com.ljy.retrofitrxjavademo.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import cn.com.ljy.retrofitrxjavademo.mvp.MvpPresenter;
import cn.com.ljy.retrofitrxjavademo.mvp.MvpView;

/**
 * Created by lijiyuan on 2017/7/20.
 */

public abstract class BaseActivity extends AppCompatActivity  implements MvpView {

    private List<MvpPresenter> mPresenters = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        ButterKnife.bind(this);
        initView();
        initPresenter(mPresenters);
        for(MvpPresenter presenter : mPresenters){
            if(presenter == null) continue;
            presenter.attachView(this);
        }
        initData();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        for(MvpPresenter presenter : mPresenters){
            if(presenter == null) continue;
            presenter.detachView();
        }
    }

    /**
     * 获取布局文件
     * @return
     */
    public abstract int getContentView();

    /**
     * 初始化界面
     */
    public abstract void initView();

    /**
     * 初始化数据
     */
    public abstract void initData();

}
