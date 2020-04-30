// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzx;

// Referenced classes of package com.google.android.gms.internal:
//            zzjk, zzjl

private static final class x.zzb extends zzjk
{

    private final com.google.android.gms.common.api.er zzHa;

    public void zza(int i, DataHolder dataholder)
    {
        zzHa.zd(new <init>(i, dataholder));
    }

    public (com.google.android.gms.common.api.er er)
    {
        zzHa = (com.google.android.gms.common.api.Ha)zzx.zzb(er, "Result holder must not be null");
    }
}
