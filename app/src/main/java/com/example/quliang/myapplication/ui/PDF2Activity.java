package com.example.quliang.myapplication.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.quliang.myapplication.R;
import com.example.quliang.myapplication.adapter.PdfListAdapter;
import com.example.quliang.myapplication.bean.PdfObj;

public class PDF2Activity extends AppCompatActivity {

    private static final String TAG = PDF2Activity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        ListView listView =findViewById(R.id.listView);

        PdfListAdapter pdfListAdapter=new PdfListAdapter(this);

        pdfListAdapter.getDataList().add(new PdfObj("032001500111_83112616.PDF"));
        pdfListAdapter.getDataList().add(new PdfObj("032001500111_83112617.PDF"));
        listView.setAdapter(pdfListAdapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG,"kankan3");
                return false;
            }
        });

}

}
