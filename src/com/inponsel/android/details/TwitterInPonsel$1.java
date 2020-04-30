// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.os.AsyncTask;
import android.view.View;

// Referenced classes of package com.inponsel.android.details:
//            TwitterInPonsel

class this._cls0
    implements android.view.er
{

    final TwitterInPonsel this$0;

    public void onClick(View view)
    {
        if (android.os.INT >= 11)
        {
            (new mentarNextAsycTask(TwitterInPonsel.this)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
            return;
        } else
        {
            (new mentarNextAsycTask(TwitterInPonsel.this)).execute(new String[0]);
            return;
        }
    }

    mentarNextAsycTask()
    {
        this$0 = TwitterInPonsel.this;
        super();
    }
}
