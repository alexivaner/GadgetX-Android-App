// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.servicenter;

import android.app.Dialog;
import android.support.v4.app.FragmentActivity;
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

// Referenced classes of package com.inponsel.android.servicenter:
//            Hal1SCManual

class this._cls1
    implements android.widget.mClickListener
{

    final og this$1;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        ((InputMethodManager)getActivity().getSystemService("input_method")).hideSoftInputFromWindow(edtAuto.getWindowToken(), 0);
        kotaProfile = listOperatorAdapter.getListModel(i - 1).getNm_op().toString();
        kota_id = listOperatorAdapter.getListModel(i - 1).getKota_id().toString();
        Log.e("kota", kotaProfile);
        btnSCPencKota.setText(kotaProfile);
        dialog.dismiss();
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/servicenter/Hal1SCManual$3

/* anonymous class */
    class Hal1SCManual._cls3
        implements android.view.View.OnClickListener
    {

        final Hal1SCManual this$0;

        public void onClick(View view)
        {
            if (provinsi_id.equals("") || provinsi_id.equals("nil"))
            {
                Toast.makeText(getActivity(), "Pilih provinsi terlebih dahulu", 1).show();
                return;
            }
            View view1 = getActivity().getLayoutInflater().inflate(0x7f030026, null);
            view = new android.app.AlertDialog.Builder(getActivity());
            view.setView(view1);
            view.setTitle("Pilih Kota :");
            layout_empty = (LinearLayout)view1.findViewById(0x7f0b0091);
            edtAuto = (EditText)view1.findViewById(0x7f0b008d);
            edtAuto.setVisibility(8);
            listHp = (ListView)view1.findViewById(0x7f0b008f);
            progressbar_search = (ProgressBar)view1.findViewById(0x7f0b008e);
            txtEmpty = (TextView)view1.findViewById(0x7f0b0093);
            txtEmpty.setText(0x7f0c0053);
            btnAbaikan.setText((new StringBuilder("Seluruh kota di ")).append(provinsiProfile).toString());
            if (android.os.Build.VERSION.SDK_INT < 13)
            {
                listHp.setBackgroundColor(-1);
            }
            listKotaArrayList = new ArrayList();
            kota_strarray = loadArray(provinsiprefrence, getActivity());
            kota_strarrayID = loadArray(provinsiidprefrence, getActivity());
            kotaArray = new ArrayList();
            kotaArray = new ArrayList(Arrays.asList(kota_strarray));
            kotaArrayID = new ArrayList();
            kotaArrayID = new ArrayList(Arrays.asList(kota_strarrayID));
            if (kotaArray.size() != 0)
            {
                Log.e("kotaArray", "1");
                ArrayAdapter arrayadapter = new ArrayAdapter(getActivity(), 0x1090003, kotaArray);
                listHp.addHeaderView(headerView);
                listHp.setAdapter(arrayadapter);
                layout_empty.setVisibility(8);
                listHp.setVisibility(0);
                listHp.setOnItemClickListener(new Hal1SCManual._cls3._cls1());
            } else
            {
                listOperatorAdapter = new ListOperatorAdapter(getActivity(), 0x7f03006e, listKotaArrayList);
                listHp.addHeaderView(headerView);
                listHp.setAdapter(listOperatorAdapter);
                (new Hal1SCManual.KotaSync(Hal1SCManual.this, null)).execute(new String[] {
                    (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("tinggal_kota").append(Utility.BASE_FORMAT).append("?provinsi_id=").append(provinsi_id).append("&t=").append(t).toString()
                });
                listHp.setOnItemClickListener(new Hal1SCManual._cls3._cls2());
            }
            dialog = view.create();
            dialog.show();
            btnAbaikan.setOnClickListener(new Hal1SCManual._cls3._cls3());
        }


            
            {
                this$0 = Hal1SCManual.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/servicenter/Hal1SCManual$3$1

/* anonymous class */
        class Hal1SCManual._cls3._cls1
            implements android.widget.AdapterView.OnItemClickListener
        {

            final Hal1SCManual._cls3 this$1;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                adapterview = ((TextView)view).getText().toString();
                kota_id = kota_strarrayID[i - 1];
                kotaProfile = adapterview;
                btnSCPencKota.setText(kotaProfile);
                dialog.dismiss();
            }

                    
                    {
                        this$1 = Hal1SCManual._cls3.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/servicenter/Hal1SCManual$3$3

/* anonymous class */
        class Hal1SCManual._cls3._cls3
            implements android.view.View.OnClickListener
        {

            final Hal1SCManual._cls3 this$1;

            public void onClick(View view)
            {
                kota_id = "nil";
                btnSCPencKota.setText((new StringBuilder("Seluruh kota di ")).append(provinsiProfile).toString());
                dialog.dismiss();
            }

                    
                    {
                        this$1 = Hal1SCManual._cls3.this;
                        super();
                    }
        }

    }

}
