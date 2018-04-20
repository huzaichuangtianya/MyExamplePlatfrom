package com.example.quliang.myapplication.adapter;

import android.app.Activity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.quliang.myapplication.R;
import com.example.quliang.myapplication.bean.PdfObj;
import com.example.quliang.myapplication.bean.SimpleBean;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;


/**
 * Created by quliang on 2017/9/13.
 */

public class SimpleAdapter extends QBaseAdapter<SimpleBean> {

    private static final String TAG = SimpleAdapter.class.getSimpleName();


    public SimpleAdapter(Activity context) {
        super(context);
    }

    @Override
    public View getDefineView(int i, View view, ViewGroup viewGroup) {
        Holder mHolder = new Holder();
        if (view == null) {
            view = mLayoutInflater.inflate(R.layout.item_simple_list, null);
            mHolder.textView = (TextView) view.findViewById(R.id.textView);
            view.setTag(mHolder);
        } else {
            mHolder = (Holder) view.getTag();
        }

        final SimpleBean pdfObj = getItem(i);
        mHolder.textView.setText(pdfObj.getName());

        return view;
    }

    private class Holder {
        TextView textView;
    }

}
