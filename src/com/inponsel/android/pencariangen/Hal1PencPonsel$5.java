// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.pencariangen;

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

// Referenced classes of package com.inponsel.android.pencariangen:
//            Hal1PencPonsel

class this._cls0
    implements android.view.ner
{

    final Hal1PencPonsel this$0;

    public void onClick(View view)
    {
        btnMemuatLagi.setVisibility(8);
        if (cm.getActiveNetworkInfo() == null || !cm.getActiveNetworkInfo().isAvailable() || !cm.getActiveNetworkInfo().isConnected()) goto _L2; else goto _L1
_L1:
        view = edtAuto.getText().toString();
        String s = URLEncoder.encode(view, "utf-8");
        view = s;
_L3:
        Hal1PencPonsel hal1pencponsel = Hal1PencPonsel.this;
        hal1pencponsel.page = hal1pencponsel.page + 1;
        dataSearch = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("search_hp").append(Utility.BASE_FORMAT).append("?idusr=").append(user_id).append("&kat=1").append("&key=").append(view).append("&page=").append(page).append("&t=").append(t).toString();
        Log.e("data", dataSearch);
        SearchTask();
        return;
        UnsupportedEncodingException unsupportedencodingexception;
        unsupportedencodingexception;
        unsupportedencodingexception.printStackTrace();
        if (true) goto _L3; else goto _L2
_L2:
        Toast.makeText(getActivity(), getString(0x7f0c005a), 0).show();
        return;
    }

    ()
    {
        this$0 = Hal1PencPonsel.this;
        super();
    }
}
