package com.example.quliang.myapplication.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.quliang.myapplication.R;
import com.example.quliang.myapplication.adapter.RecyclerViewSimpleAdapter;
import com.example.quliang.myapplication.bean.SimpleBean;

public class Main8Activity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);
        RecyclerView recyclerView   = (RecyclerView) findViewById(R.id.recyclerView);

        RecyclerViewSimpleAdapter recyclerViewSimpleAdapter=new RecyclerViewSimpleAdapter();
        for (int i=0;i<30;i++){
            recyclerViewSimpleAdapter.getDataList().add(new SimpleBean("name"+i));
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recyclerViewSimpleAdapter);

    }


    @Override
    public void onClick(View v) {

    }
}