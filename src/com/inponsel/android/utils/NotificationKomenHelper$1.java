// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.utils;

import android.app.NotificationManager;

// Referenced classes of package com.inponsel.android.utils:
//            NotificationKomenHelper, Log

class this._cls0
    implements Runnable
{

    final NotificationKomenHelper this$0;

    public void run()
    {
        Log.e("close", (new StringBuilder("notif ")).append(String.valueOf(NotificationKomenHelper.access$0(NotificationKomenHelper.this))).toString());
        NotificationKomenHelper.access$1(NotificationKomenHelper.this).cancel(NotificationKomenHelper.access$0(NotificationKomenHelper.this));
    }

    ()
    {
        this$0 = NotificationKomenHelper.this;
        super();
    }
}
