package com.ljming.http;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Title:URL
 * <p>
 * Description:所有地址常量均继承此类
 * </p>
 * Author Jming.L
 * Date 2018/6/1 14:04
 */
public class URL {

    private static final String URL_HOST = URL.class.getName() + "HOST";
    private static final String URL_IMAGE = URL.class.getName() + "IMAGE";

    protected URL() {
    }

    private static SharedPreferences getShared(Context context) {
        return context.getSharedPreferences(URL.class.getName(), Context.MODE_PRIVATE);
    }

    private static SharedPreferences.Editor getEditor(Context context) {
        return getShared(context).edit();
    }


    public static void setHost(Context context, String host) {
        SharedPreferences.Editor editor = getEditor(context);
        editor.putString(URL_HOST, host);
        editor.apply();
    }

    public static String getHost(Context context) {
        return getShared(context).getString(URL_HOST, null);
    }

    public static String getImage(Context context) {
        return getShared(context).getString(URL_IMAGE, null);
    }

    public static void setImage(Context context, String image) {
        SharedPreferences.Editor editor = getEditor(context);
        editor.putString(URL_IMAGE, image);
        editor.apply();
    }

    public static void setValue(Context context, String key, String value) {
        SharedPreferences.Editor editor = getEditor(context);
        editor.putString(key, value);
        editor.apply();
    }

    public static String getValue(Context context, String key) {
        return getShared(context).getString(key, null);
    }

    public static String url(Context context, String path) {
        return getHost(context) + path;
    }

    public static String image(Context context, String path) {
        return getImage(context) + path;
    }

    public static String value(Context context, String key, String path) {
        return getValue(context, key) + (path == null ? "" : path);
    }

}
