package com.example.quliang.myapplication.ui;

import android.app.Instrumentation;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.example.quliang.myapplication.R;
import com.example.quliang.myapplication.adapter.RecyclerViewSimpleAdapter;
import com.example.quliang.myapplication.bean.SimpleBean;

public class Main8Activity extends AppCompatActivity implements View.OnClickListener {

    RecyclerView recyclerView;
    TextView     xf;
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
        setContentView(R.layout.activity_main8);
         recyclerView   = (RecyclerView) findViewById(R.id.recyclerView);
         xf   = (TextView) findViewById(R.id.xf);

        RecyclerViewSimpleAdapter recyclerViewSimpleAdapter=new RecyclerViewSimpleAdapter();
        for (int i=0;i<30;i++){
            recyclerViewSimpleAdapter.getDataList().add(new SimpleBean("name"+i));
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recyclerViewSimpleAdapter);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                MotionEvent evenDownt = MotionEvent.obtain(System.currentTimeMillis(),
                        System.currentTimeMillis() + 100, MotionEvent.ACTION_DOWN, x, y, 0);
                dispatchTouchEvent(evenDownt);

                MotionEvent eventMv1 = MotionEvent.obtain(System.currentTimeMillis(),
                        System.currentTimeMillis() + 100, MotionEvent.ACTION_MOVE, x, y-100, 0);
                dispatchTouchEvent(eventMv1);

                MotionEvent eventUp = MotionEvent.obtain(System.currentTimeMillis(),
                        System.currentTimeMillis() + 100, MotionEvent.ACTION_UP, x, y, 0);
                dispatchTouchEvent(eventUp);

                evenDownt.recycle();
                eventMv1.recycle();
                eventUp.recycle();

            }
        },3000);
    }

int x=10,y=1721;
    @Override
    public void onClick(View v) {

    }
}
