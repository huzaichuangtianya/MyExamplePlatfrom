package com.example.quliang.myapplication.util;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

public class ToastUtils {
    public static void toastLong(Context context, String content) {
        Toast toast = Toast.makeText(context, content, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    public static void toastshort(Context context, String content) {
        Toast toast = Toast.makeText(context, content, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    public static void toastLong(Context context, int msgId) {
        Toast toast = Toast.makeText(context, msgId, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    public static void toastshort(Context context, int msgId) {
        Toast toast = Toast.makeText(context, msgId, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }


    public static void toastshort(Context context, View view) {
//		Toast.makeText(context, content, Toast.LENGTH_SHORT).show();
    }
}
