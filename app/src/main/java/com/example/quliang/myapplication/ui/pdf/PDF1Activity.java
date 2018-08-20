package com.example.quliang.myapplication.ui.pdf;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.quliang.myapplication.R;
import com.example.quliang.myapplication.util.FileManager;
import com.github.barteksc.pdfviewer.PDFView;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class PDF1Activity extends AppCompatActivity {
    PDFView pdfView;
    private static final String TAG = PDF1Activity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

         pdfView=(PDFView)findViewById(R.id.pdfView);

//        "http://10.50.30.189:8080/web1/img/11.PDF"

//        pdfView.fromUri(Uri.parse("http://10.50.30.189:8080/web1/img/11.PDF")).load();
//        pdfView.fromFile(new File(FileManager.PATH_TEMP+"shiyan1.PDF")).load();
        pdfView.fromFile(new File(FileManager.PATH_TEMP+"shiyan1.PDF")).load();
//        shwoPdf();

//        pdfView.fromAsset("032001500111_83112616.PDF").load();

        pdfView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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

private void shwoPdf(){
    URL url = null;
    try {
        url = new URL("http://10.50.30.189:8080/web1/img/11.PDF");

    // 打开链接
    // 指定一个下载的目标链接，然后构建一个URL对象，调用该 对象的openConnection方法来建立一个数据通路（连接）。
    URLConnection connection =  url.openConnection();
    // 设置长链接
    connection.setRequestProperty("Connection", "Kepp-Alive");
    // 设置连接超时
    connection.setConnectTimeout(60 * 1000);

    int contentLength = connection.getContentLength();
    // 输入流
    // 代码的最后一行使用
    // connection.getInputStream，拿到一个输入流对象，通过这个流对象我们就可以读取到这个文件的内容了。下面要做的，就是读取这个流，将流写入我
    // 们的本地文件
    InputStream is = connection.getInputStream();
        pdfView.fromStream(is).load();
    } catch (Exception e) {
        e.printStackTrace();
    }


//    Uri uri=Uri.parse("http://10.50.30.189:8080/web1/img/11.PDF");
//    pdfView.fromUri(uri);
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
