// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.request.zzb;

// Referenced classes of package com.google.android.gms.internal:
//            zzoa, zzmz, zzoh, zznj

class eApiClient extends c
{

    final zzoa zzaaa;
    final BleDevice zzaad;

    protected volatile void zza(com.google.android.gms.common.api. )
        throws RemoteException
    {
        zza((zzmz));
    }

    protected void zza(zzmz zzmz1)
        throws RemoteException
    {
        zzoh zzoh1 = new zzoh(this);
        String s = zzmz1.getContext().getPackageName();
        ((zznj)zzmz1.zzjb()).zza(new zzb(zzaad.getAddress(), zzaad, zzoh1, s));
    }

    eApiClient(zzoa zzoa1, GoogleApiClient googleapiclient, BleDevice bledevice)
    {
        zzaaa = zzoa1;
        zzaad = bledevice;
        super(googleapiclient);
    }
}
