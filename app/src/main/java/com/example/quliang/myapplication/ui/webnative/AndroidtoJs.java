package com.example.quliang.myapplication.ui.webnative;

import android.app.Application;
import android.webkit.JavascriptInterface;

import com.example.quliang.myapplication.util.AppLog;

/**
 * Created by quliang on 18-8-20.
 */

public class AndroidtoJs {

    @JavascriptInterface
    public void hello(String msg) {
        AppLog.D("msg:"+msg);
    }
}
