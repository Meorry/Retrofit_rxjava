package cn.com.ljy.retrofitrxjavademo.utils;

import java.math.BigDecimal;

/**
 * Created by shuihan on 2017/3/10.
 */

public class NumberUtils {

    public static boolean isNum(String str) {

        try {
            new BigDecimal(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
