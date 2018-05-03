package com.example.quliang.myapplication.util;

import android.os.Environment;

/**
 * Created by quliang on 2017/9/18.
 */

public class FileManager {

    /**
     * 作用: SD卡根目录
     */
    public static final String PATH = Environment.getExternalStorageDirectory()
            .getPath();

    /**
     * 作用: 数据文件夹
     */
    public static final String PATH_ROOT     = PATH + "/quliang1/";
    /**
     * 作用: 异步加载网络图片缓存文件夹
     */
    public final static String PATH_CACHEIMG = PATH_ROOT + "cacheImg/";
    /**
     * 图像临时名称 ,修改完图像立即删除
     */
    public final static String PATH_TEMP     = PATH_ROOT + "temp/";




    public static void createAppDirectory() {
        AppLog.D("createAppDirectory1");
        AppLog.D("Environment.getExternalStorageState():"+Environment.getExternalStorageState());
        AppLog.D("Environment.Environment.MEDIA_MOUNTED():"+Environment.MEDIA_MOUNTED);

//        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {}
            QLFileUtil.createDir(PATH_ROOT);
//            QLFileUtil.createDir(PATH_CACHEIMG);
            QLFileUtil.createDir(PATH_TEMP);
//            QLFileUtil.createDir(PATH_APK_DIR);
            AppLog.D("createAppDirectory2");
            AppLog.D("PATH_TEMP:"+PATH_TEMP);

    }


    /**
     * 集团分户电子账单下载文件后缀
     */
    public final static String FILE_TYPE_PNG =".png";
//    /**
//     * 二维码发票打印PDF文件下载
//     */
//    public final static String FILE_TYPE_PDF=".PDF";
}
