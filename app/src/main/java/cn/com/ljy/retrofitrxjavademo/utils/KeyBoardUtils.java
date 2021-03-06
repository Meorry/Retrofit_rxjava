package cn.com.ljy.retrofitrxjavademo.utils;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * Created by shuihan on 2017/2/10.
 * 键盘工具类
 */
public class KeyBoardUtils {

    /**
     * 隐藏软键盘
     * @param context
     * @param view
     */
    public static void hideKeyBoard(Context context, View view) {
        InputMethodManager imm = (InputMethodManager) context
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0); // 强制隐藏键盘
    }

    /**
     * 显示软键盘
     * @param context
     * @param view
     */
    public static void showKeyBoard(Context context, View view) {
        view.setFocusable(true);
        view.setFocusableInTouchMode(true);
        view.requestFocus();
        view.findFocus();
        InputMethodManager imm = (InputMethodManager) context
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_NOT_ALWAYS);
    }
}
