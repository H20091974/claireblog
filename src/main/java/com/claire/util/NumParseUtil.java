package com.claire.util;

/**
 * Created by hzn on 2018/1/20.
 */
public class NumParseUtil {

    public static int parseInt(String str,int defaultvalue){
        try {
            return Integer.parseInt(str);
        }catch (Exception e){
            return defaultvalue;
        }
    }
}
