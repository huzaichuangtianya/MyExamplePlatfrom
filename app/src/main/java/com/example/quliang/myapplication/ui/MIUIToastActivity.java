package com.example.quliang.myapplication.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quliang.myapplication.R;

public class MIUIToastActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_miuitoast);
        Button button=findViewById(R.id.button);
        Button button1=findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tosi();
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MIUIToastActivity.this,"nidajihao你号发撒发撒发射的",Toast.LENGTH_LONG).show();
            }
        });
    }

    private void tosi(){
        Toast    mToast   = new Toast(this);
        View     view     = LayoutInflater.from(this).inflate(R.layout.view_miuitoast, null, false);
        TextView textView = view.findViewById(R.id.text);
        textView.setText("nidajihao你号发撒发撒发射的");
        mToast.setView(view);
        mToast.setDuration(Toast.LENGTH_LONG);
        mToast.setGravity(Gravity.CENTER, 0, 0);
        mToast.show();
    }


}
