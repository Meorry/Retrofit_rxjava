package cn.com.ljy.retrofitrxjavademo.view;

import android.content.Context;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import cn.com.ljy.retrofitrxjavademo.R;
import cn.com.ljy.retrofitrxjavademo.entry.BaseResultBean;
import cn.com.ljy.retrofitrxjavademo.model.ProgressResultSubscriber;
import cn.com.ljy.retrofitrxjavademo.mvp.MvpPresenter;
import cn.com.ljy.retrofitrxjavademo.presenter.LoginPresenter;

public class LoginActivity extends BaseActivity {

    @BindView(R.id.edit_username)
    EditText editUsername;
    @BindView(R.id.edit_password)
    EditText editPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;

    private String mUsername;
    private String mPassword;
    private LoginPresenter mLoginPresenter;
    private Context mContext;
    @Override
    public int getContentView() {
        return R.layout.activity_login;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {
        mContext = this;

    }

    @OnClick(R.id.btn_login)
    public void onViewClicked() {
        mUsername = editUsername.getText().toString();
        mPassword = editPassword.getText().toString();
        mLoginPresenter.requestLogin(mUsername, mPassword, new ProgressResultSubscriber.OnResult<BaseResultBean>() {
            @Override
            public void result(BaseResultBean response) {
                Log.d("main","status = " + response.getStatus());
                if(response.getStatus() == ProgressResultSubscriber.RESULT_SUCCESS){
                    WelcomeActivity.startActivity(mContext);
                }
            }

            @Override
            public void onFaild(String faildMsg) {
                Log.d("main", faildMsg);
            }
        });
    }

    @Override
    public void initPresenter(List<MvpPresenter> presenters) {
        mLoginPresenter = new LoginPresenter();
        presenters.add(mLoginPresenter);
    }
}
