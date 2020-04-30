// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

// Referenced classes of package com.inponsel.android.details:
//            PilihPonselBanding

class this._cls0
    implements android.view.PonselBanding._cls5
{

    final PilihPonselBanding this$0;

    public void onClick(View view)
    {
        btnMemuatLagi.setVisibility(8);
        setProgressBarIndeterminateVisibility(true);
        setProgressBarVisibility(true);
        if (cm.getActiveNetworkInfo() == null || !cm.getActiveNetworkInfo().isAvailable() || !cm.getActiveNetworkInfo().isConnected()) goto _L2; else goto _L1
_L1:
        view = edtAuto.getText().toString();
        String s = URLEncoder.encode(view, "utf-8");
        view = s;
_L3:
        PilihPonselBanding pilihponselbanding = PilihPonselBanding.this;
        pilihponselbanding.limit = pilihponselbanding.limit + 20;
        dataSearchMore = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("pencarian_ponsel").append(Utility.BASE_FORMAT).append("?idusr=").append(user_id).append("&key=").append(view).append("&lmt=").append(limit).append("&t=").append(t).toString();
        Log.e("data", dataSearchMore);
        SearchMoreTask();
        return;
        UnsupportedEncodingException unsupportedencodingexception;
        unsupportedencodingexception;
        unsupportedencodingexception.printStackTrace();
        if (true) goto _L3; else goto _L2
_L2:
        setProgressBarIndeterminateVisibility(false);
        setProgressBarVisibility(false);
        Toast.makeText(PilihPonselBanding.this, getString(0x7f0c005a), 0).show();
        return;
    }

    ()
    {
        this$0 = PilihPonselBanding.this;
        super();
    }
}
