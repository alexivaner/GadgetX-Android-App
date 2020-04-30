// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.adapter.ListOperatorAdapter;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import java.util.ArrayList;
import java.util.Arrays;

// Referenced classes of package com.inponsel.android.v2:
//            RegisterActivity

class this._cls1
    implements android.widget.ckListener
{

    final og this$1;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = ((TextView)view).getText().toString();
        kecamatan_id = kecamatan_strarrayID[i];
        kecamatan = adapterview;
        btnKecamatan.setText(kecamatan);
        btnKecamatan.setEnabled(true);
        dialog.dismiss();
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/v2/RegisterActivity$8

/* anonymous class */
    class RegisterActivity._cls8
        implements android.view.View.OnClickListener
    {

        final RegisterActivity this$0;

        public void onClick(View view)
        {
            if (provinsi_id.equals(""))
            {
                Toast.makeText(getApplicationContext(), "Pilih provinsi terlebih dahulu", 1).show();
                return;
            }
            if (kota.equals(""))
            {
                Toast.makeText(getApplicationContext(), "Pilih kota terlebih dahulu", 1).show();
                return;
            }
            View view1 = getLayoutInflater().inflate(0x7f030026, null);
            view = new android.app.AlertDialog.Builder(wrapper);
            view.setView(view1);
            view.setTitle("Pilih kecamatan :");
            layout_empty = (LinearLayout)view1.findViewById(0x7f0b0091);
            edtAuto = (EditText)view1.findViewById(0x7f0b008d);
            edtAuto.setVisibility(8);
            listHp = (ListView)view1.findViewById(0x7f0b008f);
            if (android.os.Build.VERSION.SDK_INT < 13)
            {
                listHp.setBackgroundColor(-1);
            }
            progressbar_search = (ProgressBar)view1.findViewById(0x7f0b008e);
            txtEmpty = (TextView)view1.findViewById(0x7f0b0093);
            txtEmpty.setText(0x7f0c0053);
            listKecamatanArrayList = new ArrayList();
            kecamatan_strarray = loadArray(provinsiprefrence, getApplicationContext());
            kecamatan_strarrayID = loadArray(provinsiidprefrence, getApplicationContext());
            kecamatanArray = new ArrayList();
            kecamatanArray = new ArrayList(Arrays.asList(kecamatan_strarray));
            kecamatanArrayID = new ArrayList();
            kecamatanArrayID = new ArrayList(Arrays.asList(kecamatan_strarrayID));
            if (kecamatanArray.size() != 0)
            {
                Log.e("kecamatanArray", "1");
                ArrayAdapter arrayadapter = new ArrayAdapter(wrapper, 0x1090003, kecamatanArray);
                listHp.setAdapter(arrayadapter);
                layout_empty.setVisibility(8);
                listHp.setVisibility(0);
                listHp.setOnItemClickListener(new RegisterActivity._cls8._cls1());
            } else
            {
                listOperatorAdapter = new ListOperatorAdapter(RegisterActivity.this, 0x7f03006e, listKecamatanArrayList);
                listHp.setAdapter(listOperatorAdapter);
                String s = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("list_kecamatan").append(Utility.BASE_FORMAT).append("?provinsi_id=").append(provinsi_id).append("&kota_id=").append(kota_id).append("&t=").append(t).toString();
                (new RegisterActivity.KecamatanSync(RegisterActivity.this, null)).execute(new String[] {
                    s
                });
                listHp.setOnItemClickListener(new RegisterActivity._cls8._cls2());
            }
            dialog = view.create();
            dialog.show();
        }


            
            {
                this$0 = RegisterActivity.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/v2/RegisterActivity$8$2

/* anonymous class */
        class RegisterActivity._cls8._cls2
            implements android.widget.AdapterView.OnItemClickListener
        {

            final RegisterActivity._cls8 this$1;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(edtAuto.getWindowToken(), 0);
                kecamatan = listOperatorAdapter.getListModel(i).getNm_op().toString();
                kecamatan_id = listOperatorAdapter.getListModel(i).getKecamatan_id().toString();
                Log.e("kecamatan", kecamatan);
                btnKecamatan.setText(kecamatan);
                dialog.dismiss();
                btnKecamatan.setEnabled(true);
            }

                    
                    {
                        this$1 = RegisterActivity._cls8.this;
                        super();
                    }
        }

    }

}
