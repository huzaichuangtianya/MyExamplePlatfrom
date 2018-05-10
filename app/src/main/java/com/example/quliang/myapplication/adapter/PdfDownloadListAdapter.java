package com.example.quliang.myapplication.adapter;

import android.app.Activity;
import android.app.Application;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.quliang.myapplication.R;
import com.example.quliang.myapplication.bean.BillPathAndViewBean;
import com.example.quliang.myapplication.bean.PdfNetBean;
import com.example.quliang.myapplication.bean.PdfObj;
import com.example.quliang.myapplication.util.AppLog;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;

import java.io.File;


/**
 * Created by quliang on 2017/9/13.
 */

public class PdfDownloadListAdapter extends QBaseAdapter<PdfNetBean>  {


    private Handler handler;

    public PdfDownloadListAdapter(Activity context, Handler handler) {
        super(context);
        this.handler=handler;

    }

    @Override
    public View getDefineView(int i, View view, ViewGroup viewGroup) {
        Holder mHolder = new Holder();
        if (view == null) {
            view = mLayoutInflater.inflate(R.layout.item_elecinvoice_img_list, null);
            mHolder.linear = (LinearLayout) view.findViewById(R.id.linear);
            mHolder.pdfView = (PDFView) view.findViewById(R.id.pdfView);
            view.setTag(mHolder);
        } else {
            mHolder = (Holder) view.getTag();
        }

        final PdfNetBean pdfObj = getItem(i);
        final   View childView= ((ViewGroup)view).getChildAt(0);
        AppLog.D("pdfObj.isLoad():"+pdfObj.isLoad());
        if(pdfObj.isLoad()){
            mHolder.pdfView.fromFile(new File(pdfObj.getFilePath()+pdfObj.getFileName())).load();
        }else{
            mHolder.pdfView.invalidate();
        }


        mHolder.pdfView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });

        mHolder.pdfView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(pdfObj.isLoad())
                handler.sendMessage(handler.obtainMessage(1,new BillPathAndViewBean(pdfObj,childView)));

                return true;
            }
        });
        return view;
    }

    private class Holder {
        PDFView      pdfView;
        LinearLayout linear;
    }


    public void updataView(int posi, ListView listView) {
        int visibleFirstPosi = listView.getFirstVisiblePosition();
        int visibleLastPosi = listView.getLastVisiblePosition();
        if (posi >= visibleFirstPosi && posi <= visibleLastPosi) {
            View                  view   = listView.getChildAt(posi - visibleFirstPosi);
            Holder mHolder = (Holder) view.getTag();

            final PdfNetBean pdfObj = getItem(posi);
            if(pdfObj.isLoad()){
                mHolder.pdfView.fromFile(new File(pdfObj.getFilePath()+pdfObj.getFileName())).load();
            }else{
                mHolder.pdfView.invalidate();
            }
        }
    }

}
