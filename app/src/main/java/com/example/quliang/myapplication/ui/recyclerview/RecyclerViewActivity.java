package com.example.quliang.myapplication.ui.recyclerview;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.design.widget.AppBarLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.quliang.myapplication.R;
import com.example.quliang.myapplication.adapter.RecyclerViewAdapter;
import com.example.quliang.myapplication.adapter.RecyclerViewAdapter1;
import com.example.quliang.myapplication.bean.SimpleBean;
import com.example.quliang.myapplication.logic.RecyclerViewUpPullScrollLogic;
import com.example.quliang.myapplication.util.AppLog;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity implements View.OnClickListener {
    SwipeRefreshLayout  refreshLayout;
    RecyclerViewAdapter1 recyclerViewSimpleAdapter;
    AppBarLayout        app_bar;
    LinearLayoutManager linearLayoutManager;
    RecyclerViewUpPullScrollLogic recyclerViewUpPullScrollLogic;

    private Handler mHandler = new Handler(Looper.getMainLooper()); //获取主线程的Handler
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        RecyclerView       recyclerView  = (RecyclerView) findViewById(R.id.recyclerView);
         refreshLayout = (SwipeRefreshLayout) findViewById(R.id.refreshLayout);
        app_bar = (AppBarLayout) findViewById(R.id.app_bar);
//        refreshLayout.setEnabled(false);
//        refreshLayout.setProgressViewOffset(true, -20, 100);


         recyclerViewSimpleAdapter=new RecyclerViewAdapter1(this);
        for (int i=0;i<20;i++){
            recyclerViewSimpleAdapter.getDataList().add(new SimpleBean("name"+i));
        }

         linearLayoutManager= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(recyclerViewSimpleAdapter);

        SwipyAppBarScrollListener swipyAppBarScrollListener=new SwipyAppBarScrollListener(app_bar, refreshLayout, recyclerView);
         recyclerViewUpPullScrollLogic=new RecyclerViewUpPullScrollLogic(recyclerViewSimpleAdapter);
        recyclerViewUpPullScrollLogic.setPullListener(new RecyclerViewUpPullScrollLogic.PullListener() {
            @Override
            public void onUpPull() {
                updateRecyclerView();
            }
        });

        swipyAppBarScrollListener.setOnShiyanLisener(new SwipyAppBarScrollListener.ShiyanLisener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                recyclerViewUpPullScrollLogic.onScrollStateChanged(recyclerView,newState);
                // 在newState为滑到底部时
//                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
//                    // 如果没有隐藏footView，那么最后一个条目的位置就比我们的getItemCount少1，自己可以算一下
//                    if (recyclerViewSimpleAdapter.isFadeTips() == false && recyclerViewUpPullScrollLogic.getLastVisibleItem() + 1 == recyclerViewSimpleAdapter.getItemCount()) {
//                        mHandler.postDelayed(new Runnable() {
//                            @Override
//                            public void run() {
//                                // 然后调用updateRecyclerview方法更新RecyclerView
//                                updateRecyclerView();
//                            }
//                        }, 500);
//                    }
//
//                    // 如果隐藏了提示条，我们又上拉加载时，那么最后一个条目就要比getItemCount要少2
//                    if (recyclerViewSimpleAdapter.isFadeTips() == true && recyclerViewUpPullScrollLogic.getLastVisibleItem() + 2 == recyclerViewSimpleAdapter.getItemCount()) {
//                        mHandler.postDelayed(new Runnable() {
//                            @Override
//                            public void run() {
//                                // 然后调用updateRecyclerview方法更新RecyclerView
//                                updateRecyclerView();
//                            }
//                        }, 500);
//                    }
//                    }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                recyclerViewUpPullScrollLogic.onScrolled(recyclerView,dx,dy);
            }
        });
        recyclerView.addOnScrollListener(swipyAppBarScrollListener);


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

int a=0;
    // 上拉加载时调用的更新RecyclerView的方法
    private void updateRecyclerView() {
        AppLog.D("updateRecyclerView");
        // 获取从fromIndex到toIndex的数据
//        List<SimpleBean> newDatas = getDatas(fromIndex, toIndex);
        List<SimpleBean> newDatas = new ArrayList<SimpleBean>();
        for (int i=0;i<10;i++){
            newDatas.add(new SimpleBean("name"+Math.random()));
        }

        if (newDatas.size() > 0&&a<2) {
            // 然后传给Adapter，并设置hasMore为true
            recyclerViewSimpleAdapter.updateList(newDatas, true);
        } else {
            recyclerViewSimpleAdapter.updateList(null, false);
        }
        a++;
    }


    @Override
    public void onClick(View v) {

    }
}
