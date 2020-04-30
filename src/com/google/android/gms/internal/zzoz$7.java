// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.internal:
//            zzoz, zzpf

class eApiClient extends a
{

    final PendingIntent zzamC;
    final zzoz zzamI;

    protected volatile void zza(com.google.android.gms.common.api. )
        throws RemoteException
    {
        zza((zzpf));
    }

    protected void zza(zzpf zzpf1)
        throws RemoteException
    {
        zzpf1.zzd(zzamC);
        setResult(Status.zzNo);
    }

    eApiClient(zzoz zzoz1, GoogleApiClient googleapiclient, PendingIntent pendingintent)
    {
        zzamI = zzoz1;
        zzamC = pendingintent;
        super(googleapiclient);
    }
}
