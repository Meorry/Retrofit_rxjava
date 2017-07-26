package cn.com.ljy.retrofitrxjavademo.retrofit;

import com.wou.commonutils.Installation;
import com.wou.commonutils.PackageUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.com.ljy.retrofitrxjavademo.view.UserApplication;

/**
 * Created by shuihan on 2016/12/6.
 * 封装请求参数
 */

public class RequestParam {

    private static final String ANDROID_OS = "android";
    private Map<String, Object> mParams;

    private RequestParam(Builder builder) {
        mParams = builder.params;
    }

    public Map<String, Object> getParams() {
//        JSONObject jsonMap = new JSONObject(mParams);
//        mParams.clear();
//        try {
//            mParams.put("json", Base64.encodeToString(new Des("undercover0601").encrypt(jsonMap.toString().getBytes("utf-8")), 0));
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        return mParams;
    }

    public static class Builder {
        private Map<String, Object> params;

        public Builder() {
            params = new HashMap<>();
        }

        public Builder setParams(Map<String, Object> params) {
            params.putAll(params);
            return this;
        }

        public Builder setParam(String key, String value) {
            if(key == null) return this;
            params.put(key, value);
            return this;
        }

        public Builder setParam(String key, Number value){
            if(key == null) return this;
            params.put(key, value);
            return this;
        }

        public Builder setParam(String key, Object[] value) {
            if(key == null || value == null) return this;
            setParam(key, Arrays.asList(value));
            return this;
        }

        public <E extends Object> Builder setParam(String key, List<E> value) {
            if(key == null || value == null) return this;
            StringBuilder valbuilder = new StringBuilder();
            Iterator<?> iterator = value.iterator();
            while(iterator.hasNext()){
                valbuilder.append(String.valueOf(iterator.next()));
                if(iterator.hasNext()) {
                    valbuilder.append(",");
                }
            }
            params.put(key, valbuilder.toString());
            return this;
        }

        public <E extends Object> Builder setParam(String key, Set<E> value) {
            if(key == null || value == null) return this;
            setParam(key, new ArrayList<>(value));
            return this;
        }

        public RequestParam builder() {
            //一些公共的配置
            params.put("platform", ANDROID_OS);
            params.put("udid", Installation.getID(UserApplication.getContext()));
            params.put("bundleid", PackageUtils.getAppPackageName(UserApplication.getContext()));
            return new RequestParam(this);
        }
    }
}
