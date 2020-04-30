// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.daftarharga;

import android.app.Dialog;
import android.os.AsyncTask;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.inponsel.android.adapter.ListMerkAdapter;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import java.util.ArrayList;
import java.util.Arrays;

// Referenced classes of package com.inponsel.android.daftarharga:
//            Hal1Preference

class this._cls1
    implements android.widget.lickListener
{

    final og this$1;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        Hal1Preference.os = listMerkAdapter.getListModel(i - 1).getId_merk().toString();
        edtOS.setText(listMerkAdapter.getListModel(i - 1).getMerk().toString());
        dialog.dismiss();
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/daftarharga/Hal1Preference$3

/* anonymous class */
    class Hal1Preference._cls3
        implements android.view.View.OnClickListener
    {

        final Hal1Preference this$0;

        public void onClick(View view)
        {
            ((InputMethodManager)getActivity().getSystemService("input_method")).hideSoftInputFromWindow(edtOS.getWindowToken(), 0);
            View view1 = getActivity().getLayoutInflater().inflate(0x7f0300a4, null);
            view = new android.app.AlertDialog.Builder(getActivity());
            view.setView(view1);
            view.setTitle("Pilih Sistem Operasi :");
            layout_empty = (LinearLayout)view1.findViewById(0x7f0b0091);
            listHp = (ListView)view1.findViewById(0x7f0b008f);
            if (android.os.Build.VERSION.SDK_INT < 13)
            {
                listHp.setBackgroundColor(-1);
            }
            progressbar_middle_dialog = (ProgressBar)view1.findViewById(0x7f0b0092);
            txtEmpty = (TextView)view1.findViewById(0x7f0b0093);
            txtEmpty.setText(0x7f0c0053);
            listProvArrayList = new ArrayList();
            os_hp = loadArray("osArray", getActivity().getApplicationContext());
            os_hpID = loadArray("osArrayID", getActivity().getApplicationContext());
            osArray = new ArrayList();
            osArray = new ArrayList(Arrays.asList(os_hp));
            osArrayID = new ArrayList();
            osArrayID = new ArrayList(Arrays.asList(os_hpID));
            Log.e("osArray", String.valueOf(osArray.size()));
            if (osArray.size() != 0)
            {
                Log.e("osArray", "1");
                ArrayAdapter arrayadapter = new ArrayAdapter(getActivity(), 0x1090003, osArray);
                listHp.addHeaderView(headerView);
                listHp.setAdapter(arrayadapter);
                layout_empty.setVisibility(8);
                listHp.setVisibility(0);
                listHp.setOnItemClickListener(new Hal1Preference._cls3._cls1());
            } else
            {
                listMerkAdapter = new ListMerkAdapter(getActivity(), 0x7f03006e, listProvArrayList);
                listHp.addHeaderView(headerView);
                listHp.setAdapter(listMerkAdapter);
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    (new Hal1Preference.OSSync(Hal1Preference.this, null)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[] {
                        (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("os_list").append(Utility.BASE_FORMAT).append("?t=").append(t).toString()
                    });
                } else
                {
                    (new Hal1Preference.OSSync(Hal1Preference.this, null)).execute(new String[] {
                        (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("os_list").append(Utility.BASE_FORMAT).append("?t=").append(t).toString()
                    });
                }
                listHp.setOnItemClickListener(new Hal1Preference._cls3._cls2());
            }
            btnAbaikan.setOnClickListener(new Hal1Preference._cls3._cls3());
            dialog = view.create();
            dialog.show();
        }


            
            {
                this$0 = Hal1Preference.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/daftarharga/Hal1Preference$3$1

/* anonymous class */
        class Hal1Preference._cls3._cls1
            implements android.widget.AdapterView.OnItemClickListener
        {

            final Hal1Preference._cls3 this$1;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                adapterview = ((TextView)view).getText().toString();
                edtOS.setText(adapterview);
                Hal1Preference.os = os_hpID[i - 1];
                Log.e("os_hpID", os_hpID[i - 1]);
                dialog.dismiss();
            }

                    
                    {
                        this$1 = Hal1Preference._cls3.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/daftarharga/Hal1Preference$3$3

/* anonymous class */
        class Hal1Preference._cls3._cls3
            implements android.view.View.OnClickListener
        {

            final Hal1Preference._cls3 this$1;

            public void onClick(View view)
            {
                edtOS.setText("Sistem Operasi : Abaikan");
                Hal1Preference.os = "000";
                dialog.dismiss();
            }

                    
                    {
                        this$1 = Hal1Preference._cls3.this;
                        super();
                    }
        }

    }

}
