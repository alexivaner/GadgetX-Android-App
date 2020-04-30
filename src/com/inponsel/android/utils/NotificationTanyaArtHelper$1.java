// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.utils;

import android.app.NotificationManager;

// Referenced classes of package com.inponsel.android.utils:
//            NotificationTanyaArtHelper

class val.id
    implements Runnable
{

    final NotificationTanyaArtHelper this$0;
    private final String val$id;

    public void run()
    {
        NotificationTanyaArtHelper.access$0(NotificationTanyaArtHelper.this).cancel(Integer.parseInt(val$id));
    }

    ()
    {
        this$0 = final_notificationtanyaarthelper;
        val$id = String.this;
        super();
    }
}
