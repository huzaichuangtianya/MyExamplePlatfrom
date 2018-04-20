package com.example.quliang.myapplication.adapter;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.example.quliang.myapplication.R;
import com.example.quliang.myapplication.bean.PdfObj;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;



/**
 * Created by quliang on 2017/9/13.
 */

public class PdfListAdapter extends QBaseAdapter<PdfObj> implements OnLoadCompleteListener{

    private static final String TAG = PdfListAdapter.class.getSimpleName();


    public PdfListAdapter(Activity context) {
        super(context);
    }

    @Override
    public View getDefineView(int i, View view, ViewGroup viewGroup) {
        Holder mHolder = new Holder();
        if (view == null) {
            view = mLayoutInflater.inflate(R.layout.item_pdf_list, null);
            mHolder.pdfView = (PDFView) view.findViewById(R.id.pdfView);
//
            view.setTag(mHolder);
        } else {
            mHolder = (Holder) view.getTag();
        }

        final PdfObj pdfObj = getItem(i);
        mHolder.pdfView.fromAsset(pdfObj.pdfUri).load();
        mHolder.pdfView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"kankan1");
            }
        });


        mHolder.pdfView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

//                Log.d(TAG,"kankan3");
                return false;
            }
        });

//        mHolder.pdfView.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View v) {
//                Log.d(TAG,"kankan2");
//                return true;
//            }
//        });
        return view;
    }

    @Override
    public void loadComplete(int nbPages) {

    }

    private class Holder {
//        TextView pdfView;
        PDFView pdfView;

    }



}
