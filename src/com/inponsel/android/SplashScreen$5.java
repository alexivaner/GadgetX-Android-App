// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android;

import android.content.Context;
import android.os.AsyncTask;

// Referenced classes of package com.inponsel.android:
//            SplashScreen, ServerUtilities

class val.context extends AsyncTask
{

    final SplashScreen this$0;
    private final Context val$context;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        ServerUtilities.register(val$context, SplashScreen.name, SplashScreen.email, regId);
        return null;
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Void)obj);
    }

    protected void onPostExecute(Void void1)
    {
        mRegisterTask = null;
    }

    ()
    {
        this$0 = final_splashscreen;
        val$context = Context.this;
        super();
    }
}
