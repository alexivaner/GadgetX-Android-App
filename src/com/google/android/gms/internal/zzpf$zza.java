// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.location.LocationStatusCodes;

// Referenced classes of package com.google.android.gms.internal:
//            zzpf

private final class zzamZ extends com.google.android.gms.common.internal.des.zzfq
{

    private final int zzLs;
    private final String zzamZ[];
    final zzpf zzana;

    protected void zza(com.google.android.gms.location.s.zzfq zzfq)
    {
        if (zzfq != null)
        {
            zzfq.za(zzLs, zzamZ);
        }
    }

    protected void zzi(Object obj)
    {
        zza((com.google.android.gms.location.zza)obj);
    }

    protected void zzjf()
    {
    }

    public k(zzpf zzpf1, com.google.android.gms.location.s s, int i, String as[])
    {
        zzana = zzpf1;
        super(zzpf1, s);
        zzLs = LocationStatusCodes.zzfq(i);
        zzamZ = as;
    }
}
