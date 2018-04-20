package com.example.quliang.myapplication.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by quliang on 2017/9/13.
 */

public abstract class QBaseAdapter<T> extends BaseAdapter {
    private List<T> dataList = new ArrayList<T>();
    public    LayoutInflater mLayoutInflater;
    protected Activity       context;

    public QBaseAdapter(Activity context) {
        this.context = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public T getItem(int i) {
        if (getCount() <= 0 || i >= getCount())
            return null;
        return dataList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return getDefineView(i, view, viewGroup);
    }

    public abstract View getDefineView(int i, View view, ViewGroup viewGroup);

}