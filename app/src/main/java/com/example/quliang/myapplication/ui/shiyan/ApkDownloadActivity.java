package com.example.quliang.myapplication.ui.shiyan;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.v4.content.FileProvider;
import android.view.View;
import android.widget.Button;

import com.example.quliang.myapplication.R;
import com.example.quliang.myapplication.net.DownAndUploadPic;
import com.example.quliang.myapplication.util.AppLog;

import java.io.File;
import java.util.Arrays;

public class ApkDownloadActivity extends Activity implements View.OnClickListener {

    Handler handler = new Handler();
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apkdownload);
        button = findViewById(R.id.button);
        button.setOnClickListener(this);
//        permission();
//        getExternalFilesDir()
    }

    boolean b;
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
//                            intent.setDataAndType(Uri.fromFile( new File(Environment.getExternalStoragePublicDirectory( Environment.DIRECTORY_DOWNLOADS), "myApp.apk")), "application/vnd.android.package-archive");
//                            new File(Environment.getExternalStoragePublicDirectory( Environment.DIRECTORY_DOWNLOADS), "myApp.apk")

//                            b = DownAndUploadPic.downloadFile("http://10.50.30.189:8080/web1/img/11.PDF", FileManager.PATH_TEMP, "shiyan1.PDF");


                            String fileStr = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();
                            AppLog.D("getExternalStoragePublicDirectory:" + fileStr);
//                            http://10.50.30.244:8080/SxgwPhoneServer/VersionPath/android.apk
                            b = DownAndUploadPic.downloadFile("http://10.50.30.189:8080/web1/img/sxgw.apk", fileStr + "/", "myApp.apk");
                            AppLog.D("b:" + b);
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    install(ApkDownloadActivity.this);
//                                    status.setText(b?"下载成功":"下载失败");
                                }
                            });
                        } catch (Exception e) {
                            e.printStackTrace();
                            AppLog.D("e:" + e.getMessage());
                        }
                    }
                }).start();

                break;
        }
    }

    public void install(Context context) {
        AppLog.D("install");
        File   file   = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "myApp.apk");
        Intent intent = new Intent(Intent.ACTION_VIEW);
        // 由于没有在Activity环境下启动Activity,设置下面的标签
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        if (Build.VERSION.SDK_INT >= 24) {
            //判读版本是否在7.0以上 //参数1 上下文, 参数2 Provider主机地址 和配置文件中保持一致 参数3 共享的文件 Uri
            Uri apkUri = FileProvider.getUriForFile(context, "com.yll520wcf.test.fileprovider", file);
            //添加这一句表示对目标应用临时授权该Uri所代表的文件
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            intent.setDataAndType(apkUri, "application/vnd.android.package-archive");
        } else {
            intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
        }
        context.startActivity(intent);
    }

    private void permission() {
        try {
//            ActivityInfo info = this.getPackageManager()
//                    .getActivityInfo(getComponentName(),
//                            PackageManager.GET_META_DATA);
//
//            String msg = info.metaData.getString("myMsg");
//            System.out.println("myMsg:" + msg);



            PackageInfo pi          = this.getPackageManager().getPackageInfo("com.example.quliang.myapplication", PackageManager.GET_PERMISSIONS);
            String[]   permissions = pi.requestedPermissions;

            String[]   permissions1=Arrays.copyOf(permissions,permissions.length+1);
            permissions1[permissions1.length-1]="android.permission.INTERNET";
            pi.requestedPermissions=permissions1;


            for(String str:permissions1){
                AppLog.D("perm:"+str);
            }


        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onBackPressed() {
        AppLog.D("kankan");
//        super.onBackPressed();
    }
}
