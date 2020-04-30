// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;

// Referenced classes of package com.google.android.gms.internal:
//            zzjk, zzjl

private static final class x.zzb extends zzjk
{

    private final com.google.android.gms.common.api.nit> zzHa;

    public void zzi(int i, int j)
    {
        Status status = new Status(i);
        zzHa.zd(new <init>(status, j));
    }

    public (com.google.android.gms.common.api. )
    {
        zzHa = (com.google.android.gms.common.api.Ha)zzx.zzb(, "Result holder must not be null");
    }
}
