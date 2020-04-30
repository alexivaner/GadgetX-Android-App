// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.SystemClock;

// Referenced classes of package com.google.android.gms.internal:
//            zzhf

private static final class zzyK
{

    private long zzyJ;
    private long zzyK;

    public Bundle toBundle()
    {
        Bundle bundle = new Bundle();
        bundle.putLong("topen", zzyJ);
        bundle.putLong("tclose", zzyK);
        return bundle;
    }

    public long zzea()
    {
        return zzyK;
    }

    public void zzeb()
    {
        zzyK = SystemClock.elapsedRealtime();
    }

    public void zzec()
    {
        zzyJ = SystemClock.elapsedRealtime();
    }

    public ()
    {
        zzyJ = -1L;
        zzyK = -1L;
    }
}
