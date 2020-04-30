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
//            ProfileActivity

class this._cls1
    implements android.widget.ckListener
{

    final g this$1;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = ((TextView)view).getText().toString();
        kota_id = kota_strarrayID[i];
        kotaProfile = adapterview;
        btnKotaProfile.setText(kotaProfile);
        kotaprefrence = kotaProfile.toString().trim();
        kotaidprefrence = kota_id;
        dialog.dismiss();
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/v2/ProfileActivity$15

/* anonymous class */
    class ProfileActivity._cls15
        implements android.view.View.OnClickListener
    {

        final ProfileActivity this$0;

        public void onClick(View view)
        {
            if (provinsi_id.equals(""))
            {
                Toast.makeText(getApplicationContext(), "Pilih provinsi terlebih dahulu", 1).show();
                return;
            }
            View view1 = getLayoutInflater().inflate(0x7f030026, null);
            view = new android.app.AlertDialog.Builder(wrapper);
            view.setView(view1);
            view.setTitle("Pilih Kota :");
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
            listKotaArrayList = new ArrayList();
            kota_strarray = loadArray(provinsiprefrence, getApplicationContext());
            kota_strarrayID = loadArray(provinsiidprefrence, getApplicationContext());
            kotaArray = new ArrayList();
            kotaArray = new ArrayList(Arrays.asList(kota_strarray));
            kotaArrayID = new ArrayList();
            kotaArrayID = new ArrayList(Arrays.asList(kota_strarrayID));
            if (kotaArray.size() != 0)
            {
                Log.e("kotaArray", "1");
                ArrayAdapter arrayadapter = new ArrayAdapter(wrapper, 0x1090003, kotaArray);
                listHp.setAdapter(arrayadapter);
                layout_empty.setVisibility(8);
                listHp.setVisibility(0);
                listHp.setOnItemClickListener(new ProfileActivity._cls15._cls1());
            } else
            {
                listOperatorAdapter = new ListOperatorAdapter(ProfileActivity.this, 0x7f03006e, listKotaArrayList);
                listHp.setAdapter(listOperatorAdapter);
                (new ProfileActivity.KotaSync(ProfileActivity.this, null)).execute(new String[] {
                    (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("tinggal_kota").append(Utility.BASE_FORMAT).append("?provinsi_id=").append(provinsi_id).append("&t=").append(t).toString()
                });
                listHp.setOnItemClickListener(new ProfileActivity._cls15._cls2());
            }
            dialog = view.create();
            dialog.show();
        }


            
            {
                this$0 = ProfileActivity.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/v2/ProfileActivity$15$2

/* anonymous class */
        class ProfileActivity._cls15._cls2
            implements android.widget.AdapterView.OnItemClickListener
        {

            final ProfileActivity._cls15 this$1;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(edtAuto.getWindowToken(), 0);
                kotaProfile = listOperatorAdapter.getListModel(i).getNm_op().toString();
                kota_id = listOperatorAdapter.getListModel(i).getKota_id().toString();
                Log.e("kota", kotaProfile);
                btnKotaProfile.setText(kotaProfile);
                kotaprefrence = kotaProfile.toString().trim();
                kotaidprefrence = kota_id;
                dialog.dismiss();
            }

                    
                    {
                        this$1 = ProfileActivity._cls15.this;
                        super();
                    }
        }

    }

}
