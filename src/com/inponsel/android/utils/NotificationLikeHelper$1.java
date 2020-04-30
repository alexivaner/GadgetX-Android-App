// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.utils;

import android.app.NotificationManager;

// Referenced classes of package com.inponsel.android.utils:
//            NotificationLikeHelper

class this._cls0
    implements Runnable
{

    final NotificationLikeHelper this$0;

    public void run()
    {
        NotificationLikeHelper.access$0(NotificationLikeHelper.this).cancel(NotificationLikeHelper.access$1(NotificationLikeHelper.this));
    }

    _cls9()
    {
        this$0 = NotificationLikeHelper.this;
        super();
    }
}
