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
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.adapter.ListOperatorAdapter;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import java.util.ArrayList;
import java.util.Arrays;

// Referenced classes of package com.inponsel.android.v2:
//            ProfileActivity

class this._cls1
    implements android.widget.ckListener
{

    final g this$1;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(edtAuto.getWindowToken(), 0);
        provinsiProfile = listOperatorAdapter.getListModel(i).getNm_op().toString();
        provinsi_id = listOperatorAdapter.getListModel(i).getProvinsi_id().toString();
        Log.e("provinsi", provinsiProfile);
        btnProvProfile.setText(provinsiProfile);
        provinsiprefrence = provinsiProfile.toString().trim();
        provinsiidprefrence = provinsi_id;
        btnKotaProfile.setEnabled(true);
        dialog.dismiss();
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/v2/ProfileActivity$14

/* anonymous class */
    class ProfileActivity._cls14
        implements android.view.View.OnClickListener
    {

        final ProfileActivity this$0;

        public void onClick(View view)
        {
            View view1 = getLayoutInflater().inflate(0x7f030026, null);
            view = new android.app.AlertDialog.Builder(wrapper);
            view.setView(view1);
            view.setTitle("Pilih Provinsi :");
            layout_empty = (LinearLayout)view1.findViewById(0x7f0b0091);
            edtAuto = (EditText)view1.findViewById(0x7f0b008d);
            edtAuto.setVisibility(8);
            listHp = (ListView)view1.findViewById(0x7f0b008f);
            progressbar_search = (ProgressBar)view1.findViewById(0x7f0b008e);
            txtEmpty = (TextView)view1.findViewById(0x7f0b0093);
            txtEmpty.setText(0x7f0c0053);
            if (android.os.Build.VERSION.SDK_INT < 13)
            {
                listHp.setBackgroundColor(-1);
            }
            listProvArrayList = new ArrayList();
            provinsi_strarray = loadArray("provinsiArray", getApplicationContext());
            provinsi_strarrayID = loadArray("provinsiArrayID", getApplicationContext());
            provinsiArray = new ArrayList();
            provinsiArray = new ArrayList(Arrays.asList(provinsi_strarray));
            provinsiArrayID = new ArrayList();
            provinsiArrayID = new ArrayList(Arrays.asList(provinsi_strarrayID));
            if (provinsiArray.size() != 0)
            {
                Log.e("provinsiArray", "1");
                ArrayAdapter arrayadapter = new ArrayAdapter(wrapper, 0x1090003, provinsiArray);
                listHp.setAdapter(arrayadapter);
                layout_empty.setVisibility(8);
                listHp.setVisibility(0);
                listHp.setOnItemClickListener(new ProfileActivity._cls14._cls1());
            } else
            {
                listOperatorAdapter = new ListOperatorAdapter(ProfileActivity.this, 0x7f03006e, listProvArrayList);
                listHp.setAdapter(listOperatorAdapter);
                Log.e("prov", (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("tinggal_provinsi").append(Utility.BASE_FORMAT).append("?t=").append(t).toString());
                (new ProfileActivity.ProvinsiSync(ProfileActivity.this, null)).execute(new String[] {
                    (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("tinggal_provinsi").append(Utility.BASE_FORMAT).append("?t=").append(t).toString()
                });
                listHp.setOnItemClickListener(new ProfileActivity._cls14._cls2());
            }
            dialog = view.create();
            dialog.show();
        }


            
            {
                this$0 = ProfileActivity.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/v2/ProfileActivity$14$1

/* anonymous class */
        class ProfileActivity._cls14._cls1
            implements android.widget.AdapterView.OnItemClickListener
        {

            final ProfileActivity._cls14 this$1;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                adapterview = ((TextView)view).getText().toString();
                provinsi_id = provinsi_strarrayID[i];
                provinsiProfile = adapterview;
                btnProvProfile.setText(provinsiProfile);
                btnKotaProfile.setEnabled(true);
                provinsiprefrence = provinsiProfile.toString().trim();
                provinsiidprefrence = provinsi_id;
                dialog.dismiss();
            }

                    
                    {
                        this$1 = ProfileActivity._cls14.this;
                        super();
                    }
        }

    }

}
