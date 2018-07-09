package com.example.quliang.myapplication.ui.recyclerview;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.quliang.myapplication.R;
import com.example.quliang.myapplication.adapter.RecyclerViewSimpleAdapter;
import com.example.quliang.myapplication.bean.SimpleBean;

public class RecyclerViewActivity extends AppCompatActivity implements View.OnClickListener {
    SwipeRefreshLayout        refreshLayout;
    RecyclerViewSimpleAdapter recyclerViewSimpleAdapter;
    AppBarLayout              app_bar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        RecyclerView       recyclerView  = (RecyclerView) findViewById(R.id.recyclerView);
         refreshLayout = (SwipeRefreshLayout) findViewById(R.id.refreshLayout);
        app_bar = (AppBarLayout) findViewById(R.id.app_bar);
//        refreshLayout.setEnabled(false);
//        refreshLayout.setProgressViewOffset(true, -20, 100);
         recyclerViewSimpleAdapter=new RecyclerViewSimpleAdapter();
        for (int i=0;i<20;i++){
            recyclerViewSimpleAdapter.getDataList().add(new SimpleBean("name"+i));
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recyclerViewSimpleAdapter);
        recyclerView.addOnScrollListener(new SwipyAppBarScrollListener(app_bar, refreshLayout, recyclerView));


        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

//                for (int i=0;i<10;i++){
//                    recyclerViewSimpleAdapter.getDataList().add(new SimpleBean("name"+i));
//                }
//                recyclerViewSimpleAdapter.notifyDataSetChanged();
                refreshLayout.setRefreshing(false);
            }
        });
    }


    @Override
    public void onClick(View v) {

    }
}
