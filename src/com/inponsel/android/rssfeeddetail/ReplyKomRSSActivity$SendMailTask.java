// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.rssfeeddetail;

import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.util.DisplayMetrics;
import com.inponsel.android.utils.HttpPush;
import com.inponsel.android.utils.Log;
import com.inponsel.android.utils.Util;
import com.inponsel.android.utils.Utility;

// Referenced classes of package com.inponsel.android.rssfeeddetail:
//            ReplyKomRSSActivity

public class this._cls0 extends AsyncTask
{

    final ReplyKomRSSActivity this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        try
        {
            if (android.os.SSActivity.SendMailTask >= 11)
            {
                avoid = StrictMode.getThreadPolicy();
                StrictMode.setThreadPolicy((new android.os.init>(avoid)).ermitDiskWrites().uild());
                StrictMode.setThreadPolicy(avoid);
            }
            avoid = (new StringBuilder(String.valueOf(Util.BASE_PATH2))).append("mail_tanggap_rss").append(Utility.BASE_FORMAT).append("?").append(querypopkomen).append("&dens=").append(getResources().getDisplayMetrics().density).toString();
            Log.e("pushURLemail", avoid);
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

    public I()
    {
        this$0 = ReplyKomRSSActivity.this;
        super();
    }
}
