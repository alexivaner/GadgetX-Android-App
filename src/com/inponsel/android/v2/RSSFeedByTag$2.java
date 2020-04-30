// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.os.AsyncTask;
import android.view.View;

// Referenced classes of package com.inponsel.android.v2:
//            RSSFeedByTag

class this._cls0
    implements android.view.tener
{

    final RSSFeedByTag this$0;

    public void onClick(View view)
    {
        if (android.os.DK_INT >= 11)
        {
            (new SOldAsycTask(RSSFeedByTag.this)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
            return;
        } else
        {
            (new SOldAsycTask(RSSFeedByTag.this)).execute(new String[0]);
            return;
        }
    }

    SOldAsycTask()
    {
        this$0 = RSSFeedByTag.this;
        super();
    }
}
