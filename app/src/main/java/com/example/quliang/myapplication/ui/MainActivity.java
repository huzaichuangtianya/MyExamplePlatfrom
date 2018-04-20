package com.example.quliang.myapplication.ui;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.quliang.myapplication.R;
import com.example.quliang.myapplication.Util;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       TextView text =findViewById(R.id.text);
        text.setText(Util.getUri);



        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent local = new Intent();
                local.setType("image/*");
                ListView listView=null;


//            local.setAction(Intent.ACTION_PICK/*Intent.ACTION_GET_CONTENT*/);//4.4版本以上用这个
////            startActivityForResult(local, Config.requestCode_4);
//			Intent local = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//			local.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,"image/*");
//			startActivityForResult(local, Config.requestCode_4);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {//4.4及以上
                    local.setAction(Intent.ACTION_OPEN_DOCUMENT);
                } else {//4.4以下
                    local.setAction(Intent.ACTION_GET_CONTENT);
                }
                startActivityForResult(local, 10);
            }
        });
    }
}
