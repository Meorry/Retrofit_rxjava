package cn.com.ljy.retrofitrxjavademo.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by shuihan on 2016/12/9.
 * 验证工具类
 */

public class VerifyUtil {

    /**
     * 判断是否是手机号
     * @param str
     * @return
     */
    public static boolean isPhoneNum(String str){
        Pattern p = Pattern.compile("^[1][0-9]{10}$"); // 验证手机号
        Matcher m = p.matcher(str);
        return m.matches();
    }

    /**
     * 获取字符串的长度，如果有中文，则每个中文字符计为2位
     *
     * @param validateStr
     *            指定的字符串
     * @return 字符串的长度
     */
    public static int getChineseLength(String validateStr) {
        int valueLength = 0;
        String chinese = "[\u0391-\uFFE5]";
        /* 获取字段值的长度，如果含中文字符，则每个中文字符长度为2，否则为1 */
        for (int i = 0; i < validateStr.length(); i++) {
            /* 获取一个字符 */
            String temp = validateStr.substring(i, i + 1);
            /* 判断是否为中文字符 */
            if (temp.matches(chinese)) {
                /* 中文字符长度为2 */
                valueLength += 2;
            } else {
                /* 其他字符长度为1 */
                valueLength += 1;
            }
        }
        return valueLength;
    }
}
