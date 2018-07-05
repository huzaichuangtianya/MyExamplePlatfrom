package com.example.quliang.myapplication.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;

import com.example.quliang.myapplication.R;
import com.example.quliang.myapplication.widget.MyListView;
import com.example.quliang.myapplication.widget.NestedListView;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        MyListView lv   = (MyListView) findViewById(R.id.lv);
        ArrayList  list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i + "");
        }
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);
        lv.setAdapter(adapter);
    }


    @Override
    public void onClick(View v) {

    }
}
