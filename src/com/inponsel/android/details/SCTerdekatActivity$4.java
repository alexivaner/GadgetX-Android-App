// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.Editable;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.inponsel.android.utils.ExpandedListView;
import com.inponsel.android.utils.Log;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

// Referenced classes of package com.inponsel.android.details:
//            SCTerdekatActivity

class this._cls0
    implements android.widget.onListener
{

    final SCTerdekatActivity this$0;

    public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
    {
        if (edtAutoSC.getText().toString().trim().length() == 0)
        {
            listSCManual.setVisibility(0);
            return false;
        }
        if (cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isAvailable() && cm.getActiveNetworkInfo().isConnected())
        {
            key = edtAutoSC.getText().toString();
            try
            {
                key = URLEncoder.encode(key, "utf-8");
            }
            // Misplaced declaration of an exception variable
            catch (TextView textview)
            {
                textview.printStackTrace();
            }
            Log.e("key", key);
            setProgressBarIndeterminateVisibility(true);
            setProgressBarVisibility(true);
            SearchTask();
            return false;
        } else
        {
            Toast.makeText(getApplicationContext(), 0x7f0c0059, 0).show();
            return false;
        }
    }

    ()
    {
        this$0 = SCTerdekatActivity.this;
        super();
    }
}
