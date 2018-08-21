package com.example.quliang.myapplication.ui.webnative;

import android.annotation.TargetApi;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import com.example.quliang.myapplication.R;
import com.example.quliang.myapplication.util.AppLog;

import java.util.Set;

public class MyWebViewBridgeActivity extends AppCompatActivity implements View.OnClickListener {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myweb_bridge);

        webView = (WebView) findViewById(R.id.webview);
        initWebView();
        webView.loadUrl("file:///android_asset/web/index.html");
    }

    private void initWebView() {
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setDomStorageEnabled(true);

        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }
        });



    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
        }
    }
}
