// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.rssfeeddetail;

import android.app.NotificationManager;

// Referenced classes of package com.inponsel.android.rssfeeddetail:
//            ReplyKomRSSActivity

class this._cls0
    implements Runnable
{

    final ReplyKomRSSActivity this$0;

    public void run()
    {
        ReplyKomRSSActivity.access$1(ReplyKomRSSActivity.this).cancel(notif_id);
    }

    ()
    {
        this$0 = ReplyKomRSSActivity.this;
        super();
    }
}
