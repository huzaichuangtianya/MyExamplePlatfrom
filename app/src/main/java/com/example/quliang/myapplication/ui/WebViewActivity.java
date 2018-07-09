package com.example.quliang.myapplication.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import com.example.quliang.myapplication.R;

public class WebViewActivity extends AppCompatActivity {

    WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1);
        webview=findViewById(R.id.webview);
        webview.loadUrl("file:///android_asset/index.html");

    }
}
