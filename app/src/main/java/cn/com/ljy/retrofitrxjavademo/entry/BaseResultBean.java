package cn.com.ljy.retrofitrxjavademo.entry;

import java.io.Serializable;

/**
 * Created by lijiyuan on 2017/7/20.
 * 统一返回结果{"status":1,"message":"success","data":[]}
 */

public class BaseResultBean<T> implements Serializable {
    public int status;
    public String message;
    public T data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
