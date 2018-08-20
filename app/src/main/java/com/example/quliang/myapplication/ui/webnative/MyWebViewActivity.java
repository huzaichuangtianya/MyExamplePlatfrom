package com.example.quliang.myapplication.ui.webnative;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.quliang.myapplication.R;

public class MyWebViewActivity extends AppCompatActivity implements View.OnClickListener {

//    private WebView webView;
//    private Button  button1;
//    private Button  button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

//        webView = (WebView) findViewById(R.id.webview);
//        button1 = (Button) findViewById(R.id.button1);
//        button2 = (Button) findViewById(R.id.button2);
//        button1.setOnClickListener(this);
//        button2.setOnClickListener(this);
//        initWebView();
//        webView.loadUrl("file:///android_asset/web/index.html");
    }

//    private void initWebView() {
//        WebSettings settings = webView.getSettings();
//        settings.setJavaScriptEnabled(true);
//    }
//
//
    @Override
    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.button1:
//                webView.loadUrl("JavaScript:callJs()");
//                break;
//            case R.id.button2:
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//                    webView.evaluateJavascript("callJsValue()", new ValueCallback<String>() {
//                        @Override
//                        public void onReceiveValue(String value) {
//                            AppLog.D("value:" + value);
//                        }
//                    });
//                }
//                break;
//        }
    }
}
