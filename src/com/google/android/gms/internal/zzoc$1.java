// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.request.zze;

// Referenced classes of package com.google.android.gms.internal:
//            zzoc, zznb, zzoh, zznl

class eApiClient extends c
{

    final DataSet zzaah;
    final boolean zzaai;
    final zzoc zzaaj;

    protected volatile void zza(com.google.android.gms.common.api. )
        throws RemoteException
    {
        zza((zznb));
    }

    protected void zza(zznb zznb1)
        throws RemoteException
    {
        zzoh zzoh1 = new zzoh(this);
        String s = zznb1.getContext().getPackageName();
        ((zznl)zznb1.zzjb()).zza(new zze(zzaah, zzoh1, s, zzaai));
    }

    eApiClient(zzoc zzoc1, GoogleApiClient googleapiclient, DataSet dataset, boolean flag)
    {
        zzaaj = zzoc1;
        zzaah = dataset;
        zzaai = flag;
        super(googleapiclient);
    }
}
