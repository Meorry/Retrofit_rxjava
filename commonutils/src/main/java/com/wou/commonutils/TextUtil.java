package com.wou.commonutils;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Color;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextUtil {

    public static final String REG_EMAIL = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";


    public static boolean isEmail(String email) {
        Pattern p = Pattern.compile(REG_EMAIL);
        Matcher m = p.matcher(email);
        return m.matches();
    }


    /**
     * 判断是否为null、空字符串或者是"null"
     *
     * @param str
     * @return
     */
    public static boolean isNull(CharSequence... str) {

        for (CharSequence cha : str) {
            if (cha == null || cha.length() == 0 || cha.equals("null")) {
                return true;
            } else {
                return false;
            }
        }

        return true;
    }

    public static void copy(Activity activity, String copyText) {
        ClipboardManager clip = (ClipboardManager)
                activity.getSystemService(Context
                        .CLIPBOARD_SERVICE);
        clip.setPrimaryClip(ClipData.newPlainText
                (null, copyText));
        Toast.makeText(activity, ConstantString.COPY_SUCCESS, Toast.LENGTH_SHORT).show();
    }

    /**
     * 设置textview的字体颜色
     * @param textView
     * @param color
     */
    public static void setTextViewColor(TextView textView, String color){
        if (color != null){
            textView.setTextColor(Color.parseColor("#" + color));
        }
    }
}