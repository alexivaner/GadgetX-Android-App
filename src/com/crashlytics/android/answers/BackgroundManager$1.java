// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.answers;

import java.util.concurrent.atomic.AtomicReference;

// Referenced classes of package com.crashlytics.android.answers:
//            BackgroundManager

class this._cls0
    implements Runnable
{

    final BackgroundManager this$0;

    public void run()
    {
        backgroundFutureRef.set(null);
        BackgroundManager.access$000(BackgroundManager.this);
    }

    _cls9()
    {
        this$0 = BackgroundManager.this;
        super();
    }
}
