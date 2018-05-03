package com.example.quliang.myapplication.adapter;

import android.app.Activity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.quliang.myapplication.R;
import com.example.quliang.myapplication.bean.FileDirBean;
import com.example.quliang.myapplication.bean.PdfObj;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;


/**
 * Created by quliang on 2017/9/13.
 */

public class FileDirAdapter extends QBaseAdapter<FileDirBean> implements OnLoadCompleteListener{

    private static final String TAG = FileDirAdapter.class.getSimpleName();


    public FileDirAdapter(Activity context) {
        super(context);
    }

    @Override
    public View getDefineView(int i, View view, ViewGroup viewGroup) {
        Holder mHolder = new Holder();
        if (view == null) {
            view = mLayoutInflater.inflate(R.layout.item_filedir_list, null);
            mHolder.tvName = (TextView) view.findViewById(R.id.tvName);
//
            view.setTag(mHolder);
        } else {
            mHolder = (Holder) view.getTag();
        }

        final FileDirBean pdfObj = getItem(i);
        mHolder.tvName.setText(pdfObj.getName());

        return view;
    }

    @Override
    public void loadComplete(int nbPages) {

    }

    private class Holder {
        TextView tvName;

    }



}
