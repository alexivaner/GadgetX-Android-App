// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.inponsel.android.utils.Log;
import com.loopj.android.http.AsyncHttpResponseHandler;
import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.v2:
//            AppsByCategory

class andler extends AsyncHttpResponseHandler
{

    final AppsByCategory this$0;

    public void onFailure(int i, Header aheader[], byte abyte0[], Throwable throwable)
    {
    }

    public void onRetry(int i)
    {
    }

    public void onStart()
    {
    }

    public void onSuccess(int i, Header aheader[], byte abyte0[])
    {
        aheader = new String(abyte0);
        Log.e("respJson", aheader);
        aheader = (new JSONObject(aheader)).getJSONArray("InPonsel");
        i = 0;
_L3:
        int j = aheader.length();
        if (i < j) goto _L2; else goto _L1
_L1:
        if (str_likestatus_cat.equals("0"))
        {
            img_like_apps_1.setImageResource(0x7f020257);
            rl_like_apps.setEnabled(true);
        } else
        {
            img_like_apps_1.setImageResource(0x7f02025b);
            rl_like_apps.setEnabled(false);
        }
        txt_like_kat_apps_1.setText(str_totallike_cat);
        return;
_L2:
        abyte0 = aheader.getJSONObject(i);
        str_likestatus_cat = abyte0.getString("mystat");
        str_totallike_cat = abyte0.getString("total_like");
        i++;
          goto _L3
        aheader;
          goto _L1
    }

    andler()
    {
        this$0 = AppsByCategory.this;
        super();
    }
}
