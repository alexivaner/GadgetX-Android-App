// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.core;

import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Logger;
import java.util.concurrent.Callable;

// Referenced classes of package com.crashlytics.android.core:
//            CrashlyticsCore, CrashlyticsFileMarker

private static final class crashMarker
    implements Callable
{

    private final CrashlyticsFileMarker crashMarker;

    public Boolean call()
        throws Exception
    {
        if (!crashMarker.isPresent())
        {
            return Boolean.FALSE;
        } else
        {
            Fabric.getLogger().d("CrashlyticsCore", "Found previous crash marker.");
            crashMarker.remove();
            return Boolean.TRUE;
        }
    }

    public volatile Object call()
        throws Exception
    {
        return call();
    }

    public (CrashlyticsFileMarker crashlyticsfilemarker)
    {
        crashMarker = crashlyticsfilemarker;
    }
}
