package com.example.quliang.myapplication.ui.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.quliang.myapplication.R;
import com.example.quliang.myapplication.adapter.SimpleAdapter;
import com.example.quliang.myapplication.bean.SimpleBean;

/**
 * Created by quliang on 18-4-19.
 */

public class BottomSheetDialog2 extends BottomSheetDialogFragment implements View.OnClickListener {


    BottomSheetDialog mBottomSheetDialog;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        if (mBottomSheetDialog == null) {
            View     view     = View.inflate(getContext(), R.layout.bottomsheet_shiyan2, null);
            ListView listview = view.findViewById(R.id.listview);


            SimpleAdapter simpleAdapter = new SimpleAdapter(getActivity());
            for (int i = 0; i < 16; i++) {
                simpleAdapter.getDataList().add(new SimpleBean(String.valueOf(i)));
            }
            listview.setAdapter(simpleAdapter);

            listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    mBottomSheetDialog.dismiss();
                }
            });

            mBottomSheetDialog = new BottomSheetDialog(getContext());
            mBottomSheetDialog.setTitle("我的标题");
            mBottomSheetDialog.setContentView(view);
            mBottomSheetDialog.setCancelable(false);
            mBottomSheetDialog.setCanceledOnTouchOutside(false);
        }

        return mBottomSheetDialog;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
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
