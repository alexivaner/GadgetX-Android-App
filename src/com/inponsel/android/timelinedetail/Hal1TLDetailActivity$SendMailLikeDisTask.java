// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.timelinedetail;

import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.util.DisplayMetrics;
import com.inponsel.android.utils.HttpPush;
import com.inponsel.android.utils.Log;
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
        try
        {
            if (android.os.vity.SendMailLikeDisTask >= 11)
            {
                avoid = StrictMode.getThreadPolicy();
                StrictMode.setThreadPolicy((new android.os.vity.SendMailLikeDisTask(avoid)).kWrites().kWrites());
                StrictMode.setThreadPolicy(avoid);
            }
            avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("mail_like_comtl").append(Utility.BASE_FORMAT).append("?").append(querylike).append("&dens=").append(getResources().getDisplayMetrics().density).toString();
            Log.e("mail_like_com", avoid);
            avoid = HttpPush.getResponse(avoid);
            res = avoid.toString();
            res = res.trim();
            res = res.replaceAll("\\s+", "");
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            avoid.printStackTrace();
        }
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