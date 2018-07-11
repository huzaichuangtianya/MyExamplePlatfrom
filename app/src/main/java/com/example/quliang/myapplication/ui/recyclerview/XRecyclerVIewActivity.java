package com.example.quliang.myapplication.ui.recyclerview;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.quliang.myapplication.R;
import com.example.quliang.myapplication.adapter.RecyclerViewSimpleAdapter;
import com.example.quliang.myapplication.bean.SimpleBean;
import com.example.quliang.myapplication.util.AppLog;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

public class XRecyclerVIewActivity extends AppCompatActivity implements View.OnClickListener {
Handler handler=new Handler();
    RecyclerViewSimpleAdapter recyclerViewSimpleAdapter;
    XRecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xrecyclerview);
         recyclerView = (XRecyclerView) findViewById(R.id.recyclerView);

         recyclerViewSimpleAdapter = new RecyclerViewSimpleAdapter();

//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        AppLog.D("recyclerView:"+recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recyclerViewSimpleAdapter);
        recyclerView.setArrowImageView(R.mipmap.down_arrows_2);
        getData(20);

        recyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        recyclerViewSimpleAdapter.getDataList().clear();
                        getData(10);
                        recyclerView.refreshComplete();
                    }
                },1000);
            }

            @Override
            public void onLoadMore() {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        getData(10);
                        recyclerView.refreshComplete();
                    }
                },1000);
            }


        });
    }


    private void getData(int a){
        for (int i = 0; i < a; i++) {
            recyclerViewSimpleAdapter.getDataList().add(new SimpleBean("name" + Math.random()));
        }
        recyclerViewSimpleAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {

    }
}
