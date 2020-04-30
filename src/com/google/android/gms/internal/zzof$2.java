// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.data.zzk;
import com.google.android.gms.fitness.request.SensorRequest;
import com.google.android.gms.fitness.request.zzac;

// Referenced classes of package com.google.android.gms.internal:
//            zzof, zzne, zzoh, zzno

class eApiClient extends c
{

    final zzof zzaat;
    final SensorRequest zzaau;
    final zzk zzaav;
    final PendingIntent zzaaw;

    protected Result createFailedResult(Status status)
    {
        return zzb(status);
    }

    protected volatile void zza(com.google.android.gms.common.api. )
        throws RemoteException
    {
        zza((zzne));
    }

    protected void zza(zzne zzne1)
        throws RemoteException
    {
        zzoh zzoh1 = new zzoh(this);
        String s = zzne1.getContext().getPackageName();
        ((zzno)zzne1.zzjb()).zza(new zzac(zzaau, zzaav, zzaaw, zzoh1, s));
    }

    protected Status zzb(Status status)
    {
        return status;
    }

    eApiClient(zzof zzof1, GoogleApiClient googleapiclient, SensorRequest sensorrequest, zzk zzk, PendingIntent pendingintent)
    {
        zzaat = zzof1;
        zzaau = sensorrequest;
        zzaav = zzk;
        zzaaw = pendingintent;
        super(googleapiclient);
    }
}
