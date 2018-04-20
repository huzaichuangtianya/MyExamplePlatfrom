package com.example.quliang.myapplication.bean;

import com.quliang.myannotation.Factory;

/**
 * Created by quliang on 18-3-22.
 */

@Factory(id="Tiramisu",type =Meal.class )
public class Tiramisu implements Meal {
    @Override
    public float getPrice() {
        return 19f;
    }
}
