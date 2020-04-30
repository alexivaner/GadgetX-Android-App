// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.pencarianrinci;

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

// Referenced classes of package com.inponsel.android.pencarianrinci:
//            Hal1Pencarian

class this._cls0
    implements android.view.ener
{

    final Hal1Pencarian this$0;

    public void onClick(View view)
    {
        if (cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isAvailable() && cm.getActiveNetworkInfo().isConnected())
        {
            View view1 = getActivity().getLayoutInflater().inflate(0x7f0300a4, null);
            view = new android.app.der(getActivity());
            view.setView(view1);
            view.setTitle("Pilih Merek :");
            layout_empty = (LinearLayout)view1.findViewById(0x7f0b0091);
            listHp = (ListView)view1.findViewById(0x7f0b008f);
            if (android.os.K_INT < 13)
            {
                listHp.setBackgroundColor(-1);
            }
            progressbar_middle_dialog = (ProgressBar)view1.findViewById(0x7f0b0092);
            txtEmpty = (TextView)view1.findViewById(0x7f0b0093);
            txtEmpty.setText(0x7f0c0053);
            listProvArrayList = new ArrayList();
            merk_hp = loadArray("merkArray", getActivity().getApplicationContext());
            merk_hpID = loadArray("merkArrayID", getActivity().getApplicationContext());
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
                listHp.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

                    final Hal1Pencarian._cls1 this$1;

                    public void onItemClick(AdapterView adapterview, View view2, int i, long l)
                    {
                        adapterview = ((TextView)view2).getText().toString();
                        btnPencMerek.setText(adapterview);
                        Hal1Pencarian.strPencMerek = merk_hpID[i - 1];
                        Log.e("merk_hpID", merk_hpID[i - 1]);
                        if (btnPencMerek.getText().toString().contains("Apple"))
                        {
                            btnPencSistem.setEnabled(false);
                            btnPencSistem.setText("iOS");
                            Hal1Pencarian.strPencSistem = "5";
                            Log.e("strPencSistem", Hal1Pencarian.strPencSistem);
                        } else
                        if (btnPencMerek.getText().toString().contains("BlackBerry"))
                        {
                            btnPencSistem.setEnabled(false);
                            btnPencSistem.setText("BlackBerry OS");
                            Hal1Pencarian.strPencSistem = "4";
                            Log.e("strPencSistem", Hal1Pencarian.strPencSistem);
                        } else
                        {
                            Log.e("strPencSistem", Hal1Pencarian.strPencSistem);
                            btnPencSistem.setEnabled(true);
                            Hal1Pencarian.strPencSistem = "nil";
                            btnPencSistem.setText("Abaikan");
                        }
                        mDialog.dismiss();
                    }

            
            {
                this$1 = Hal1Pencarian._cls1.this;
                super();
            }
                });
            } else
            {
                listMerkAdapter = new ListMerkAdapter(getActivity(), 0x7f03006e, listProvArrayList);
                listHp.addHeaderView(headerView);
                listHp.setAdapter(listMerkAdapter);
                (new rkSync(Hal1Pencarian.this, null)).execute(new String[] {
                    (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("daftar_merk").append(Utility.BASE_FORMAT).append("?t=").append(t).toString()
                });
                listHp.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

                    final Hal1Pencarian._cls1 this$1;

                    public void onItemClick(AdapterView adapterview, View view2, int i, long l)
                    {
                        Hal1Pencarian.strPencMerek = listMerkAdapter.getListModel(i - 1).getId_merk().toString();
                        btnPencMerek.setText(listMerkAdapter.getListModel(i - 1).getMerk().toString());
                        if (btnPencMerek.getText().toString().contains("Apple"))
                        {
                            btnPencSistem.setEnabled(false);
                            btnPencSistem.setText("iOS");
                            Hal1Pencarian.strPencSistem = "5";
                            Log.e("strPencSistem", Hal1Pencarian.strPencSistem);
                        } else
                        if (btnPencMerek.getText().toString().contains("BlackBerry"))
                        {
                            btnPencSistem.setEnabled(false);
                            btnPencSistem.setText("BlackBerry OS");
                            Hal1Pencarian.strPencSistem = "4";
                            Log.e("strPencSistem", Hal1Pencarian.strPencSistem);
                        } else
                        {
                            Log.e("strPencSistem", Hal1Pencarian.strPencSistem);
                            btnPencSistem.setEnabled(true);
                            Hal1Pencarian.strPencSistem = "nil";
                            btnPencSistem.setText("Abaikan");
                        }
                        mDialog.dismiss();
                    }

            
            {
                this$1 = Hal1Pencarian._cls1.this;
                super();
            }
                });
            }
            btnAbaikan.setOnClickListener(new android.view.View.OnClickListener() {

                final Hal1Pencarian._cls1 this$1;

                public void onClick(View view2)
                {
                    btnPencMerek.setText("Abaikan");
                    Hal1Pencarian.strPencSistem = "nil";
                    mDialog.dismiss();
                }

            
            {
                this$1 = Hal1Pencarian._cls1.this;
                super();
            }
            });
            mDialog = view.create();
            mDialog.show();
            return;
        } else
        {
            Toast.makeText(getActivity(), 0x7f0c0059, 0).show();
            return;
        }
    }


    _cls3.this._cls1()
    {
        this$0 = Hal1Pencarian.this;
        super();
    }
}
