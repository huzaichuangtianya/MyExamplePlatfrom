package com.example.quliang.myapplication.ui.sheetstyle;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.quliang.myapplication.R;
import com.example.quliang.myapplication.ui.dialog.BottomSheetDialog1;
import com.example.quliang.myapplication.ui.dialog.BottomSheetDialog2;

public class BottomSheetActivity extends AppCompatActivity implements View.OnClickListener {

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:

                    Toast.makeText(BottomSheetActivity.this, (String) msg.obj, Toast.LENGTH_LONG).show();
                    break;
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                showBottomSheet2();
                showBottomSheet1();
            }
        });

    }

    BottomSheetDialog1 mBottomSheetDialog1;

    private void showBottomSheet1() {
        if (mBottomSheetDialog1 == null) {
            mBottomSheetDialog1 = new BottomSheetDialog1();
        }
        mBottomSheetDialog1.show(getSupportFragmentManager(), "mBottomSheetDialog1");
    }

    BottomSheetDialog2 mBottomSheetDialog2;

    private void showBottomSheet2() {
        if (mBottomSheetDialog2 == null) {
            mBottomSheetDialog2 = new BottomSheetDialog2();
        }
        mBottomSheetDialog2.show(getSupportFragmentManager(), "mBottomSheetDialog2");
    }


    @Override
    public void onClick(View v) {

    }
}
