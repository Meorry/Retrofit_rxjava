package cn.com.ljy.retrofitrxjavademo.utils;

import android.widget.Toast;

import com.wou.commonutils.StringUtils;

import cn.com.ljy.retrofitrxjavademo.view.UserApplication;

/**
 * Created by shuihan on 2016/12/7.
 */

public class ToastUtil {

    /**
     * 显示一个toast到界面上
     * @param message
     */
    public static void showToast(String message){
        if(StringUtils.isEmpty(message)) return;
        Toast.makeText(UserApplication.getContext(), message, Toast.LENGTH_SHORT).show();
    }
}
