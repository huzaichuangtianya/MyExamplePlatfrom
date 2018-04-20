package com.example.quliang.myapplication.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.quliang.myapplication.R;
import com.github.barteksc.pdfviewer.PDFView;

public class Main1Activity extends AppCompatActivity {

    private static final String TAG = Main1Activity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        PDFView pdfView=(PDFView)findViewById(R.id.pdfView);


        pdfView.fromAsset("032001500111_83112616.PDF").load();

        pdfView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"kankan");
                Log.d(TAG,"kankan");
                Log.d(TAG,"kankan");
            }
        });
//                .pages(0, 2, 1, 3, 3, 3) // all pages are displayed by default
                //                .pages(0, 2, 3, 4, 5); // 把0 , 2 , 3 , 4 , 5 过滤掉
                //是否允许翻页，默认是允许翻页
//                .enableSwipe(true)
                //pdf文档翻页是否是垂直翻页，默认是左右滑动翻页
//                .swipeHorizontal(true)
                //
//                .enableDoubletap(false).load();
                //设置默认显示第0页
//                .defaultPage(myPage)
                //允许在当前页面上绘制一些内容，通常在屏幕中间可见。
//                .onDraw(onDrawListener)
//                // 允许在每一页上单独绘制一个页面。只调用可见页面
//                .onDrawAll(onDrawListener)
                //设置加载监听
//                .onLoad(new OnLoadCompleteListener() {
//                    @Override
//                    public void loadComplete(int nbPages) {
//                        pageTv.setText(nbPages + "");
//                        pageTv1.setText(myPage +  "/");
//                    }
//                })
                //设置翻页监听
//                .onPageChange(new ViewPager.OnPageChangeListener() {

//                    @Override
//                    public void onPageChanged(int page, int pageCount) {
//                        p = page;
//                        pageTv1.setText(page + "/");
//                    }
//                })
                //设置页面滑动监听
//                .onPageScroll(onPageScrollListener)
//                .onError(onErrorListener)
                // 首次提交文档后调用。
//                .onRender(onRenderListener)
                // 渲染风格（就像注释，颜色或表单）
//                .enableAnnotationRendering(false)
//                .password(null)
//                .scrollHandle(null)
                // 改善低分辨率屏幕上的渲染
//                .enableAntialiasing(true)
//                 页面间的间距。定义间距颜色，设置背景视图
//                .spacing(0)
//                .load();



}


//    private static String[] PERMISSIONS_STORAGE = {
//            Manifest.permission.READ_EXTERNAL_STORAGE,
//            Manifest.permission.WRITE_EXTERNAL_STORAGE
//    };
//
//
//    private void getPermission() {
//        int hasWriteContactsPermission = ContextCompat.checkSelfPermission(MainActivity.this,
//                Manifest.permission.READ_EXTERNAL_STORAGE);
//        if (hasWriteContactsPermission != PackageManager.PERMISSION_GRANTED) {
//            if (!ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,
//                    Manifest.permission.READ_EXTERNAL_STORAGE)) {
//                ActivityCompat.requestPermissions(MainActivity.this,
//                        PERMISSIONS_STORAGE, REQUEST_EXTERNAL_STORAGE);
//            }
//
//            ActivityCompat.requestPermissions(MainActivity.this,
//                    PERMISSIONS_STORAGE, REQUEST_EXTERNAL_STORAGE);
//        }
//
//        while ((ContextCompat.checkSelfPermission(MainActivity.this,
//                Manifest.permission.READ_EXTERNAL_STORAGE)) != PackageManager.PERMISSION_GRANTED) {
//        }
//    }
}
