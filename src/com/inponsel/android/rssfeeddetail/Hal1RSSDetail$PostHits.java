// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.rssfeeddetail;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.os.AsyncTask;
import android.os.StrictMode;
import com.inponsel.android.utils.HttpPush;
import com.inponsel.android.utils.UserFunctions;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;

// Referenced classes of package com.inponsel.android.rssfeeddetail:
//            Hal1RSSDetail

public class this._cls0 extends AsyncTask
{

    final Hal1RSSDetail this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        if (android.os. > 9)
        {
            StrictMode.setThreadPolicy((new android.os..Builder()).permitAll().build());
        }
        avoid = "-";
        if (!userFunctions.isUserLoggedIn(getActivity())) goto _L2; else goto _L1
_L1:
        Object obj = user_id;
_L8:
        avoid = (new StringBuilder("idrss=")).append(id_rss).append("&user=").append(((String) (obj))).append("&hits=1&t=").append(t).toString();
        HttpPush.getResponse((new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("hits_rss").append(Utility.BASE_FORMAT).append("?").append(avoid).toString()).toString().trim().replaceAll("\\s+", "");
_L6:
        return null;
_L2:
        obj = avoid;
        Account aaccount[] = AccountManager.get(getActivity()).getAccounts();
        obj = avoid;
        int j = aaccount.length;
        int i = 0;
_L4:
        Object obj1;
        Account account;
        obj = avoid;
        if (i >= j)
        {
            continue; /* Loop/switch isn't completed */
        }
        account = aaccount[i];
        obj1 = avoid;
        obj = avoid;
        if (!account.name.endsWith("gmail.com"))
        {
            break MISSING_BLOCK_LABEL_225;
        }
        obj = avoid;
        obj1 = account.name;
        i++;
        avoid = ((Void []) (obj1));
        if (true) goto _L4; else goto _L3
_L3:
        avoid;
        avoid.printStackTrace();
        if (true) goto _L6; else goto _L5
_L5:
        avoid;
        if (true) goto _L8; else goto _L7
_L7:
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
        this$0 = Hal1RSSDetail.this;
        super();
    }
}
