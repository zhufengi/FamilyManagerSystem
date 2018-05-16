package com.zf.fms.utils;

/**
 * Created by Administrator on 2018/5/16 0016.
 */
public class Utf8Tool {
    public static String toChinese(String strvalue){
        try {
            if (strvalue==null||strvalue.equals("")) {
                return "";
            } else {
                strvalue = new String(strvalue.getBytes("ISO8859_1"), "UTF-8");
                return strvalue;
            }
        } catch (Exception e) {
            return "";
        }

    }
}
