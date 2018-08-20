package com.example.quliang.myapplication.ui.shiyan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.quliang.myapplication.R;
import com.example.quliang.myapplication.adapter.FileDirAdapter;
import com.example.quliang.myapplication.bean.FileDirBean;

public class FileDirShowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_dir_show);
       ListView list =findViewById(R.id.list);

        FileDirAdapter fileDirAdapter =new FileDirAdapter(this);
//        fileDirAdapter.getDataList().add(new FileDirBean("getDataDir().getAbsolutePath():"+getDataDir().getAbsolutePath()));
//        fileDirAdapter.getDataList().add(new FileDirBean("getCodeCacheDir().getAbsolutePath():"+getCodeCacheDir().getAbsolutePath()));
//        fileDirAdapter.getDataList().add(new FileDirBean("getNoBackupFilesDir().getAbsolutePath():"+getNoBackupFilesDir().getAbsolutePath()));
//        fileDirAdapter.getDataList().add(new FileDirBean("getExternalFilesDir().getAbsolutePath():"+getExternalFilesDir().getAbsolutePath()));
        fileDirAdapter.getDataList().add(new FileDirBean("getFilesDir().getAbsolutePath():"+getFilesDir().getAbsolutePath()));
        fileDirAdapter.getDataList().add(new FileDirBean("getObbDir().getAbsolutePath():"+getObbDir().getAbsolutePath()));
        fileDirAdapter.getDataList().add(new FileDirBean("getCacheDir().getAbsolutePath():"+getCacheDir().getAbsolutePath()));
        fileDirAdapter.getDataList().add(new FileDirBean("getExternalCacheDir().getAbsolutePath():"+getExternalCacheDir().getAbsolutePath()));
//        fileDirAdapter.getDataList().add(new FileDirBean("getDir().getAbsolutePath():"+getDir().getAbsolutePath()));
        list.setAdapter(fileDirAdapter);

    }
}
