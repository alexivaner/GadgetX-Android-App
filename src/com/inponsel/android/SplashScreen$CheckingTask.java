// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android;

import android.os.AsyncTask;
import android.widget.TextView;

// Referenced classes of package com.inponsel.android:
//            SplashScreen

private class <init> extends AsyncTask
{

    final SplashScreen this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        boolean _tmp = SplashScreen.access$0(SplashScreen.this);
        return null;
    }

    protected void onCancelled()
    {
        super.onCancelled();
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Void)obj);
    }

    protected void onPostExecute(Void void1)
    {
        super.onPostExecute(void1);
        onResultCheck();
        setProgressBarIndeterminateVisibility(false);
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        stat.setText("");
        setProgressBarIndeterminateVisibility(true);
    }

    protected volatile transient void onProgressUpdate(Object aobj[])
    {
        onProgressUpdate((Void[])aobj);
    }

    protected transient void onProgressUpdate(Void avoid[])
    {
        super.onProgressUpdate(avoid);
    }

    private ()
    {
        this$0 = SplashScreen.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
