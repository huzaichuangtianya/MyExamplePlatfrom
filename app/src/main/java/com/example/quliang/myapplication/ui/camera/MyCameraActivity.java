package com.example.quliang.myapplication.ui.camera;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ImageFormat;
import android.hardware.Camera;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.quliang.myapplication.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MyCameraActivity extends AppCompatActivity implements View.OnClickListener {
    SurfaceView  sfv;
    LinearLayout ll_bottom;
    ImageView    iv;
    Button       btn;
    Button       btnSwitch;

    private Camera        camera;
    private SurfaceHolder surfaceHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_camera);
        sfv = findViewById(R.id.sfv);
        ll_bottom = findViewById(R.id.ll_bottom);
        btnSwitch = findViewById(R.id.btnSwitch);
        iv = findViewById(R.id.iv);
        btn = findViewById(R.id.btn);

        btn.setOnClickListener(this);
        btnSwitch.setOnClickListener(this);

        camera = Camera.open();
        surfaceHolder = sfv.getHolder();

        surfaceHolder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                startPreview();
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
                //停止旧的预览,开启新的预览
                camera.stopPreview();
                startPreview();
            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                //停止预览,释放资源
                stopCamera();
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
                //设置相机的各种参数
                Camera.Parameters parameters = camera.getParameters();
                //对焦的方式
                parameters.setFocusMode(Camera.Parameters.ANTIBANDING_AUTO);
                //照片的类型
                parameters.setPictureFormat(ImageFormat.JPEG);
                //对焦监听
                camera.autoFocus(new Camera.AutoFocusCallback() {
                    @Override
                    public void onAutoFocus(boolean success, Camera camera) {
                        //对焦成功
                        if (success) {
                            camera.takePicture(null, null, cameraCallBack);
                        } else {
                            Toast.makeText(MyCameraActivity.this, "对焦失败!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                break;

            case R.id.btnSwitch:
                switchCamera();
                break;
        }
    }

    /**
     * 相机预览
     */
    private void startPreview() {
        try {
            //相机与SurfaceView进行绑定
            camera.setPreviewDisplay(surfaceHolder);
            //预览的图片旋转
            camera.setDisplayOrientation(90);
            camera.startPreview();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 停止拍照释放资源
     */
    private void stopCamera() {
        if (camera != null) {
            camera.stopPreview();
            camera.release();
            camera = null;
        }
    }

    /**
     * 拍照成功回调函数
     */
    private Camera.PictureCallback cameraCallBack = new Camera.PictureCallback() {
        @Override
        public void onPictureTaken(byte[] data, Camera camera) {
            startPreview();

            //先验证手机是否有sdcard
            String status = Environment.getExternalStorageState();
            if (!status.equals(Environment.MEDIA_MOUNTED)) {
                Toast.makeText(getApplicationContext(), "你的sd卡不可用。", Toast.LENGTH_SHORT).show();
                return;
            }
            //大部分手机拍照都是存到这个路径
            String filePath    = Environment.getExternalStorageDirectory().getPath() + "/DCIM/Camera/";
            String picturePath = System.currentTimeMillis() + ".jpg";
            File   file        = new File(filePath, picturePath);
            try {
                //存到本地相册
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                fileOutputStream.write(data);
                fileOutputStream.close();

                //显示图片
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = 2;
                Bitmap bitmap = BitmapFactory.decodeByteArray(data, 0, data.length, options);
                iv.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    };


    int cameraPosition = 1;

    public void switchCamera() {
        //切换前后摄像头
        int               cameraCount = 0;
        Camera.CameraInfo cameraInfo  = new Camera.CameraInfo();
        cameraCount = Camera.getNumberOfCameras();//得到摄像头的个数

        for (int i = 0; i < cameraCount; i++) {
            Camera.getCameraInfo(i, cameraInfo);//得到每一个摄像头的信息
            if (cameraPosition == 1) {
                //现在是后置，变更为前置
                if (cameraInfo.facing == Camera.CameraInfo.CAMERA_FACING_FRONT) {//代表摄像头的方位，CAMERA_FACING_FRONT前置      CAMERA_FACING_BACK后置
                    camera.stopPreview();//停掉原来摄像头的预览
                    camera.release();//释放资源
                    camera = null;//取消原来摄像头
                    camera = Camera.open(i);//打开当前选中的摄像头
                    try {
                        camera.setPreviewDisplay(surfaceHolder);//通过surfaceview显示取景画面
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    camera.startPreview();//开始预览
                    cameraPosition = 0;
                    break;
                }
            } else {
                //现在是前置， 变更为后置
                if (cameraInfo.facing == Camera.CameraInfo.CAMERA_FACING_BACK) {//代表摄像头的方位，CAMERA_FACING_FRONT前置      CAMERA_FACING_BACK后置
                    camera.stopPreview();//停掉原来摄像头的预览
                    camera.release();//释放资源
                    camera = null;//取消原来摄像头
                    camera = Camera.open(i);//打开当前选中的摄像头
                    try {
                        camera.setPreviewDisplay(surfaceHolder);//通过surfaceview显示取景画面
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    camera.startPreview();//开始预览
                    cameraPosition = 1;
                    break;
                }
            }

        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (camera == null) {
            camera = Camera.open();
            if (surfaceHolder != null) {
                startPreview();
            }
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        if (camera != null) {
            stopCamera();
        }
    }

}
