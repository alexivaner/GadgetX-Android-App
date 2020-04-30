// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.internal:
//            zzoz, zzpf

class eApiClient extends a
{

    final zzoz zzamI;
    final boolean zzamJ;

    protected volatile void zza(com.google.android.gms.common.api. )
        throws RemoteException
    {
        zza((zzpf));
    }

    protected void zza(zzpf zzpf1)
        throws RemoteException
    {
        zzpf1.zzW(zzamJ);
        setResult(Status.zzNo);
    }

    eApiClient(zzoz zzoz1, GoogleApiClient googleapiclient, boolean flag)
    {
        zzamI = zzoz1;
        zzamJ = flag;
        super(googleapiclient);
    }
}
