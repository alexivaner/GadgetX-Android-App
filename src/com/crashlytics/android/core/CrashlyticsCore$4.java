// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.core;

import java.util.concurrent.Callable;

// Referenced classes of package com.crashlytics.android.core:
//            CrashlyticsCore, CrashlyticsFileMarker

class this._cls0
    implements Callable
{

    final CrashlyticsCore this$0;

    public Boolean call()
        throws Exception
    {
        return Boolean.valueOf(CrashlyticsCore.access$100(CrashlyticsCore.this).isPresent());
    }

    public volatile Object call()
        throws Exception
    {
        return call();
    }

    ker()
    {
        this$0 = CrashlyticsCore.this;
        super();
    }
}
