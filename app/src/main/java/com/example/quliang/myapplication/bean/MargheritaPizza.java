package com.example.quliang.myapplication.bean;

import com.quliang.myannotation.Factory;

/**
 * Created by quliang on 18-3-22.
 */

//@Factory(id="MargheritaPizza",type =Meal.class )
public class MargheritaPizza implements Meal {
    @Override
    public float getPrice() {
        return 10f;
    }
}
