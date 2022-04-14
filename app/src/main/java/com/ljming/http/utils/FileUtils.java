package com.ljming.http.utils;

import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;

import java.io.File;

public class FileUtils {

    /**
     * 获取内存卡下存储路径/mnt/sdcard/
     * 6.0以后需要动态申请权限
     */
    public static String getDirectoryPath(String dirName) {
        String root = Environment.getExternalStorageDirectory()
                .getAbsolutePath();
        String path = root + "/";
        if (!TextUtils.isEmpty(dirName)) {
            path = path + "/" + dirName + "/";
        }

        File dir = new File(path);
        if (!dir.exists() && !dir.mkdirs()) {
            Log.e(FileUtils.class.getSimpleName(), "can't make dirs in " + dir.getAbsolutePath());
        }
        return path;
    }

}
