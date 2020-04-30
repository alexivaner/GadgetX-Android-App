// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.core;

import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Logger;
import java.util.concurrent.Callable;

// Referenced classes of package com.crashlytics.android.core:
//            CrashlyticsCore, CrashlyticsFileMarker

class this._cls0
    implements Callable
{

    final CrashlyticsCore this$0;

    public volatile Object call()
        throws Exception
    {
        return call();
    }

    public Void call()
        throws Exception
    {
        CrashlyticsCore.access$100(CrashlyticsCore.this).create();
        Fabric.getLogger().d("CrashlyticsCore", "Initialization marker file created.");
        return null;
    }

    ker()
    {
        this$0 = CrashlyticsCore.this;
        super();
    }
}
