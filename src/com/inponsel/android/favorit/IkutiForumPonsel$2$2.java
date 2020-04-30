// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.favorit;

import android.app.Dialog;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.inponsel.android.utils.DelayedTextWatcher;
import com.inponsel.android.utils.Log;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

// Referenced classes of package com.inponsel.android.favorit:
//            IkutiForumPonsel

class t> extends DelayedTextWatcher
{

    final ce this$1;

    public void afterTextChangedDelayed(Editable editable)
    {
        if (edtAuto.getText().toString().length() < 2) goto _L2; else goto _L1
_L1:
        progressbar_search.setVisibility(0);
        editable = edtAuto.getText().toString();
        String s = URLEncoder.encode(editable, "utf-8");
        editable = s;
_L4:
        FavoritSearchTask(editable);
_L2:
        return;
        UnsupportedEncodingException unsupportedencodingexception;
        unsupportedencodingexception;
        unsupportedencodingexception.printStackTrace();
        if (true) goto _L4; else goto _L3
_L3:
    }

    is._cls0(long l)
    {
        this$1 = this._cls1.this;
        super(l);
    }

    // Unreferenced inner class com/inponsel/android/favorit/IkutiForumPonsel$2

/* anonymous class */
    class IkutiForumPonsel._cls2
        implements android.view.View.OnClickListener
    {

        final IkutiForumPonsel this$0;

        public void onClick(View view)
        {
            Log.e("click", "custom dialog");
            view = getLayoutInflater().inflate(0x7f030025, null);
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(wrapperLight);
            builder.setView(view);
            edtAuto = (EditText)view.findViewById(0x7f0b008d);
            listFindDev = (ListView)view.findViewById(0x7f0b008f);
            if (android.os.Build.VERSION.SDK_INT < 13)
            {
                edtAuto.setTextColor(-1);
                listFindDev.setBackgroundColor(-1);
            }
            progressbar_search = (ProgressBar)view.findViewById(0x7f0b008e);
            progressbar_search.setVisibility(8);
            listSearchArrayList = new ArrayList();
            listSearchAdapter = new IkutiForumPonsel.ListSearchAdapter(IkutiForumPonsel.this, IkutiForumPonsel.this, 0x7f0300c2, listSearchArrayList);
            listFindDev.setAdapter(listSearchAdapter);
            edtAuto.setSingleLine(true);
            edtAuto.setOnEditorActionListener(new IkutiForumPonsel._cls2._cls1());
            edtAuto.addTextChangedListener(new IkutiForumPonsel._cls2._cls2(2000L));
            dialog = builder.create();
            dialog.show();
        }


            
            {
                this$0 = IkutiForumPonsel.this;
                super();
            }

        // Unreferenced inner class com/inponsel/android/favorit/IkutiForumPonsel$2$1

/* anonymous class */
        class IkutiForumPonsel._cls2._cls1
            implements android.widget.TextView.OnEditorActionListener
        {

            final IkutiForumPonsel._cls2 this$1;

            public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
            {
                boolean flag = false;
                if (i != 3) goto _L2; else goto _L1
_L1:
                if (edtAuto.getText().toString().length() < 2) goto _L4; else goto _L3
_L3:
                progressbar_search.setVisibility(0);
                textview = edtAuto.getText().toString();
                keyevent = URLEncoder.encode(textview, "utf-8");
                textview = keyevent;
_L6:
                FavoritSearchTask(textview);
_L4:
                flag = true;
_L2:
                return flag;
                keyevent;
                keyevent.printStackTrace();
                if (true) goto _L6; else goto _L5
_L5:
            }

                    
                    {
                        this$1 = IkutiForumPonsel._cls2.this;
                        super();
                    }
        }

    }

}
