// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.utils;

import android.app.NotificationManager;

// Referenced classes of package com.inponsel.android.utils:
//            NotificationLikeRSSHelper

class this._cls0
    implements Runnable
{

    final NotificationLikeRSSHelper this$0;

    public void run()
    {
        NotificationLikeRSSHelper.access$0(NotificationLikeRSSHelper.this).cancel(NotificationLikeRSSHelper.access$1(NotificationLikeRSSHelper.this));
    }

    ()
    {
        this$0 = NotificationLikeRSSHelper.this;
        super();
    }
}
