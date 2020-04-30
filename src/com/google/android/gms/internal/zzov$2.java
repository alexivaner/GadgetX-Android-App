// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.internal:
//            zzov, zzpf

class eApiClient extends a
{

    final PendingIntent zzamC;
    final zzov zzamD;

    protected volatile void zza(com.google.android.gms.common.api. )
        throws RemoteException
    {
        zza((zzpf));
    }

    protected void zza(zzpf zzpf1)
        throws RemoteException
    {
        zzpf1.zza(zzamC);
        setResult(Status.zzNo);
    }

    eApiClient(zzov zzov1, GoogleApiClient googleapiclient, PendingIntent pendingintent)
    {
        zzamD = zzov1;
        zzamC = pendingintent;
        super(googleapiclient);
    }
}
