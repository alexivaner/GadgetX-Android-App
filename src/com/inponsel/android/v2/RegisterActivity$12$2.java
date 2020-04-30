// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.app.Dialog;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.inponsel.android.adapter.ListAdapter;
import com.inponsel.android.adapter.ListModel;
import com.inponsel.android.utils.DelayedTextWatcher;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

// Referenced classes of package com.inponsel.android.v2:
//            RegisterActivity

class <init> extends DelayedTextWatcher
{

    final kTrace this$1;

    public void afterTextChangedDelayed(Editable editable)
    {
        if (edtAuto.getText().toString().trim().length() == 0)
        {
            txtEmpty.setText("Masukan ponsel yang ingin dicari");
            return;
        }
        progressbar_search.setVisibility(0);
        editable = edtAuto.getText().toString();
        String s = URLEncoder.encode(editable, "utf-8");
        editable = s;
_L2:
        (new hHpSync(_fld0, null)).execute(new String[] {
            (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("home_search").append(Utility.BASE_FORMAT).append("?lmt=0&key=").append(editable).append("&t=").append(t).toString()
        });
        return;
        UnsupportedEncodingException unsupportedencodingexception;
        unsupportedencodingexception;
        unsupportedencodingexception.printStackTrace();
        if (true) goto _L2; else goto _L1
_L1:
    }

    is._cls0(long l)
    {
        this$1 = this._cls1.this;
        super(l);
    }

    // Unreferenced inner class com/inponsel/android/v2/RegisterActivity$12

/* anonymous class */
    class RegisterActivity._cls12
        implements android.view.View.OnClickListener
    {

        final RegisterActivity this$0;

        public void onClick(View view)
        {
            Log.e("click", "custom dialog");
            view = getLayoutInflater().inflate(0x7f030026, null);
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(wrapper);
            builder.setView(view);
            builder.setTitle("Pilih Ponsel :");
            progressbar_middle_dialog = (ProgressBar)view.findViewById(0x7f0b0092);
            progressbar_middle_dialog.setVisibility(8);
            layout_empty = (LinearLayout)view.findViewById(0x7f0b0091);
            edtAuto = (EditText)view.findViewById(0x7f0b008d);
            edtHpKetik = (EditText)view.findViewById(0x7f0b0094);
            btnSubmitHp = (Button)view.findViewById(0x7f0b0095);
            listHp = (ListView)view.findViewById(0x7f0b008f);
            if (android.os.Build.VERSION.SDK_INT < 13)
            {
                edtAuto.setTextColor(-1);
                listHp.setBackgroundColor(-1);
            }
            progressbar_search = (ProgressBar)view.findViewById(0x7f0b008e);
            txtEmpty = (TextView)view.findViewById(0x7f0b0093);
            txtEmpty.setText("Masukkan ponsel yang dicari");
            listArrayList = new ArrayList();
            listAdapter = new ListAdapter(RegisterActivity.this, 0x7f03006e, listArrayList);
            listHp.setAdapter(listAdapter);
            edtAuto.setSingleLine(true);
            edtAuto.setOnEditorActionListener(new RegisterActivity._cls12._cls1());
            edtAuto.addTextChangedListener(new RegisterActivity._cls12._cls2(2000L));
            listHp.setOnItemClickListener(new RegisterActivity._cls12._cls3());
            btnSubmitHp.setOnClickListener(new RegisterActivity._cls12._cls4());
            dialog = builder.create();
            dialog.show();
        }


            
            {
                this$0 = RegisterActivity.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/v2/RegisterActivity$12$1

/* anonymous class */
        class RegisterActivity._cls12._cls1
            implements android.widget.TextView.OnEditorActionListener
        {

            final RegisterActivity._cls12 this$1;

            public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
            {
                if (i != 3) goto _L2; else goto _L1
_L1:
                if (edtAuto.getText().toString().trim().length() == 0)
                {
                    txtEmpty.setText("Masukan ponsel yang ingin dicari");
                    return true;
                }
                progressbar_search.setVisibility(0);
                textview = edtAuto.getText().toString();
                keyevent = URLEncoder.encode(textview, "utf-8");
                textview = keyevent;
_L3:
                (new RegisterActivity.SearchHpSync(this$0, null)).execute(new String[] {
                    (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("home_search").append(Utility.BASE_FORMAT).append("?lmt=0&key=").append(textview).append("&t=").append(t).toString()
                });
                return true;
                keyevent;
                keyevent.printStackTrace();
                if (true) goto _L3; else goto _L2
_L2:
                return false;
            }

                    
                    {
                        this$1 = RegisterActivity._cls12.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/v2/RegisterActivity$12$3

/* anonymous class */
        class RegisterActivity._cls12._cls3
            implements android.widget.AdapterView.OnItemClickListener
        {

            final RegisterActivity._cls12 this$1;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(edtAuto.getWindowToken(), 0);
                namaHp = listAdapter.getListModel(i).getNamalengkap().toString();
                Log.e("namahp", namaHp);
                btnHpDigunakan.setText(namaHp);
                hpPengguna = namaHp;
                dialog.dismiss();
            }

                    
                    {
                        this$1 = RegisterActivity._cls12.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/v2/RegisterActivity$12$4

/* anonymous class */
        class RegisterActivity._cls12._cls4
            implements android.view.View.OnClickListener
        {

            final RegisterActivity._cls12 this$1;

            public void onClick(View view)
            {
                ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(edtAuto.getWindowToken(), 0);
                hpPengguna = edtHpKetik.getText().toString();
                btnHpDigunakan.setText(hpPengguna);
                dialog.dismiss();
            }

                    
                    {
                        this$1 = RegisterActivity._cls12.this;
                        super();
                    }
        }

    }

}
