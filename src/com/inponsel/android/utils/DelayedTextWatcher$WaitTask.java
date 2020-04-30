// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.utils;

import android.os.AsyncTask;
import android.text.Editable;

// Referenced classes of package com.inponsel.android.utils:
//            DelayedTextWatcher

private class <init> extends AsyncTask
{

    final DelayedTextWatcher this$0;

    protected transient Editable doInBackground(Editable aeditable[])
    {
        try
        {
            Thread.sleep(DelayedTextWatcher.access$0(DelayedTextWatcher.this));
        }
        catch (InterruptedException interruptedexception) { }
        return aeditable[0];
    }

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Editable[])aobj);
    }

    protected void onPostExecute(Editable editable)
    {
        super.onPostExecute(editable);
        afterTextChangedDelayed(editable);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Editable)obj);
    }

    private ()
    {
        this$0 = DelayedTextWatcher.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
