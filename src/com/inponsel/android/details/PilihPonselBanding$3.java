// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.Editable;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.inponsel.android.utils.DelayedTextWatcher;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

// Referenced classes of package com.inponsel.android.details:
//            PilihPonselBanding

class t> extends DelayedTextWatcher
{

    final PilihPonselBanding this$0;

    public void afterTextChangedDelayed(Editable editable)
    {
        if (edtAuto.getText().toString().trim().length() == 0)
        {
            txtEmpty.setText("Masukan ponsel yang ingin dibandingkan");
            return;
        }
        if (cm.getActiveNetworkInfo() == null || !cm.getActiveNetworkInfo().isAvailable() || !cm.getActiveNetworkInfo().isConnected()) goto _L2; else goto _L1
_L1:
        layout_empty.setVisibility(0);
        editable = edtAuto.getText().toString();
        String s = URLEncoder.encode(editable, "utf-8");
        editable = s;
_L3:
        progressbar_middle.setVisibility(0);
        txtEmpty.setText(0x7f0c0053);
        dataSearch = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("pencarian_ponsel").append(Utility.BASE_FORMAT).append("?key=").append(editable).append("&lmt=0&t=").append(t).append("&idusr=").append(user_id).toString();
        SearchTask();
        return;
        UnsupportedEncodingException unsupportedencodingexception;
        unsupportedencodingexception;
        unsupportedencodingexception.printStackTrace();
        if (true) goto _L3; else goto _L2
_L2:
        Toast.makeText(PilihPonselBanding.this, 0x7f0c0059, 0).show();
        return;
    }

    (long l)
    {
        this$0 = PilihPonselBanding.this;
        super(l);
    }
}
