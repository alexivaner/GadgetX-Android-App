// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.app.Dialog;
import android.text.Editable;
import android.text.TextWatcher;
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
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

// Referenced classes of package com.inponsel.android.v2:
//            RegisterActivity

class this._cls1
    implements TextWatcher
{

    final kTrace this$1;

    public void afterTextChanged(Editable editable)
    {
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        String s;
        UnsupportedEncodingException unsupportedencodingexception;
        try
        {
            if (edtAuto.getText().toString().trim().length() == 0)
            {
                txtEmpty.setText("Masukan ponsel yang ingin dicari");
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (CharSequence charsequence)
        {
            return;
        }
        progressbar_search.setVisibility(0);
        charsequence = edtAuto.getText().toString();
        s = URLEncoder.encode(charsequence, "utf-8");
        charsequence = s;
_L1:
        (new hHpSync(_fld0, null)).execute(new String[] {
            (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("home_search").append(Utility.BASE_FORMAT).append("?lmt=0&key=").append(charsequence).append("&t=").append(t).toString()
        });
        return;
        unsupportedencodingexception;
        unsupportedencodingexception.printStackTrace();
          goto _L1
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/inponsel/android/v2/RegisterActivity$13

/* anonymous class */
    class RegisterActivity._cls13
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
            edtHpKetik = (EditText)view.findViewById(0x7f0b0094);
            btnSubmitHp = (Button)view.findViewById(0x7f0b0095);
            edtAuto = (EditText)view.findViewById(0x7f0b008d);
            listHp = (ListView)view.findViewById(0x7f0b008f);
            progressbar_search = (ProgressBar)view.findViewById(0x7f0b008e);
            txtEmpty = (TextView)view.findViewById(0x7f0b0093);
            txtEmpty.setText("Masukkan ponsel yang dicari");
            if (android.os.Build.VERSION.SDK_INT < 13)
            {
                edtAuto.setTextColor(-1);
                listHp.setBackgroundColor(-1);
            }
            listArrayList = new ArrayList();
            listAdapter = new ListAdapter(RegisterActivity.this, 0x7f03006e, listArrayList);
            listHp.setAdapter(listAdapter);
            edtAuto.addTextChangedListener(new RegisterActivity._cls13._cls1());
            listHp.setOnItemClickListener(new RegisterActivity._cls13._cls2());
            btnSubmitHp.setOnClickListener(new RegisterActivity._cls13._cls3());
            dialog = builder.create();
            dialog.show();
        }


            
            {
                this$0 = RegisterActivity.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/v2/RegisterActivity$13$2

/* anonymous class */
        class RegisterActivity._cls13._cls2
            implements android.widget.AdapterView.OnItemClickListener
        {

            final RegisterActivity._cls13 this$1;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(edtAuto.getWindowToken(), 0);
                namaHp2 = listAdapter.getListModel(i).getNamalengkap().toString();
                Log.e("namahp", namaHp2);
                btnHpDigunakan2.setText(namaHp2);
                hpPengguna2 = namaHp2;
                dialog.dismiss();
            }

                    
                    {
                        this$1 = RegisterActivity._cls13.this;
                        super();
                    }
        }


        // Unreferenced inner class com/inponsel/android/v2/RegisterActivity$13$3

/* anonymous class */
        class RegisterActivity._cls13._cls3
            implements android.view.View.OnClickListener
        {

            final RegisterActivity._cls13 this$1;

            public void onClick(View view)
            {
                ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(edtAuto.getWindowToken(), 0);
                hpPengguna2 = edtHpKetik.getText().toString();
                btnHpDigunakan2.setText(hpPengguna2);
                dialog.dismiss();
            }

                    
                    {
                        this$1 = RegisterActivity._cls13.this;
                        super();
                    }
        }

    }

}