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
//            RegisterActivity

class this._cls0
    implements android.view.
{

    final RegisterActivity this$0;

    public void onClick(View view)
    {
        View view1 = getLayoutInflater().inflate(0x7f030026, null);
        view = new android.app.<init>(wrapper);
        view.setView(view1);
        view.setTitle("Pilih Operator :");
        layout_empty = (LinearLayout)view1.findViewById(0x7f0b0091);
        edtAuto = (EditText)view1.findViewById(0x7f0b008d);
        edtAuto.setVisibility(8);
        listHp = (ListView)view1.findViewById(0x7f0b008f);
        if (android.os.T < 13)
        {
            listHp.setBackgroundColor(-1);
        }
        progressbar_search = (ProgressBar)view1.findViewById(0x7f0b008e);
        txtEmpty = (TextView)view1.findViewById(0x7f0b0093);
        txtEmpty.setText(0x7f0c0053);
        listOpArrayList = new ArrayList();
        provider_array = loadArray("providerArray", getApplicationContext());
        provider_arrayhpID = loadArray("providerArrayID", getApplicationContext());
        providerArray = new ArrayList();
        providerArray = new ArrayList(Arrays.asList(provider_array));
        providerArrayID = new ArrayList();
        providerArrayID = new ArrayList(Arrays.asList(provider_arrayhpID));
        Log.e("merkArray", String.valueOf(providerArray.size()));
        if (providerArray.size() != 0)
        {
            Log.e("merkArray", "1");
            ArrayAdapter arrayadapter = new ArrayAdapter(wrapper, 0x1090003, providerArray);
            listHp.setAdapter(arrayadapter);
            layout_empty.setVisibility(8);
            listHp.setVisibility(0);
            listHp.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

                final RegisterActivity._cls10 this$1;

                public void onItemClick(AdapterView adapterview, View view2, int i, long l)
                {
                    adapterview = ((TextView)view2).getText().toString();
                    provider2 = adapterview;
                    btnOperatorDigunakan2.setText(adapterview);
                    dialog.dismiss();
                }

            
            {
                this$1 = RegisterActivity._cls10.this;
                super();
            }
            });
        } else
        {
            listOperatorAdapter = new ListOperatorAdapter(RegisterActivity.this, 0x7f03006e, listOpArrayList);
            listHp.setAdapter(listOperatorAdapter);
            (new ratorSync(RegisterActivity.this, null)).execute(new String[] {
                (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("operator_inponsel").append(Utility.BASE_FORMAT).append("?t=").append(t).toString()
            });
            listHp.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

                final RegisterActivity._cls10 this$1;

                public void onItemClick(AdapterView adapterview, View view2, int i, long l)
                {
                    ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(edtAuto.getWindowToken(), 0);
                    provider2 = listOperatorAdapter.getListModel(i).getNm_op().toString();
                    Log.e("provider", provider2);
                    btnOperatorDigunakan2.setText(provider2);
                    dialog.dismiss();
                }

            
            {
                this$1 = RegisterActivity._cls10.this;
                super();
            }
            });
        }
        dialog = view.create();
        dialog.show();
    }


    _cls2.this._cls1()
    {
        this$0 = RegisterActivity.this;
        super();
    }
}
