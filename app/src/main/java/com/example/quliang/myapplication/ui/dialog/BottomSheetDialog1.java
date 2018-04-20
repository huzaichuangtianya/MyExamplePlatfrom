package com.example.quliang.myapplication.ui.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.BottomSheetDialogFragment;
import android.util.Log;
import android.view.View;

import com.example.quliang.myapplication.R;

/**
 * Created by quliang on 18-4-19.
 */

public class BottomSheetDialog1 extends BottomSheetDialogFragment implements View.OnClickListener{

    private static final String TAG=BottomSheetDialog1.class.getSimpleName();
    BottomSheetDialog mBottomSheetDialog;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        if(mBottomSheetDialog==null){
            Log.d(TAG,"onCreateDialog");
            View view  = View.inflate(getContext(), R.layout.bottomsheet_shiyan1, null);
            View view1 =view.findViewById(R.id.view1);
            View view2 =view.findViewById(R.id.view2);
            View view3 =view.findViewById(R.id.view3);
            view1.setOnClickListener(this);
            view2.setOnClickListener(this);
            view3.setOnClickListener(this);

            mBottomSheetDialog = new BottomSheetDialog(getContext());
//            mBottomSheetDialog.setContentView(view);
            mBottomSheetDialog.setCancelable(false);
            mBottomSheetDialog.setCanceledOnTouchOutside(false);
        }

            return mBottomSheetDialog;
        }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.view1:
                mBottomSheetDialog.dismiss();
                break;
            case R.id.view2:
                mBottomSheetDialog.dismiss();
                break;
            case R.id.view3:
                mBottomSheetDialog.dismiss();
                break;
        }
    }
}
