// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationListener;

// Referenced classes of package com.google.android.gms.internal:
//            zzoz, zzpf

class eApiClient extends a
{

    final LocationListener zzamH;
    final zzoz zzamI;

    protected volatile void zza(com.google.android.gms.common.api. )
        throws RemoteException
    {
        zza((zzpf));
    }

    protected void zza(zzpf zzpf1)
        throws RemoteException
    {
        zzpf1.zza(zzamH);
        setResult(Status.zzNo);
    }

    eApiClient(zzoz zzoz1, GoogleApiClient googleapiclient, LocationListener locationlistener)
    {
        zzamI = zzoz1;
        zzamH = locationlistener;
        super(googleapiclient);
    }
}
