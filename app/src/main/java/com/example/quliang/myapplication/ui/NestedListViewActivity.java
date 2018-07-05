package com.example.quliang.myapplication.ui;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import com.example.quliang.myapplication.R;
import com.example.quliang.myapplication.ui.dialog.BottomSheetDialog1;
import com.example.quliang.myapplication.ui.dialog.BottomSheetDialog2;
import com.example.quliang.myapplication.widget.NestedListView;

public class NestedListViewActivity extends AppCompatActivity implements View.OnClickListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        NestedListView mListView = (NestedListView) findViewById(R.id.list_view);
        String[]       arr       = new String[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + "";
        }
        mListView.setAdapter(new ArrayAdapter(this, R.layout.list_item_layout, R.id.text_name, arr));
    }




    @Override
    public void onClick(View v) {

    }
}
