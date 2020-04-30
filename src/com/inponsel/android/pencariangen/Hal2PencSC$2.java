// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.pencariangen;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.Editable;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.inponsel.android.utils.Log;
import com.inponsel.android.widget.ExpandableHeightGridView;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

// Referenced classes of package com.inponsel.android.pencariangen:
//            Hal2PencSC

class this._cls0
    implements android.widget.itorActionListener
{

    final Hal2PencSC this$0;

    public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
    {
        boolean flag = false;
        if (i == 3)
        {
            grup_header_footer.setVisibility(8);
            if (edtAutoSC.getText().toString().trim().length() == 0)
            {
                listSCManual.setVisibility(0);
            } else
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
                limit = 0;
                SearchTask();
            } else
            {
                Toast.makeText(getActivity(), 0x7f0c0059, 0).show();
            }
            flag = true;
        }
        return flag;
    }

    dView()
    {
        this$0 = Hal2PencSC.this;
        super();
    }
}
