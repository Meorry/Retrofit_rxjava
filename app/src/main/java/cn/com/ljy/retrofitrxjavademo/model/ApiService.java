package cn.com.ljy.retrofitrxjavademo.model;

import java.util.Map;

import cn.com.ljy.retrofitrxjavademo.entry.BaseResultBean;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by lijiyuan on 2017/7/20.
 */

public interface ApiService {

    /**
     * 登录接口
     * @param params
     * @return
     */
    @FormUrlEncoded
    @POST("/tv/getChannel")
    Observable<BaseResultBean> postLoginService(@FieldMap Map<String, Object> params);

}
