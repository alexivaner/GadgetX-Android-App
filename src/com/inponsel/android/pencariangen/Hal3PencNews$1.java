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
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

// Referenced classes of package com.inponsel.android.pencariangen:
//            Hal3PencNews

class it> extends DelayedTextWatcher
{

    final Hal3PencNews this$0;

    public void afterTextChangedDelayed(Editable editable)
    {
label0:
        {
            if (edtAuto.getText().toString().trim().length() != 0)
            {
                if (cm.getActiveNetworkInfo() == null || !cm.getActiveNetworkInfo().isAvailable() || !cm.getActiveNetworkInfo().isConnected())
                {
                    break label0;
                }
                key = edtAuto.getText().toString();
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
                limit = 1;
                SearchTask();
            }
            return;
        }
        Toast.makeText(getActivity(), 0x7f0c0059, 0).show();
    }

    (long l)
    {
        this$0 = Hal3PencNews.this;
        super(l);
    }
}
