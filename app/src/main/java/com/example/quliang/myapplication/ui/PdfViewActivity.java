package com.example.quliang.myapplication.ui;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.quliang.myapplication.R;
import com.example.quliang.myapplication.net.DownAndUploadPic;
import com.example.quliang.myapplication.util.FileManager;

public class PdfViewActivity extends AppCompatActivity implements View.OnClickListener{

    Handler handler=new Handler();
    TextView status;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_view);
        TextView startNet=findViewById(R.id.startNet);
         status=findViewById(R.id.status);
        startNet.setOnClickListener(this);
//        getExternalFilesDir()
    }
    boolean b;
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.startNet:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                             b=DownAndUploadPic.downloadFile("http://10.50.30.189:8080/web1/img/11.PDF", FileManager.PATH_TEMP,"shiyan.PDF");

                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    status.setText(b?"下载成功":"下载失败");
                                }
                            });
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }).start();

                break;
        }
    }
}
