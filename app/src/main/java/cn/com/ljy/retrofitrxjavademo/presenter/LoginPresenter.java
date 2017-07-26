package cn.com.ljy.retrofitrxjavademo.presenter;

import cn.com.ljy.retrofitrxjavademo.entry.BaseResultBean;
import cn.com.ljy.retrofitrxjavademo.model.ProgressResultSubscriber;
import cn.com.ljy.retrofitrxjavademo.model.ServiceManager;
import cn.com.ljy.retrofitrxjavademo.retrofit.RequestParam;

/**
 * Created by lijiyuan on 2017/7/25.
 */

public class LoginPresenter extends BasePresenter {

    public void requestLogin(String username, String password, ProgressResultSubscriber.OnResult<BaseResultBean> result) {
        RequestParam requestParam = new RequestParam.Builder()
                .setParam("pld", username)
                .setParam("key", "8a7204eb63ba0bab009b338025f42df2")
                .builder();
        ServiceManager.getInstance().callResult(ServiceManager.getInstance().getApiserVice().postLoginService(requestParam.getParams()),
                new ProgressResultSubscriber(result));
    }
}
