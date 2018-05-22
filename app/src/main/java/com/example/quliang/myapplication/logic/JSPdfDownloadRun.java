package com.example.quliang.myapplication.logic;

import android.os.Handler;

import com.example.quliang.myapplication.bean.PdfNetBean;
import com.example.quliang.myapplication.net.DownAndUploadPic;
import com.example.quliang.myapplication.util.FileManager;

import java.io.File;

/**
 * Created by quliang on 18-5-7.
 */

public class JSPdfDownloadRun implements Runnable {

    PdfNetBean   pdfNetBean;
    Handler      handler;

    public JSPdfDownloadRun(PdfNetBean pdfNetBean, Handler handler) {
        this.pdfNetBean = pdfNetBean;
        this.handler = handler;
    }


    @Override
    public void run() {
     downloadFile();
    }

    private boolean downloadFile() {
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        File file = new File(FileManager.PATH_TEMP, pdfNetBean.getFileName());
        if (file.exists()) {
            pdfNetBean.setLoad(true);
//            handler.sendEmptyMessage(1);
            handler.sendMessage(handler.obtainMessage(1,pdfNetBean.getIndex()));
        } else {

            try {
                boolean b=DownAndUploadPic.downloadFile("http://10.50.30.189:8080/web1/img/"+pdfNetBean.getFileName(), pdfNetBean.getFilePath(), pdfNetBean.getFileName());
                pdfNetBean.setLoad(b);
                handler.sendMessage(handler.obtainMessage(1,pdfNetBean.getIndex()));
            } catch (Exception e) {
                e.printStackTrace();
            }
//            boolean result = QBaseFileNetty.downloadFile(pdfNetBean.getFilePath(), FileManager.PATH_TEMP, pdfNetBean.getFileName(), FileManager.FILE_TYPE_PDF);

        }
        return true;
    }

}
