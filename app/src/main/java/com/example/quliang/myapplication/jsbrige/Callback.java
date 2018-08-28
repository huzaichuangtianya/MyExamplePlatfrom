package com.example.quliang.myapplication.jsbrige;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.WebView;

import java.lang.ref.WeakReference;

/**
 * Created by quliang on 18-8-21.
 */

public class Callback {

    private static   Handler mHandler                  = new Handler(Looper.getMainLooper());

    private static final String  CALLBACK_JS_FORMAT_JSON   = "javascript:JsBridge.finish('%s', %s);";
    /**
     * String串格式化参数，需要加引号，不然不会调用JSBridge.js中onFinish方法;
     * 原因：JavaScrip参数是String类型时，前后需要加引号
     */
    private static final String  CALLBACK_JS_FORMAT_STRING = "javascript:JsBridge.finish('%s', \"%s\");";
    private String                 mPort;
    private WeakReference<WebView> mWebViewRef;

    public Callback(WebView view, String port) {
        mWebViewRef = new WeakReference<>(view);
        mPort = port;
    }


    public void apply(String jsonObject) {
        String resultStr;
        if (!TextUtils.isEmpty(jsonObject)&&jsonObject.startsWith("{")){//判断是否为JSON，若不是，需要加引号
            resultStr = String.format(CALLBACK_JS_FORMAT_JSON, mPort, jsonObject);
        }else {
            resultStr = String.format(CALLBACK_JS_FORMAT_STRING, mPort, jsonObject);
        }
        final String execJs = resultStr;
        if (mWebViewRef != null && mWebViewRef.get() != null) {
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    mWebViewRef.get().loadUrl(execJs);
                }
            });
        }
    }

}
