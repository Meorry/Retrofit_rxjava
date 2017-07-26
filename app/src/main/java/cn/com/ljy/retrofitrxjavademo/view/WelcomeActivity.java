package cn.com.ljy.retrofitrxjavademo.view;

import android.content.Context;
import android.content.Intent;
import android.widget.ImageView;

import java.util.List;

import butterknife.BindView;
import cn.com.ljy.retrofitrxjavademo.R;
import cn.com.ljy.retrofitrxjavademo.mvp.MvpPresenter;
import cn.com.ljy.retrofitrxjavademo.utils.GlideManager;

/**
 * Created by lijiyuan on 2017/7/20.
 */

public class WelcomeActivity extends BaseActivity {

    private static final String IMAGE_URL = "http://japi.juhe.cn";
    @BindView(R.id.image_welcome)
    ImageView imageWelcome;

    @Override
    public int getContentView() {
        return R.layout.activity_welcome;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {
        GlideManager.loadImageView(this, IMAGE_URL, imageWelcome);
    }

    public static void startActivity(Context context){
        Intent intent = new Intent(context, WelcomeActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void initPresenter(List<MvpPresenter> presenters) {

    }
}
