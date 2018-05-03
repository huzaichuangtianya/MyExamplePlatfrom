package com.example.quliang.myapplication;

import android.app.Application;
import android.support.multidex.MultiDexApplication;

import com.example.quliang.myapplication.util.FileManager;
import com.uuzuche.lib_zxing.activity.ZXingLibrary;

/**
 * Created by quliang on 18-3-21.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FileManager.createAppDirectory();
        ZXingLibrary.initDisplayOpinion(this);

    }
}
