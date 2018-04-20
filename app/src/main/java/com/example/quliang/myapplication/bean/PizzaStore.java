package com.example.quliang.myapplication.bean;

/**
 * Created by quliang on 18-3-22.
 */

public class PizzaStore {

      private MealFactory factory = new MealFactory();
//      private MealStrFactory mealStrFactory = new MealStrFactory();


  public Meal order(String mealName) {
      HelloWorld a=new HelloWorld();
    return factory.create(mealName);
  }

//  public MealStr getNames(String mealName) {
//    return mealStrFactory.create(mealName);
//  }

}
