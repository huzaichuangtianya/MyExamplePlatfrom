package com.example.quliang.myapplication.ui;

import android.os.Build;
import android.os.Environment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.example.quliang.myapplication.R;
import com.example.quliang.myapplication.util.AppLog;

import java.io.File;

public class WebViewActivity extends AppCompatActivity {

    WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1);
        webview=findViewById(R.id.webview);
//        webview.loadUrl("file:///android_asset/index.html");


        WebSettings webSettings =webview.getSettings();
        //允许webview对文件的操作
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            webSettings.setAllowUniversalAccessFromFileURLs(true);
            webSettings.setAllowFileAccessFromFileURLs(true);
        }
        webSettings.setAllowFileAccess(true);
        //用于js调用Android
        webSettings.setJavaScriptEnabled(true);
        //设置编码方式
        webSettings.setDefaultTextEncodingName("utf-8");
        webview.setWebChromeClient(new chromClient());
        //访问Android assets文件夹内的
        String url="file:///android_asset/index.html";
        //访问网页Html
//        String url="http://192.168.1.121:8080/jsandroid/index.html"；
        runWebView(url);
    }


    private class chromClient extends WebChromeClient {
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            if(newProgress==100){
                //页面加载完成执行的操作

                AppLog.D("onProgressChanged");
//                String path= "file://"+ Environment.getExternalStorageDirectory()+ File.separator+"123.jpg";
//getAssets()

//                String action="javascript:aa('"+path+"')";
//                new AlertDialog.Builder(WebViewActivity.this)
//                        .setMessage(action)
//                        .show();
//                runWebView(action);
            }
            super.onProgressChanged(view, newProgress);
        }
    }

    private void runWebView(final String url){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                webview.loadUrl(url);
            }
        });
    }
}
