// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.servicenter;

import android.app.Dialog;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.inponsel.android.adapter.ListMerkAdapter;
import com.inponsel.android.adapter.ListModel;
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
        adapterview = ((TextView)view).getText().toString();
        btnSCPencMerek.setText(adapterview);
        strPencMerek = merk_hpID[i - 1];
        Log.e("merk_hpID", merk_hpID[i - 1]);
        dialog.dismiss();
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/servicenter/Hal1SCManual$1

/* anonymous class */
    class Hal1SCManual._cls1
        implements android.view.View.OnClickListener
    {

        final Hal1SCManual this$0;

        public void onClick(View view)
        {
            if (cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isAvailable() && cm.getActiveNetworkInfo().isConnected())
            {
                View view1 = getActivity().getLayoutInflater().inflate(0x7f0300a4, null);
                view = new android.app.AlertDialog.Builder(getActivity());
                view.setView(view1);
                view.setTitle("Pilih Merek :");
                layout_empty = (LinearLayout)view1.findViewById(0x7f0b0091);
                listHp = (ListView)view1.findViewById(0x7f0b008f);
                if (android.os.Build.VERSION.SDK_INT < 13)
                {
                    listHp.setBackgroundColor(-1);
                }
                progressbar_middle_dialog = (ProgressBar)view1.findViewById(0x7f0b0092);
                txtEmpty = (TextView)view1.findViewById(0x7f0b0093);
                txtEmpty.setText(0x7f0c0053);
                btnAbaikan.setText("Seluruh merek ponsel");
                listMerkArrayList = new ArrayList();
                merk_hp = loadArray("merkArray", getActivity());
                merk_hpID = loadArray("merkArrayID", getActivity());
                merkArray = new ArrayList();
                merkArray = new ArrayList(Arrays.asList(merk_hp));
                merkArrayID = new ArrayList();
                merkArrayID = new ArrayList(Arrays.asList(merk_hpID));
                Log.e("merkArray", String.valueOf(merkArray.size()));
                if (merkArray.size() != 0)
                {
                    Log.e("merkArray", "1");
                    ArrayAdapter arrayadapter = new ArrayAdapter(getActivity(), 0x1090003, merkArray);
                    listHp.addHeaderView(headerView);
                    listHp.setAdapter(arrayadapter);
                    layout_empty.setVisibility(8);
                    listHp.setVisibility(0);
                    listHp.setOnItemClickListener(new Hal1SCManual._cls1._cls1());
                } else
                {
                    listMerkAdapter = new ListMerkAdapter(getActivity(), 0x7f03006e, listMerkArrayList);
                    listHp.addHeaderView(headerView);
                    listHp.setAdapter(listMerkAdapter);
                    (new Hal1SCManual.MerkSync(Hal1SCManual.this, null)).execute(new String[] {
                        (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("daftar_merk").append(Utility.BASE_FORMAT).append("?t=").append(t).toString()
                    });
                    listHp.setOnItemClickListener(new Hal1SCManual._cls1._cls2());
                }
                dialog = view.create();
                dialog.show();
            } else
            {
                Toast.makeText(getActivity(), 0x7f0c0059, 0).show();
            }
            btnAbaikan.setOnClickListener(new Hal1SCManual._cls1._cls3());
        }


            
            {
                this$0 = Hal1SCManual.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/servicenter/Hal1SCManual$1$2

/* anonymous class */
        class Hal1SCManual._cls1._cls2
            implements android.widget.AdapterView.OnItemClickListener
        {

            final Hal1SCManual._cls1 this$1;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                strPencMerek = listMerkAdapter.getListModel(i - 1).getId_merk().toString();
                btnSCPencMerek.setText(listMerkAdapter.getListModel(i - 1).getMerk().toString());
                dialog.dismiss();
            }

                    
                    {
                        this$1 = Hal1SCManual._cls1.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/servicenter/Hal1SCManual$1$3

/* anonymous class */
        class Hal1SCManual._cls1._cls3
            implements android.view.View.OnClickListener
        {

            final Hal1SCManual._cls1 this$1;

            public void onClick(View view)
            {
                btnSCPencMerek.setText("Seluruh merek ponsel");
                strPencMerek = "nil";
                dialog.dismiss();
            }

                    
                    {
                        this$1 = Hal1SCManual._cls1.this;
                        super();
                    }
        }

    }

}
