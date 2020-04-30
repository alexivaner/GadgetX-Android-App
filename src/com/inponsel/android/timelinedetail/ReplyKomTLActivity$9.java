// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.timelinedetail;

import android.app.NotificationManager;

// Referenced classes of package com.inponsel.android.timelinedetail:
//            ReplyKomTLActivity

class this._cls0
    implements Runnable
{

    final ReplyKomTLActivity this$0;

    public void run()
    {
        ReplyKomTLActivity.access$1(ReplyKomTLActivity.this).cancel(notif_id);
    }

    ()
    {
        this$0 = ReplyKomTLActivity.this;
        super();
    }
}
