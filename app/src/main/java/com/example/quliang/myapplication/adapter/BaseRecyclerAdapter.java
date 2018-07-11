package com.example.quliang.myapplication.adapter;

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

public  abstract class BaseRecyclerAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    protected List<T> dataList=new ArrayList<>();

    public List<T> getDataList(){
        return dataList;
    }


//    @Override
//    public int getItemCount() {
//        return simpleBeans.size();
//    }
//
//    private List<SimpleBean> simpleBeans=new ArrayList<>();
//
//    public List<SimpleBean> getDataList(){
//        return simpleBeans;
//    }

//    @Override
//    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View       view   = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_simple_list, parent, false);
//        ViewHolder holder = new ViewHolder(view);
//        return holder;
//    }
//
//
//    @Override
//    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
//        SimpleBean book = simpleBeans.get(position);
//        ((BaseRecyclerAdapter.ViewHolder)holder).textView.setText(book.getName());
//    }
//
//
//
//     class ViewHolder extends RecyclerView.ViewHolder {
//        TextView textView;
//
//        public ViewHolder(View view) {
//            super(view);
//            textView = (TextView) view.findViewById(R.id.textView);
//        }
//    }



}
