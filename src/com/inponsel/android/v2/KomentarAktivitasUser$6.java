// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.os.AsyncTask;
import android.view.View;

// Referenced classes of package com.inponsel.android.v2:
//            KomentarAktivitasUser

class this._cls0
    implements android.view.itasUser._cls6
{

    final KomentarAktivitasUser this$0;

    public void onClick(View view)
    {
        if (android.os.ivitasUser >= 11)
        {
            (new mentarNewsRefreshAsycTask(KomentarAktivitasUser.this)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
            return;
        } else
        {
            (new mentarNewsRefreshAsycTask(KomentarAktivitasUser.this)).execute(new String[0]);
            return;
        }
    }

    mentarNewsRefreshAsycTask()
    {
        this$0 = KomentarAktivitasUser.this;
        super();
    }
}
