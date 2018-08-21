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

        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public boolean onJsAlert(WebView view, String url, String message,
                                     JsResult result) {
                AppLog.D("url:" + url);
                AppLog.D("message:" + message);
                // TODO Auto-generated method stub
                return super.onJsAlert(view, url, message, result);
            }

            @Override
            public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult result) {

                Uri uri = Uri.parse(message);
                if (uri.getScheme().equals("js") && uri.getAuthority().equals("demo")) {
                    getUriData(uri);
                    result.confirm("js调用了Android的方法成功啦");
                    return true;
                }
                return super.onJsPrompt(view, url, message, defaultValue, result);
            }
        });

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }

            @TargetApi(Build.VERSION_CODES.N)
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {

                Uri uri = request.getUrl();

                if (uri.getScheme().equals("js") && uri.getAuthority().equals("webview")) {
                    getUriData(uri);
                    return true;
                }
                return super.shouldOverrideUrlLoading(view, request);
            }

            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                Uri uri = Uri.parse(url);
                if (uri.getScheme().equals("js") && uri.getAuthority().equals("webview")) {
                    getUriData(uri);
                    return true;
                }

                return false;
            }
        });

        webView.addJavascriptInterface(new AndroidtoJs(), "test");
    }


    private void getUriData(Uri uri) {
        AppLog.D("uri.getQueryParameterNames():" + uri.getQueryParameterNames());

        Set<String> set = uri.getQueryParameterNames();

        for (String s : set) {
            AppLog.D("uri.getQueryParameterNames()1:" + s);
            AppLog.D("uri.getQueryParameter()()1:" + uri.getQueryParameter(s));
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
        }
    }
}
