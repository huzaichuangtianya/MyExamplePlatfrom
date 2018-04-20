package com.example.quliang.myapplication.adapter;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.quliang.myapplication.R;
import com.example.quliang.myapplication.bean.SimpleBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by quliang on 18-4-20.
 */

public abstract class BaseRecyclerAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private ArrayList<T> dataList = new ArrayList<T>();

    public List<T> getDataList() {
        return dataList;
    }


    @Override
    public int getItemCount() {
        return dataList.size();
    }


//    public BaseRecyclerAdapter() {
//    }
//
//    @Override
//    public RecyclerViewSimpleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View                                 view   = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_simple_list, parent, false);
//        RecyclerViewSimpleAdapter.ViewHolder holder = new RecyclerViewSimpleAdapter.ViewHolder(view);
//        return holder;
//    }
//
//    @Override
//    public void onBindViewHolder(RecyclerViewSimpleAdapter.ViewHolder holder, int position) {
//        SimpleBean book = simpleBeans.get(position);
//        holder.textView.setText(book.getName());
//    }
//
//    @Override
//    public int getItemCount() {
//        return simpleBeans.size();
//    }
//
//    private List<SimpleBean> simpleBeans=new ArrayList<SimpleBean>();
//
//    static class ViewHolder extends RecyclerView.ViewHolder {
//        TextView textView;
//
//        public ViewHolder(View view) {
//            super(view);
//            textView = (TextView) view.findViewById(R.id.textView);
//        }
//    }
//
//    public List<SimpleBean> getDataList(){
//        return simpleBeans;
//    }



}
