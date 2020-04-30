// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.pencariangen;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.Editable;
import android.widget.EditText;
import android.widget.Toast;
import com.inponsel.android.utils.DelayedTextWatcher;
import com.inponsel.android.utils.Log;
import com.inponsel.android.widget.ExpandableHeightGridView;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

// Referenced classes of package com.inponsel.android.pencariangen:
//            Hal2PencSC

class init> extends DelayedTextWatcher
{

    final Hal2PencSC this$0;

    public void afterTextChangedDelayed(Editable editable)
    {
        if (edtAutoSC.getText().toString().trim().length() == 0)
        {
            listSCManual.setVisibility(0);
            return;
        }
        if (cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isAvailable() && cm.getActiveNetworkInfo().isConnected())
        {
            key = edtAutoSC.getText().toString();
            try
            {
                key = URLEncoder.encode(key, "utf-8");
            }
            // Misplaced declaration of an exception variable
            catch (Editable editable)
            {
                editable.printStackTrace();
            }
            Log.e("key", key);
            limit = 0;
            SearchTask();
            return;
        } else
        {
            Toast.makeText(getActivity(), 0x7f0c0059, 0).show();
            return;
        }
    }

    dView(long l)
    {
        this$0 = Hal2PencSC.this;
        super(l);
    }
}
