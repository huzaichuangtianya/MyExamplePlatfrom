package com.example.quliang.myapplication.jsbrige;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.webkit.WebView;

import com.example.quliang.myapplication.util.AppLog;

/**
 * Created by quliang on 18-8-21.
 */

public class BridgeImpl implements IBridge {


    public static void fromJsFunction_init(WebView webView, String param, final Callback callback) {
        AppLog.D("fromJsFunction_init:"+param);
        callback.apply("backresult");
    }
}
