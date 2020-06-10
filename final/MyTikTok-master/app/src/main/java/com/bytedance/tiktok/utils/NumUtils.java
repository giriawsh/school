package com.bytedance.tiktok.utils;

import java.text.DecimalFormat;

//用于点赞数据处理
public class NumUtils {

    public static String numberFilter(int number) {
        if (number > 9999 && number <= 999999) {
            DecimalFormat df2 = new DecimalFormat("##.#");
            String format = df2.format((float)number / 10000);
            return format + "万";
        } else if (number > 999999 && number < 99999999) {
            return number / 10000 + "万";
        } else if (number > 99999999) {
            DecimalFormat df2 = new DecimalFormat("##.#");
            String format = df2.format((float)number / 100000000);
            return format + "亿";
        } else {
            return number + "";
        }
    }
}
