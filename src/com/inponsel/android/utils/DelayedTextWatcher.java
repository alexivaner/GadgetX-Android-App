// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.utils;

import android.os.AsyncTask;
import android.text.Editable;
import android.text.TextWatcher;

public abstract class DelayedTextWatcher
    implements TextWatcher
{
    private class WaitTask extends AsyncTask
    {

        final DelayedTextWatcher this$0;

        protected transient Editable doInBackground(Editable aeditable[])
        {
            try
            {
                Thread.sleep(delayTime);
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

        private WaitTask()
        {
            this$0 = DelayedTextWatcher.this;
            super();
        }

        WaitTask(WaitTask waittask)
        {
            this();
        }
    }


    private long delayTime;
    private WaitTask lastWaitTask;

    public DelayedTextWatcher(long l)
    {
        delayTime = l;
    }

    public void afterTextChanged(Editable editable)
    {
        this;
        JVM INSTR monitorenter ;
        if (lastWaitTask != null)
        {
            lastWaitTask.cancel(true);
        }
        lastWaitTask = new WaitTask(null);
        lastWaitTask.execute(new Editable[] {
            editable
        });
        this;
        JVM INSTR monitorexit ;
        return;
        editable;
        this;
        JVM INSTR monitorexit ;
        throw editable;
    }

    public abstract void afterTextChangedDelayed(Editable editable);

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

}
