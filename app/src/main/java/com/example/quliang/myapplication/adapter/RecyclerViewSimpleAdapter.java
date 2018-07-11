package com.example.quliang.myapplication.adapter;

import android.app.Activity;
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

public class RecyclerViewSimpleAdapter extends BaseRecyclerAdapter<SimpleBean> {
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_simple_list, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        SimpleBean book = dataList.get(position);
        ((ViewHolder)holder).textView.setText(book.getName());
    }

     class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public ViewHolder(View view) {
            super(view);
            textView = (TextView) view.findViewById(R.id.textView);
        }
    }



//public class RecyclerViewSimpleAdapter extends RecyclerView.Adapter<RecyclerViewSimpleAdapter.ViewHolder> {


//    @Override
//    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View       view   = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_simple_list, parent, false);
//        ViewHolder holder = new ViewHolder(view);
//        return holder;
//    }
//
//    @Override
//    public void onBindViewHolder(ViewHolder holder, int position) {
//        SimpleBean book = simpleBeans.get(position);
//        holder.textView.setText(book.getName());
//    }
//
//    @Override
//    public int getItemCount() {
//        return simpleBeans.size();
//    }
//
//    private List<SimpleBean> simpleBeans=new ArrayList<>();
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
