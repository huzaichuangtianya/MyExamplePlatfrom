package com.example.quliang.myapplication.bean;

import android.view.View;

/**
 * Created by quliang on 2017/9/19.
 */

public class BillPathAndViewBean {
private PdfNetBean pdfNetBean;
private View       view;

    public BillPathAndViewBean(PdfNetBean pdfNetBean, View view) {
        this.pdfNetBean = pdfNetBean;
        this.view = view;
    }

    public PdfNetBean getPdfNetBean() {
        return pdfNetBean;
    }

    public void setPdfNetBean(PdfNetBean pdfNetBean) {
        this.pdfNetBean = pdfNetBean;
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }
}
