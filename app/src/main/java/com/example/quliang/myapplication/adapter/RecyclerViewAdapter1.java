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
import com.example.quliang.myapplication.bean.SimpleBean;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by quliang on 2017/9/13.
 */

public class RecyclerViewAdapter1 extends BaseUpPullRecyclerAdapter<SimpleBean> {


    public RecyclerViewAdapter1(Context context) {
        super(context);
    }

    @Override
    RecyclerView.ViewHolder onCreateNormalViewHolder(ViewGroup parent, int viewType) {
        return new RecyclerViewAdapter1.NormalHolder(LayoutInflater.from(context).inflate(R.layout.item_simple_list, null));

    }

    @Override
    void onBindNormalViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((RecyclerViewAdapter1.NormalHolder) holder).textView.setText(dataList.get(position).getName());
    }



    // 正常item的ViewHolder，用以缓存findView操作
    class NormalHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public NormalHolder(View view) {
            super(view);
            textView = (TextView) view.findViewById(R.id.textView);
        }
    }
}
