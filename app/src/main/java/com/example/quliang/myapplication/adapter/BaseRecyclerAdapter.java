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
    protected List<T> dataList=new ArrayList<>();

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public List<T> getDataList(){
        return dataList;
    }

}
