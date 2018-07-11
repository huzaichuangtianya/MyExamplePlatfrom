package com.example.quliang.myapplication.logic;

import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.quliang.myapplication.adapter.BaseUpPullRecyclerAdapter;

/**
 * Created by quliang on 18-7-10.
 */

public class RecyclerViewUpPullScrollLogic {

    private final int PAGE_COUNT = 10;
    private int                       lastVisibleItem;
    private BaseUpPullRecyclerAdapter baseUpPullRecyclerAdapter;

    private Handler mHandler = new Handler(Looper.getMainLooper()); //获取主线程的Handler

    public RecyclerViewUpPullScrollLogic(BaseUpPullRecyclerAdapter baseUpPullRecyclerAdapter) {
        this.baseUpPullRecyclerAdapter=baseUpPullRecyclerAdapter;
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int newState){
        if (newState == RecyclerView.SCROLL_STATE_IDLE) {
            // 如果没有隐藏footView，那么最后一个条目的位置就比我们的getItemCount少1，自己可以算一下
            if (baseUpPullRecyclerAdapter.isFadeTips() == false && lastVisibleItem + 1 == baseUpPullRecyclerAdapter.getItemCount()) {
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // 然后调用updateRecyclerview方法更新RecyclerView
                        if(pullListener!=null)pullListener.onUpPull();
//                        updateRecyclerView(baseUpPullRecyclerAdapter.getRealLastPosition(), baseUpPullRecyclerAdapter.getRealLastPosition() + PAGE_COUNT);
                    }
                }, 500);
            }else

            // 如果隐藏了提示条，我们又上拉加载时，那么最后一个条目就要比getItemCount要少2
            if (baseUpPullRecyclerAdapter.isFadeTips() == true && lastVisibleItem + 2 == baseUpPullRecyclerAdapter.getItemCount()) {
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // 然后调用updateRecyclerview方法更新RecyclerView
                        if(pullListener!=null)pullListener.onUpPull();
//                        updateRecyclerView(baseUpPullRecyclerAdapter.getRealLastPosition(), baseUpPullRecyclerAdapter.getRealLastPosition() + PAGE_COUNT);
                    }
                }, 500);
            }
        }
    }

    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        lastVisibleItem=((LinearLayoutManager)recyclerView.getLayoutManager()).findLastVisibleItemPosition();
    }


    public int getLastVisibleItem() {
        return lastVisibleItem;
    }

    public void setLastVisibleItem(int lastVisibleItem) {
        this.lastVisibleItem = lastVisibleItem;
    }

    private PullListener pullListener;
    public   void setPullListener(PullListener pullListener){
           this.pullListener=pullListener;
    }

    public interface PullListener{
       void onUpPull();
    }


    public int getPAGE_COUNT() {
        return PAGE_COUNT;
    }
}
