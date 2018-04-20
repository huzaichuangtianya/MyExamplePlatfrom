package com.example.quliang.myapplication.bean;

import com.quliang.myannotation.Factory;

/**
 * Created by quliang on 18-3-22.
 */

//@Factory(id="MealStrSub1",type=MealStr.class)
public class MealStrSub1 implements MealStr{

    public String getName(){
        return "my name is MealStrSub1";
    };
}
