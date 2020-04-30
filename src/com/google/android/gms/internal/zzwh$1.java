// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.internal:
//            zzwh, zzwi

class eApiClient extends com.google.android.gms.wallet.zzb
{

    final zzwh zzaET;
    final int zzalq;

    protected volatile void zza(com.google.android.gms.common.api. )
        throws RemoteException
    {
        zza((zzwi));
    }

    protected void zza(zzwi zzwi1)
    {
        zzwi1.zzhG(zzalq);
        setResult(Status.zzNo);
    }

    eApiClient(zzwh zzwh1, GoogleApiClient googleapiclient, int i)
    {
        zzaET = zzwh1;
        zzalq = i;
        super(googleapiclient);
    }
}
