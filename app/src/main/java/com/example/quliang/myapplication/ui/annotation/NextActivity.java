package com.example.quliang.myapplication.ui.annotation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.quliang.myapplication.R;

/**
 * Created by quliang on 18-3-21.
 */

public class NextActivity extends AppCompatActivity {

    /**
     * 显示数据的TextView
     */
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        textView = (TextView) findViewById(R.id.textView);

        /**
         * 想获取从哪个界面传递过来的数据，就已哪个类打头，init结尾，例如 MainActivity$Init
         */
        MainActivity$Init formIntent =
                (MainActivity$Init) new MainActivity$Init().initFields(this, 0);
        textView.setText(formIntent.count
                + "---"
                + formIntent.str
                + "---"
                + formIntent.bean.name);
//
//        //打印上个界面传递过来的数据
        Log.i("Tag", formIntent.count + "---" + formIntent.str + "---" + formIntent.bean.name);

    }

}
