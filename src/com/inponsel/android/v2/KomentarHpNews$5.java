// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.os.AsyncTask;
import android.view.View;

// Referenced classes of package com.inponsel.android.v2:
//            KomentarHpNews

class this._cls0
    implements android.view.ner
{

    final KomentarHpNews this$0;

    public void onClick(View view)
    {
        if (android.os._INT >= 11)
        {
            (new mentarRefreshAsycTask(KomentarHpNews.this)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
            return;
        } else
        {
            (new mentarRefreshAsycTask(KomentarHpNews.this)).execute(new String[0]);
            return;
        }
    }

    mentarRefreshAsycTask()
    {
        this$0 = KomentarHpNews.this;
        super();
    }
}
