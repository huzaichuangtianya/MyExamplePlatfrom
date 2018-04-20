package com.example.quliang.myapplication.bean;

import com.quliang.myannotation.Factory;

/**
 * Created by quliang on 18-3-22.
 */

//@Factory(id="CalzonePizza",type =Meal.class )
public class CalzonePizza implements Meal {
    @Override
    public float getPrice() {
        return 6f;
    }
}
