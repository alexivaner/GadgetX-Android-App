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
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

// Referenced classes of package com.inponsel.android.pencariangen:
//            Hal4PencUser

class this._cls0
    implements android.view.tener
{

    final Hal4PencUser this$0;

    public void onClick(View view)
    {
        btnMemuatLagi.setVisibility(8);
        if (cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isAvailable() && cm.getActiveNetworkInfo().isConnected())
        {
            view = edtAuto.getText().toString();
            try
            {
                URLEncoder.encode(view, "utf-8");
            }
            // Misplaced declaration of an exception variable
            catch (View view)
            {
                view.printStackTrace();
            }
            view = Hal4PencUser.this;
            view.limit = ((Hal4PencUser) (view)).limit + 15;
            Log.e("data", dataSearch);
            SearchTask();
            return;
        } else
        {
            Toast.makeText(getActivity(), getString(0x7f0c005a), 0).show();
            return;
        }
    }

    ()
    {
        this$0 = Hal4PencUser.this;
        super();
    }
}