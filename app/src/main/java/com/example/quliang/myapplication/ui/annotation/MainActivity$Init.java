package com.example.quliang.myapplication.ui.annotation;

import android.content.Context;
import android.content.Intent;

import com.example.quliang.myapplication.bean.StuBean;

/**
 * Created by quliang on 18-3-21.
 */

public class MainActivity$Init {

    public int     count;
    public String  str;
    public StuBean bean;


    public Object initFields(Object currentActivity, int defaultcount) {

        NextActivity nextActivity = (NextActivity) currentActivity;
        Intent       intent       = nextActivity.getIntent();
        this.count = intent.getIntExtra("count", defaultcount);
        this.str = intent.getStringExtra("str");
        this.bean = (StuBean) intent.getSerializableExtra("bean");

        return this;

    }
}
