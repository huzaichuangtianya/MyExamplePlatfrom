package com.example.quliang.myapplication;

import android.app.Application;
import android.support.multidex.MultiDexApplication;

import com.uuzuche.lib_zxing.activity.ZXingLibrary;

/**
 * Created by quliang on 18-3-21.
 */

public class MyApplication extends MultiDexApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        ZXingLibrary.initDisplayOpinion(this);
    }
}
