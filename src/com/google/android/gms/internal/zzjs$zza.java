// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.SystemClock;

// Referenced classes of package com.google.android.gms.internal:
//            zzjs

private class <init>
    implements Runnable
{

    final zzjs zzKd;

    public void run()
    {
        zzKd.zzKc = false;
        long l = SystemClock.elapsedRealtime();
        boolean flag = zzKd.zzo(l);
        zzKd.zzK(flag);
    }

    private (zzjs zzjs1)
    {
        zzKd = zzjs1;
        super();
    }

    zzKd(zzjs zzjs1, zzKd zzkd)
    {
        this(zzjs1);
    }
}
