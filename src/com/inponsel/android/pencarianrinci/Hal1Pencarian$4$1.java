// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.pencarianrinci;

import android.app.Dialog;
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
import com.inponsel.android.adapter.ListMerkAdapter;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import java.util.ArrayList;
import java.util.Arrays;

// Referenced classes of package com.inponsel.android.pencarianrinci:
//            Hal1Pencarian

class this._cls1
    implements android.widget.ClickListener
{

    final log this$1;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = ((TextView)view).getText().toString();
        btnPencModel.setText(adapterview);
        Hal1Pencarian.strPencModel = model_hpID[i - 1];
        Log.e("model_hpID", model_hpID[i - 1]);
        mDialog.dismiss();
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/pencarianrinci/Hal1Pencarian$4

/* anonymous class */
    class Hal1Pencarian._cls4
        implements android.view.View.OnClickListener
    {

        final Hal1Pencarian this$0;

        public void onClick(View view)
        {
            View view1 = getActivity().getLayoutInflater().inflate(0x7f0300a4, null);
            view = new android.app.AlertDialog.Builder(getActivity());
            view.setView(view1);
            view.setTitle("Pilih Model :");
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
            model_hp = loadArray("modelArray", getActivity().getApplicationContext());
            model_hpID = loadArray("modelArrayID", getActivity().getApplicationContext());
            modelArray = new ArrayList(Arrays.asList(model_hp));
            modelArrayID = new ArrayList(Arrays.asList(model_hpID));
            Log.e("modelArray", String.valueOf(modelArray.size()));
            if (modelArray.size() != 0)
            {
                Log.e("modelArray", "1");
                ArrayAdapter arrayadapter = new ArrayAdapter(getActivity(), 0x1090003, modelArray);
                listHp.addHeaderView(headerView);
                listHp.setAdapter(arrayadapter);
                layout_empty.setVisibility(8);
                listHp.setVisibility(0);
                listHp.setOnItemClickListener(new Hal1Pencarian._cls4._cls1());
            } else
            {
                listMerkAdapter = new ListMerkAdapter(getActivity(), 0x7f03006e, listProvArrayList);
                listHp.addHeaderView(headerView);
                listHp.setAdapter(listMerkAdapter);
                (new Hal1Pencarian.ModelSync(Hal1Pencarian.this, null)).execute(new String[] {
                    (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("daftar_model").append(Utility.BASE_FORMAT).append("?t=").append(t).toString()
                });
                listHp.setOnItemClickListener(new Hal1Pencarian._cls4._cls2());
            }
            btnAbaikan.setOnClickListener(new Hal1Pencarian._cls4._cls3());
            mDialog = view.create();
            mDialog.show();
        }


            
            {
                this$0 = Hal1Pencarian.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/pencarianrinci/Hal1Pencarian$4$2

/* anonymous class */
        class Hal1Pencarian._cls4._cls2
            implements android.widget.AdapterView.OnItemClickListener
        {

            final Hal1Pencarian._cls4 this$1;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                Hal1Pencarian.strPencModel = listMerkAdapter.getListModel(i - 1).getId_merk().toString();
                btnPencModel.setText(listMerkAdapter.getListModel(i - 1).getMerk().toString());
                mDialog.dismiss();
            }

                    
                    {
                        this$1 = Hal1Pencarian._cls4.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/pencarianrinci/Hal1Pencarian$4$3

/* anonymous class */
        class Hal1Pencarian._cls4._cls3
            implements android.view.View.OnClickListener
        {

            final Hal1Pencarian._cls4 this$1;

            public void onClick(View view)
            {
                Hal1Pencarian.strPencModel = "nil";
                btnPencModel.setText("Abaikan");
                mDialog.dismiss();
            }

                    
                    {
                        this$1 = Hal1Pencarian._cls4.this;
                        super();
                    }
        }

    }

}
