package com.example.quliang.myapplication.adapter;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.quliang.myapplication.R;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by quliang on 2017/9/13.
 */

public abstract   class BaseUpPullRecyclerAdapter<T>  extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    @Override
    public int getItemCount() {
        return dataList.size()+1;
    }

    protected List<T> dataList=new ArrayList<>();

    public List<T> getDataList(){
        return dataList;
    }


    private int normalType = 0;     // 第一种ViewType，正常的item
    private int footType = 1;       // 第二种ViewType，底部的提示View

    private boolean hasMore = true;   // 变量，是否有更多数据
    private boolean fadeTips = false; // 变量，是否隐藏了底部的提示

    private Handler mHandler = new Handler(Looper.getMainLooper()); //获取主线程的Handler

    protected Context context;
    public BaseUpPullRecyclerAdapter(Context context){
        this.context=context;
    }

    public int getRealLastPosition() {
        return dataList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == getItemCount() - 1) {
            return footType;
        } else {
            return normalType;
        }
    }

    public boolean isFadeTips() {
        return fadeTips;
    }



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == normalType) {
            return onCreateNormalViewHolder(parent,viewType);
        } else {
            return new FootHolder(LayoutInflater.from(context).inflate(R.layout.layout_recyclerview_foot, null));
        }
    }

    abstract   RecyclerView.ViewHolder onCreateNormalViewHolder(ViewGroup parent, int viewType);


    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
//        SimpleBean book = simpleBeans.get(position);
//        holder.textView.setText(book.getName());

        if (holder instanceof BaseUpPullRecyclerAdapter.FootHolder) {
            // 之所以要设置可见，是因为我在没有更多数据时会隐藏了这个footView
            ((BaseUpPullRecyclerAdapter.FootHolder) holder).tips.setVisibility(View.VISIBLE);
            // 只有获取数据为空时，hasMore为false，所以当我们拉到底部时基本都会首先显示“正在加载更多...”
            if (hasMore == true) {
                // 不隐藏footView提示
                fadeTips = false;
                if (dataList.size() > 0) {
                    // 如果查询数据发现增加之后，就显示正在加载更多
                    ((BaseUpPullRecyclerAdapter.FootHolder) holder).tips.setText("正在加载更多...");
                }
            } else {
                if (dataList.size() > 0) {
                    // 如果查询数据发现并没有增加时，就显示没有更多数据了
                    ((BaseUpPullRecyclerAdapter.FootHolder) holder).tips.setText("没有更多数据了");

                    // 然后通过延时加载模拟网络请求的时间，在500ms后执行
                    mHandler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            // 隐藏提示条
                            ((BaseUpPullRecyclerAdapter.FootHolder) holder).tips.setVisibility(View.GONE);
                            // 将fadeTips设置true
                            fadeTips = true;
                            // hasMore设为true是为了让再次拉到底时，会先显示正在加载更多
                            hasMore = true;
                        }
                    }, 500);
                }
            }
        }else{
            onBindNormalViewHolder(holder,position);
        }

    }

    abstract void onBindNormalViewHolder(RecyclerView.ViewHolder holder, int position);

    public void updateList(List<T> newDatas, boolean hasMore) {
        // 在原有的数据之上增加新数据
        if (newDatas != null) {
            dataList.addAll(newDatas);

        }
        this.hasMore = hasMore;
        notifyDataSetChanged();
    }

    public class FootHolder extends RecyclerView.ViewHolder {
        public TextView tips;

        public FootHolder(View itemView) {
            super(itemView);
            tips = (TextView) itemView.findViewById(R.id.foot);
        }
    }


}
