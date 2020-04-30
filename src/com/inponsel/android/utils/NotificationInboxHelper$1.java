// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.utils;

import android.app.NotificationManager;

// Referenced classes of package com.inponsel.android.utils:
//            NotificationInboxHelper

class this._cls0
    implements Runnable
{

    final NotificationInboxHelper this$0;

    public void run()
    {
        NotificationInboxHelper.access$0(NotificationInboxHelper.this).cancel(NotificationInboxHelper.access$1(NotificationInboxHelper.this));
    }

    ()
    {
        this$0 = NotificationInboxHelper.this;
        super();
    }
}
