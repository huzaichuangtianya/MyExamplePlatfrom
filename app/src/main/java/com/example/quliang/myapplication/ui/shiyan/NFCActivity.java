package com.example.quliang.myapplication.ui.shiyan;


import android.app.PendingIntent;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quliang.myapplication.R;
import com.example.quliang.myapplication.nfc.card.CardManager;

import org.bouncycastle.crypto.tls.ContentType;

import java.util.HashMap;
import java.util.Map;


public class NFCActivity extends AppCompatActivity {

    private Button clearBtn = null;

    private EditText sealCompanyName = null;
    private EditText sealName        = null;
    private EditText sealNumber      = null;
    private EditText sealTaxId       = null;
    private EditText sealCode        = null;
    private EditText sealMaterial    = null;
    private EditText sealSize        = null;

    private EditText companyMadedName = null;
    private EditText companyMadedTime = null;

    private EditText companyCheckedName = null;

    private NfcAdapter    nfcAdapter;
    private PendingIntent pendingIntent;

    private Resources res;

    private void initView(){


        sealCompanyName = (EditText) this.findViewById(R.id.edittext_seal_company_name);
        sealName = (EditText) this.findViewById(R.id.edittext_seal_name);
        sealNumber = (EditText) this.findViewById(R.id.edittext_seal_number);
        sealTaxId = (EditText) this.findViewById(R.id.edittext_tax_id);
        sealCode = (EditText) this.findViewById(R.id.edittext_code);
        sealMaterial = (EditText) this.findViewById(R.id.edittext_seal_material);
        sealSize = (EditText) this.findViewById(R.id.edittext_seal_size);

        companyMadedName = (EditText) this.findViewById(R.id.edittext_company_maded_name);
        companyMadedTime = (EditText) this.findViewById(R.id.edittext_company_maded_time);

        companyCheckedName = (EditText) this.findViewById(R.id.edittext_company_checked_name);

        clearBtn = (Button) this.findViewById(R.id.clear_btn);


        clearBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                cleanData();
            }
        });
    }

    //清除数据信息
    private void cleanData(){
        sealCompanyName.setText("");
        sealName.setText("");
        sealNumber.setText("");
        sealTaxId.setText("");
        sealCode.setText("");
        sealMaterial.setText("");
        sealSize.setText("");
        companyMadedName.setText("");
        companyMadedTime.setText("");
        companyCheckedName.setText("");
    }


    @Override
    public void onCreate(Bundle savedState) {
        super.onCreate(savedState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_nfc);
        res=getResources();
        initView();
        nfcAdapter = NfcAdapter.getDefaultAdapter(this);
        pendingIntent = PendingIntent.getActivity(this, 0, new Intent(this,getClass()).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP), 0);

        onNewIntent(getIntent());
    }


    @Override
    protected void onPause() {
        super.onPause();

        if (nfcAdapter != null)
            nfcAdapter.disableForegroundDispatch(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (nfcAdapter != null)
            nfcAdapter.enableForegroundDispatch(this, pendingIntent,
                    CardManager.FILTERS, CardManager.TECHLISTS);

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        final Parcelable p = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);
        Log.d("NFCTAG", intent.getAction());
        showData((p != null) ? CardManager.load(p, res) : null);
    }

    private void showData(String data) {
        if (data == null || data.length() == 0) {
            showHint();
            return;
        }
        sealCompanyName.setText(Html.fromHtml(data));
    }


    private void showHint() {
        sealCompanyName.setText("(data == null || data.length() == 0)");
    }



    private void shiyan(){
        Map<String,String> map=new HashMap<String,String>();
    }
}
