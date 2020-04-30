// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.timelinedetail;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.os.AsyncTask;
import android.os.StrictMode;
import com.inponsel.android.utils.HttpPush;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;

// Referenced classes of package com.inponsel.android.timelinedetail:
//            Hal1TLDetailActivity

public class this._cls0 extends AsyncTask
{

    final Hal1TLDetailActivity this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        if (android.os.LDetailActivity.PostHits > 9)
        {
            StrictMode.setThreadPolicy((new android.os.r()).permitAll().build());
        }
        avoid = "-";
        if (!userFunctions.isUserLoggedIn(Hal1TLDetailActivity.this)) goto _L2; else goto _L1
_L1:
        Object obj = user_id;
_L4:
        avoid = (new StringBuilder("tl_id=")).append(tl_id).append("&user=").append(((String) (obj))).append("&hits=1&t=").append(t).toString();
        avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("hits_forum").append(Utility.BASE_FORMAT).append("?").append(avoid).toString();
        Log.e("pushURL", avoid);
        HttpPush.getResponse(avoid).toString().trim().replaceAll("\\s+", "");
        break MISSING_BLOCK_LABEL_226;
_L2:
        Account aaccount[];
        int j;
        aaccount = AccountManager.get(Hal1TLDetailActivity.this).getAccounts();
        j = aaccount.length;
        int i = 0;
_L5:
        obj = avoid;
        if (i >= j) goto _L4; else goto _L3
_L3:
        obj = aaccount[i];
        if (((Account) (obj)).name.endsWith("gmail.com"))
        {
            avoid = ((Account) (obj)).name;
        }
        i++;
          goto _L5
        avoid;
        avoid.printStackTrace();
        return null;
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Void)obj);
    }

    protected void onPostExecute(Void void1)
    {
        super.onPostExecute(void1);
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
    }

    public ()
    {
        this$0 = Hal1TLDetailActivity.this;
        super();
    }
}
