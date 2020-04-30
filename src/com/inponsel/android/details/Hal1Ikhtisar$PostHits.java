// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.os.AsyncTask;
import android.os.StrictMode;
import com.inponsel.android.utils.HttpPush;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;
import java.net.URLEncoder;

// Referenced classes of package com.inponsel.android.details:
//            Hal1Ikhtisar

public class this._cls0 extends AsyncTask
{

    final Hal1Ikhtisar this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        if (android.os.y > 9)
        {
            StrictMode.setThreadPolicy((new android.os.y.Builder()).permitAll().build());
        }
        avoid = "-";
        if (!userFunction.isUserLoggedIn(getActivity())) goto _L2; else goto _L1
_L1:
        Object obj = email_user;
_L4:
        avoid = URLEncoder.encode(namalengkap, "utf-8");
        avoid = (new StringBuilder("idhp=")).append(id_hp).append("&email=").append(((String) (obj))).append("&hits=1&namalengkap=").append(avoid).append("&t=").append(t).toString();
        HttpPush.getResponse((new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("hits_hp").append(Utility.BASE_FORMAT).append("?").append(avoid).toString()).toString().trim().replaceAll("\\s+", "");
        break MISSING_BLOCK_LABEL_246;
_L2:
        Account aaccount[];
        int j;
        aaccount = AccountManager.get(getActivity()).getAccounts();
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
        this$0 = Hal1Ikhtisar.this;
        super();
    }
}
