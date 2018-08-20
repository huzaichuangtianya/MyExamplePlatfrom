package com.example.quliang.myapplication.ui.shiyan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.quliang.myapplication.R;

public class TextChangelineActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_changeline);

        TextView elec_tax_name=findViewById(R.id.elec_tax_name);


        String str1="字符串中在特定位置插入另一个字符串可以采用字符串中怎样在特定位置插入另一字符串大多应用于虚拟机空间不足的情况下的空间扩容等等大多应用于虚拟机空间不足的情况下的空间扩容等等";
       int length= str1.length();
        int count=length/10;
        StringBuilder sb=new StringBuilder(str1);

        for(int i=0;i<count;i++){
            sb.insert((i+1)*10+i,"\n");
//            sb.insert(i*10,"\n");
        }

        elec_tax_name.setText(sb.toString());

    }
}
