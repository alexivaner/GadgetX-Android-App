// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.app.NotificationManager;

// Referenced classes of package com.inponsel.android.v2:
//            SCReplyFormActivity

class this._cls0
    implements Runnable
{

    final SCReplyFormActivity this$0;

    public void run()
    {
        SCReplyFormActivity.access$1(SCReplyFormActivity.this).cancel(notif_id);
    }

    ()
    {
        this$0 = SCReplyFormActivity.this;
        super();
    }
}
