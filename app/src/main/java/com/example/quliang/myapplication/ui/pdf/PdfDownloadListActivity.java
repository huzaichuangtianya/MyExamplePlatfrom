package com.example.quliang.myapplication.ui.pdf;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.quliang.myapplication.MyApplication;
import com.example.quliang.myapplication.R;
import com.example.quliang.myapplication.adapter.PdfDownloadListAdapter;
import com.example.quliang.myapplication.bean.PdfNetBean;
import com.example.quliang.myapplication.logic.JSPdfDownloadRun;
import com.example.quliang.myapplication.util.AppLog;
import com.example.quliang.myapplication.util.FileManager;
import com.example.quliang.myapplication.util.ToastUtils;

import java.util.List;
import java.util.concurrent.ExecutorService;

public class PdfDownloadListActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = PDF2Activity.class.getSimpleName();
    PdfDownloadListAdapter pdfDownloadListAdapter;
    ListView               listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_pdf_download_list);
        super.onCreate(savedInstanceState);

        MyApplication myApplication = (MyApplication) getApplication();

        AppLog.D("myApplication.getKan1():" + myApplication.getKan1());

        listView = findViewById(R.id.listView);


        initHead();
        listView.addHeaderView(view);


//        executorService = Executors.newFixedThreadPool(2);
        initData();
        handler.sendEmptyMessage(1);

//        handler.sendEmptyMessage(5);
//        handler.sendEmptyMessage(5);
    }

    private View view;

    private void initHead() {
        view = getLayoutInflater().inflate(R.layout.view_head_pdfdownload, null);
    }


    private void initData() {
        pdfDownloadListAdapter = new PdfDownloadListAdapter(this, handler);
        listView.setAdapter(pdfDownloadListAdapter);
        for (int i = 1; i < 16; i++) {
            pdfDownloadListAdapter.getDataList().add(new PdfNetBean(FileManager.PATH_TEMP, i + ".PDF", true, i));
        }
        pdfDownloadListAdapter.notifyDataSetChanged();

//        pdfDownloadListAdapter.notifyDataSetChanged();

//        DownloadPdf(pdfDownloadListAdapter.getDataList());

    }


    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
//                    int index = (int) msg.obj;
//                    pdfDownloadListAdapter.updataView(index, listView);//动态修改
                    pdfDownloadListAdapter.notifyDataSetChanged();
                    break;
                case 2:
                    ToastUtils.toastLong(PdfDownloadListActivity.this, "下载成功了");
                    break;
            }
        }
    };

    @Override
    public void onClick(View v) {

    }
//    private void screenShot(View groupView, String path) {
//        handler.sendMessage(handler.obtainMessage(BaseBusiness.START));
//        Bitmap bitmap = Bitmap.createBitmap(
//                groupView.getWidth(),
//                groupView.getHeight(),
//                Bitmap.Config.ARGB_8888);
//        Canvas c = new Canvas(bitmap);
//        groupView.draw(c);
//        QLBitmapUtil.saveBitmap(bitmap, path);
//    }

    private ExecutorService executorService;

    private void DownloadPdf(List<PdfNetBean> pdfNetBeans) {
        for (PdfNetBean pdfNetBean : pdfNetBeans) {
            executorService.execute(new JSPdfDownloadRun(pdfNetBean, handler));
        }
    }

//
//    private void shareWeChat(String path) {
//        Uri    uriToImage  = Uri.fromFile(new File(path));
//        Intent shareIntent = new Intent();
//        //发送图片到朋友圈
//        //ComponentName comp = new ComponentName("com.tencent.mm", "com.tencent.mm.ui.tools.ShareToTimeLineUI");
//        //发送图片给好友。
//        ComponentName comp = new ComponentName("com.tencent.mm", "com.tencent.mm.ui.tools.ShareImgUI");
//        shareIntent.setComponent(comp);
//        shareIntent.setAction(Intent.ACTION_SEND);
//        shareIntent.putExtra(Intent.EXTRA_STREAM, uriToImage);
//        shareIntent.setType("*/*");
//        startActivity(Intent.createChooser(shareIntent, "分享图片"));
//
//    }
//
//    private void shareQQ(String path) {
//        Uri    uriToImage  = Uri.fromFile(new File(path));
//        Intent shareIntent = new Intent();
//        //发送图片到朋友圈
//        //ComponentName comp = new ComponentName("com.tencent.mm", "com.tencent.mm.ui.tools.ShareToTimeLineUI");
//        //发送图片给好友。
//        ComponentName comp = new ComponentName("com.tencent.mobileqq", "com.tencent.mobileqq.activity.JumpActivity");
//        shareIntent.setComponent(comp);
//        shareIntent.setAction(Intent.ACTION_SEND);
//        shareIntent.putExtra(Intent.EXTRA_STREAM, uriToImage);
//        shareIntent.setType("*/*");
//        startActivity(Intent.createChooser(shareIntent, "分享图片"));
//
//    }


}
