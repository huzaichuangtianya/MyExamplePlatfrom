package com.example.quliang.myapplication.ui.annotation;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.quliang.myapplication.R;

import com.example.quliang.myapplication.bean.Meal;
import com.example.quliang.myapplication.bean.MealStr;
import com.example.quliang.myapplication.bean.PizzaStore;
import com.example.quliang.myapplication.bean.StuBean;
import com.quliang.myannotation.MyAnnotation;


/**
 * Created by quliang on 18-3-21.
 */

@MyAnnotation("Hello Annotation")
public class AnnotationActivity1 extends AppCompatActivity {

    //    @IntentField("NextActivity")
    int count = 10;

    //    @IntentField("NextActivity")
    String str = "编译器注解";

    //    @IntentField("NextActivity")
    StuBean bean = new StuBean(1, "No1");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_annotation1);
        TextView textView = findViewById(R.id.textView);
        TextView textView1 = findViewById(R.id.textView1);
        TextView textView2 = findViewById(R.id.textView2);
        TextView textView3 = findViewById(R.id.textView3);
        TextView textView4 = findViewById(R.id.textView4);
        TextView textView5 = findViewById(R.id.textView5);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new MainActivity$Enter().intentTo(AnnotationActivity1.this, count, str, bean);
            }
        });

        PizzaStore pizzaStore = new PizzaStore();
        Meal       meal       = pizzaStore.order("Tiramisu");
        Log.d("AnnotationActivity1", "AnnotationActivity1:" + meal.getPrice());
        System.out.println("Bill: $" + meal.getPrice());

        textView1.setText("getCacheDir:"+getCacheDir().getAbsolutePath());
        textView2.setText("getFilesDir:"+getFilesDir().getAbsolutePath());
        textView3.setText("getObbDir:"+getObbDir().getAbsolutePath());
        textView4.setText("getExternalCacheDir:"+getExternalCacheDir().getAbsolutePath());
        textView5.setText("getExternalFilesDir:"+getExternalFilesDir(Environment.DIRECTORY_PICTURES).getAbsolutePath());
//        textView5.setText("getDataDir:"+getDataDir().getAbsolutePath());


//        MealStr mealStr =pizzaStore.getNames("MealStrSub1");
//        System.out.println("mealStr: $" + mealStr.getName());
//        Log.d("AnnotationActivity1", "AnnotationActivity1:" + mealStr.getName());

//        textView.setOnClickListener((view)->{
//            new AnnotationActivity1$Enter()
//                    .intentTo(AnnotationActivity1.this,count,str,bean);
//        });
    }

}
