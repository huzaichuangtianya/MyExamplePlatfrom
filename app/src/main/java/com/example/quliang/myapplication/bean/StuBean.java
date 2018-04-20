package com.example.quliang.myapplication.bean;

import java.io.Serializable;

/**
 * Created by quliang on 18-3-21.
 */

public class StuBean implements Serializable{


    public StuBean(int id , String name) {
        this.id = id;
        this.name = name;
    }

    //学号
    public int id;

    //姓名
    public String name;
}
