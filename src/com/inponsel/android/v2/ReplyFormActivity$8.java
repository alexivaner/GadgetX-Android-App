// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.app.NotificationManager;

// Referenced classes of package com.inponsel.android.v2:
//            ReplyFormActivity

class this._cls0
    implements Runnable
{

    final ReplyFormActivity this$0;

    public void run()
    {
        ReplyFormActivity.access$1(ReplyFormActivity.this).cancel(notif_id);
    }

    ()
    {
        this$0 = ReplyFormActivity.this;
        super();
    }
}
