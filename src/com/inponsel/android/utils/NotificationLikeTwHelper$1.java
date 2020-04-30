// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.utils;

import android.app.NotificationManager;

// Referenced classes of package com.inponsel.android.utils:
//            NotificationLikeTwHelper

class this._cls0
    implements Runnable
{

    final NotificationLikeTwHelper this$0;

    public void run()
    {
        NotificationLikeTwHelper.access$0(NotificationLikeTwHelper.this).cancel(NotificationLikeTwHelper.access$1(NotificationLikeTwHelper.this));
    }

    ()
    {
        this$0 = NotificationLikeTwHelper.this;
        super();
    }
}
