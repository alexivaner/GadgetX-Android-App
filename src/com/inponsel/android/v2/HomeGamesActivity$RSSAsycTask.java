// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.os.AsyncTask;
import com.inponsel.android.utils.Log;

// Referenced classes of package com.inponsel.android.v2:
//            HomeGamesActivity

public class this._cls0 extends AsyncTask
{

    final HomeGamesActivity this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((String[])aobj);
    }

    protected transient Void doInBackground(String as[])
    {
        return null;
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Void)obj);
    }

    protected void onPostExecute(Void void1)
    {
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        Log.e("RSSAsycTask", "onPreExecute");
    }

    public ()
    {
        this$0 = HomeGamesActivity.this;
        super();
    }
}
