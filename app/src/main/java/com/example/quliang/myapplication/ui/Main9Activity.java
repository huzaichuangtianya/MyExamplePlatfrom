package com.example.quliang.myapplication.ui;

import android.app.Instrumentation;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quliang.myapplication.R;
import com.example.quliang.myapplication.adapter.RecyclerViewSimpleAdapter;
import com.example.quliang.myapplication.bean.SimpleBean;

public class Main9Activity extends AppCompatActivity implements View.OnClickListener {
final static String TAG=Main9Activity.class.getSimpleName();
    TextView     text;
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 1:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);

        text   = (TextView) findViewById(R.id.text);

        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Main9Activity.this,"kankan",Toast.LENGTH_LONG).show();
            }
        });

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

            }
        },3000);
    }

    private int x,y=1721;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(TAG,"x:"+event.getX());
        Log.d(TAG,"y:"+event.getY());
        return super.onTouchEvent(event);
    }

    @Override
    public void onClick(View v) {

    }
}
