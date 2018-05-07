package com.example.quliang.myapplication.ui;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.quliang.myapplication.R;
import com.example.quliang.myapplication.net.DownAndUploadPic;
import com.example.quliang.myapplication.util.FileManager;

import java.io.File;

public class NativeShareActivity extends AppCompatActivity implements View.OnClickListener{
    TextView textView6;
    Button   downloadBtn;
    Button   wchatBtn;
    Button   qqBtn;
    Button   sharedBtn;
    boolean  b;
    Handler handler = new Handler();

    private String fileQPath=FileManager.PATH_TEMP+"shiyan11.png";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_native_share);
        downloadBtn = (Button) findViewById(R.id.downloadBtn);
        sharedBtn = (Button) findViewById(R.id.sharedBtn);
        textView6 = (TextView) findViewById(R.id.textView6);
        wchatBtn = (Button) findViewById(R.id.wchatBtn);
        qqBtn = (Button) findViewById(R.id.qqBtn);

        downloadBtn.setOnClickListener(this);
        sharedBtn.setOnClickListener(this);
        wchatBtn.setOnClickListener(this);
        qqBtn.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.downloadBtn:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
//                            b = DownAndUploadPic.downloadFile("http://10.50.30.189:8080/web1/img/11.PDF", FileManager.PATH_TEMP, "shiyan1.PDF");
                            b = DownAndUploadPic.downloadFile("http://10.50.30.189:8080/web1/img/shiyan1.png", FileManager.PATH_TEMP, "shiyan11.png");

                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    textView6.setText(b ? "下载成功" : "下载失败");
                                    if(b){
                                        shareWeChat(fileQPath);
                                    }
                                }
                            });
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
                break;
            case R.id.sharedBtn:
                shared(fileQPath);
                break;
            case R.id.wchatBtn:
                shareWeChat(fileQPath);
                break;
            case R.id.qqBtn:
                shareQQ(fileQPath);
                break;
        }
    }





    private void shared(String path) {
        Intent share = new Intent(Intent.ACTION_SEND);
        share.putExtra(Intent.EXTRA_STREAM,
                Uri.fromFile(new File(path)));
        share.setType("*/*");//此处可发送多种文件
        startActivity(Intent.createChooser(share, "Share"));
    }


    private void shareWeChat(String path) {
        Uri    uriToImage  = Uri.fromFile(new File(path));
        Intent shareIntent = new Intent();
        //发送图片到朋友圈
        //ComponentName comp = new ComponentName("com.tencent.mm", "com.tencent.mm.ui.tools.ShareToTimeLineUI");
        //发送图片给好友。
        ComponentName comp = new ComponentName("com.tencent.mm", "com.tencent.mm.ui.tools.ShareImgUI");
        shareIntent.setComponent(comp);
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_STREAM, uriToImage);
//        shareIntent.setType("image/jpeg");
        shareIntent.setType("*/*");
        startActivity(Intent.createChooser(shareIntent, "分享图片"));

    }

    private void shareQQ(String path) {
        Uri    uriToImage  = Uri.fromFile(new File(path));
        Intent shareIntent = new Intent();
        //发送图片到朋友圈
        //ComponentName comp = new ComponentName("com.tencent.mm", "com.tencent.mm.ui.tools.ShareToTimeLineUI");
        //发送图片给好友。
        ComponentName comp = new ComponentName("com.tencent.mobileqq", "com.tencent.mobileqq.activity.JumpActivity");
        shareIntent.setComponent(comp);
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_STREAM, uriToImage);
        shareIntent.setType("*/*");
        startActivity(Intent.createChooser(shareIntent, "分享图片"));

    }
}
