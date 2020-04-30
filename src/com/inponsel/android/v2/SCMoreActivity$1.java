// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.app.Dialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
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
import com.actionbarsherlock.ActionBarSherlock;
import com.inponsel.android.adapter.ListMerkAdapter;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.utils.Connectivity;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;

// Referenced classes of package com.inponsel.android.v2:
//            SCMoreActivity

class this._cls0
    implements android.view.ner
{

    final SCMoreActivity this$0;

    public void onClick(View view)
    {
        if (cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isAvailable() && cm.getActiveNetworkInfo().isConnected())
        {
            View view1 = getLayoutInflater().inflate(0x7f0300a4, null);
            view = new android.app.er(SCMoreActivity.this);
            view.setView(view1);
            view.setTitle("Pilih Merek :");
            layout_empty = (LinearLayout)view1.findViewById(0x7f0b0091);
            listHp = (ListView)view1.findViewById(0x7f0b008f);
            if (android.os._INT < 13)
            {
                listHp.setBackgroundColor(-1);
            }
            progressbar_middle_dialog = (ProgressBar)view1.findViewById(0x7f0b0092);
            txtEmpty = (TextView)view1.findViewById(0x7f0b0093);
            txtEmpty.setText(0x7f0c0053);
            listProvArrayList = new ArrayList();
            merk_hp = loadArray("merkArray", getApplicationContext().getApplicationContext());
            merk_hpID = loadArray("merkArrayID", getApplicationContext().getApplicationContext());
            merkArray = new ArrayList();
            merkArray = new ArrayList(Arrays.asList(merk_hp));
            merkArrayID = new ArrayList();
            merkArrayID = new ArrayList(Arrays.asList(merk_hpID));
            Log.e("merkArray", String.valueOf(merkArray.size()));
            if (merkArray.size() != 0)
            {
                Log.e("merkArray", "1");
                ArrayAdapter arrayadapter = new ArrayAdapter(SCMoreActivity.this, 0x1090003, merkArray);
                listHp.setAdapter(arrayadapter);
                layout_empty.setVisibility(8);
                listHp.setVisibility(0);
                listHp.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

                    final SCMoreActivity._cls1 this$1;

                    public void onItemClick(AdapterView adapterview, View view2, int i, long l)
                    {
                        adapterview = ((TextView)view2).getText().toString();
                        btnPencMerek.setText(adapterview);
                        strPencMerek = merk_hpID[i];
                        Log.e("merk_hpID", merk_hpID[i]);
                        if (Connectivity.isConnectedWifi(this$0))
                        {
                            try
                            {
                                dataSearch = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("servicenter").append(Utility.BASE_FORMAT).append("?idm=").append(strPencMerek).append("&key=").append(URLEncoder.encode(strKey, "utf-8")).append("&lmt=0&t=").append(t).toString();
                                SCMoreActivity.access$0(this$0).setProgressBarIndeterminateVisibility(true);
                                SCMoreActivity.access$0(this$0).setProgressBarVisibility(true);
                            }
                            // Misplaced declaration of an exception variable
                            catch (AdapterView adapterview) { }
                            SearchTask();
                        }
                        mDialog.dismiss();
                    }

            
            {
                this$1 = SCMoreActivity._cls1.this;
                super();
            }
                });
            } else
            {
                listMerkAdapter = new ListMerkAdapter(SCMoreActivity.this, 0x7f03006e, listProvArrayList);
                listHp.setAdapter(listMerkAdapter);
                (new ovinsiSync(SCMoreActivity.this, null)).execute(new String[] {
                    (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("daftar_merk").append(Utility.BASE_FORMAT).append("?t=").append(t).toString()
                });
                listHp.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

                    final SCMoreActivity._cls1 this$1;

                    public void onItemClick(AdapterView adapterview, View view2, int i, long l)
                    {
                        strPencMerek = listMerkAdapter.getListModel(i - 1).getId_merk().toString();
                        btnPencMerek.setText(listMerkAdapter.getListModel(i - 1).getMerk().toString());
                        if (Connectivity.isConnectedWifi(this$0))
                        {
                            dataSearch = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("servicenter").append(Utility.BASE_FORMAT).append("?idm=").append(strPencMerek).append("&key=").append("&lmt=0&t=").append(t).toString();
                            SCMoreActivity.access$0(this$0).setProgressBarIndeterminateVisibility(true);
                            SCMoreActivity.access$0(this$0).setProgressBarVisibility(true);
                            SearchTask();
                        }
                    }

            
            {
                this$1 = SCMoreActivity._cls1.this;
                super();
            }
                });
            }
            mDialog = view.create();
            mDialog.show();
            return;
        } else
        {
            Toast.makeText(getApplicationContext(), 0x7f0c0059, 0).show();
            return;
        }
    }


    _cls2.this._cls1()
    {
        this$0 = SCMoreActivity.this;
        super();
    }
}
