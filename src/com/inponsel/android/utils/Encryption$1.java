// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.utils;

import android.os.AsyncTask;

// Referenced classes of package com.inponsel.android.utils:
//            Encryption

class llback extends AsyncTask
{

    final Encryption this$0;
    private final llback val$callback;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((String[])aobj);
    }

    protected transient String doInBackground(String as[])
    {
        try
        {
            as = encrypt(as[0]);
        }
        // Misplaced declaration of an exception variable
        catch (String as[])
        {
            val$callback.onError(as);
            return null;
        }
        if (as != null)
        {
            break MISSING_BLOCK_LABEL_33;
        }
        val$callback.onError(new Exception("Encrypt return null, it normally occurs when you send a null data"));
        return as;
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((String)obj);
    }

    protected void onPostExecute(String s)
    {
        super.onPostExecute(s);
        if (s != null)
        {
            val$callback.onSuccess(s);
        }
    }

    llback()
    {
        this$0 = final_encryption;
        val$callback = llback.this;
        super();
    }
}
