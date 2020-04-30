// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.Editable;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.actionbarsherlock.ActionBarSherlock;
import com.inponsel.android.utils.DelayedTextWatcher;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

// Referenced classes of package com.inponsel.android.v2:
//            SCMoreActivity

class cher extends DelayedTextWatcher
{

    final SCMoreActivity this$0;

    public void afterTextChangedDelayed(Editable editable)
    {
        if (edtAuto.getText().toString().trim().length() == 0)
        {
            layout_empty_sc.setVisibility(8);
            listPencarianHp.setVisibility(0);
            return;
        }
        if (cm.getActiveNetworkInfo() == null || !cm.getActiveNetworkInfo().isAvailable() || !cm.getActiveNetworkInfo().isConnected()) goto _L2; else goto _L1
_L1:
        txt_empty_sc.setText(0x7f0c0053);
        editable = edtAuto.getText().toString();
        String s = URLEncoder.encode(editable, "utf-8");
        editable = s;
_L3:
        Log.e("key", editable);
        dataSearch = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("servicenter").append(Utility.BASE_FORMAT).append("?idm=").append(strPencMerek).append("&key=").append(editable).append("&lmt=0&t=").append(t).toString();
        Log.e("dataSearch", dataSearch);
        SCMoreActivity.access$0(SCMoreActivity.this).setProgressBarIndeterminateVisibility(true);
        SCMoreActivity.access$0(SCMoreActivity.this).setProgressBarVisibility(true);
        SearchTask();
        return;
        UnsupportedEncodingException unsupportedencodingexception;
        unsupportedencodingexception;
        unsupportedencodingexception.printStackTrace();
        if (true) goto _L3; else goto _L2
_L2:
        Toast.makeText(getApplicationContext(), 0x7f0c0059, 0).show();
        return;
    }

    cher(long l)
    {
        this$0 = SCMoreActivity.this;
        super(l);
    }
}
