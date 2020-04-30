// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.request.zzu;
import com.google.android.gms.fitness.result.BleDevicesResult;

// Referenced classes of package com.google.android.gms.internal:
//            zzoa, zzmz, zznj

class eApiClient extends a
{

    final zzoa zzaaa;

    protected Result createFailedResult(Status status)
    {
        return zzu(status);
    }

    protected volatile void zza(com.google.android.gms.common.api. )
        throws RemoteException
    {
        zza((zzmz));
    }

    protected void zza(zzmz zzmz1)
        throws RemoteException
    {
        a a = new a(this, null);
        String s = zzmz1.getContext().getPackageName();
        ((zznj)zzmz1.zzjb()).zza(new zzu(a, s));
    }

    protected BleDevicesResult zzu(Status status)
    {
        return BleDevicesResult.zzB(status);
    }

    eApiClient(zzoa zzoa1, GoogleApiClient googleapiclient)
    {
        zzaaa = zzoa1;
        super(googleapiclient);
    }
}
