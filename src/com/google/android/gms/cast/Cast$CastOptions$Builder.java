// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import com.google.android.gms.common.internal.zzx;

// Referenced classes of package com.google.android.gms.cast:
//            Cast, CastDevice

public static final class <init>
{

    CastDevice zzIA;
    zzIC zzIB;
    private int zzIC;

    static int zza(<init> <init>1)
    {
        return <init>1.zzIC;
    }

    public zzIC build()
    {
        return new zzIC(this, null);
    }

    public zzIC setVerboseLoggingEnabled(boolean flag)
    {
        if (flag)
        {
            zzIC = zzIC | 1;
            return this;
        } else
        {
            zzIC = zzIC & -2;
            return this;
        }
    }

    private (CastDevice castdevice,  )
    {
        zzx.zzb(castdevice, "CastDevice parameter cannot be null");
        zzx.zzb(, "CastListener parameter cannot be null");
        zzIA = castdevice;
        zzIB = ;
        zzIC = 0;
    }

    zzIC(CastDevice castdevice, zzIC zzic, zzIC zzic1)
    {
        this(castdevice, zzic);
    }
}
