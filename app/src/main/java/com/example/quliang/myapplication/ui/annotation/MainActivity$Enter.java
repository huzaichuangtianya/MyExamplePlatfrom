package com.example.quliang.myapplication.ui.annotation;

import android.content.Context;
import android.content.Intent;

import com.example.quliang.myapplication.bean.StuBean;

/**
 * Created by quliang on 18-3-21.
 */

public class MainActivity$Enter {
    public void intentTo(Object context,int count,String str,StuBean bean){
      Intent intent=new Intent();
        intent.putExtra("count",count);
        intent.putExtra("str",str);
        intent.putExtra("bean",bean);
        intent.setClass((Context) context,NextActivity.class);
        ( (Context) context).startActivity(intent);
    }
}
