package com.example.quliang.myapplication;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebView;
import android.widget.ImageView;

import com.example.quliang.myapplication.runtimeann.AnnotationUtils;
import com.example.quliang.myapplication.runtimeann.CalcuRuningtime;
import com.example.quliang.myapplication.util.QCodeCreate;
import com.uuzuche.lib_zxing.activity.CodeUtils;
import com.uuzuche.lib_zxing.activity.ZXingLibrary;

public class Test2Activity extends AppCompatActivity {

    ImageView iv_barcode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);
        iv_barcode=findViewById(R.id.iv_barcode);
//        QCodeCreate qCodeCreate =new QCodeCreate();

//        Bitmap bitmap =qCodeCreate.createQRImage(800,800,"KANKAN");
//        Bitmap bitmap = CodeUtils.createImage( "KANKAN", 800, 800, null);
//        Log.d("Test2Activity","bitmap:"+bitmap);
//        if (bitmap != null && !bitmap.isRecycled()) {
//            iv_barcode.setImageBitmap(bitmap);
//        }
//        Log.i("Tag","进来了1");
//        AnnotationUtils.getClassInfo("com.example.quliang.myapplication.Test2Activity");
//        method1();
    }

    @CalcuRuningtime(methodName = "method1")
    public void method1(){
        long a=1000000l;
        while (a>0){
            a--;
        }
    }


}
