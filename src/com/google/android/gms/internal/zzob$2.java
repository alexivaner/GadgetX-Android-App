// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.request.zzl;
import com.google.android.gms.fitness.result.DataTypeResult;

// Referenced classes of package com.google.android.gms.internal:
//            zzob, zzna, zznk

class eApiClient extends a
{

    final zzob zzaaf;
    final String zzaag;

    protected Result createFailedResult(Status status)
    {
        return zzv(status);
    }

    protected volatile void zza(com.google.android.gms.common.api. )
        throws RemoteException
    {
        zza((zzna));
    }

    protected void zza(zzna zzna1)
        throws RemoteException
    {
        a a = new a(this, null);
        String s = zzna1.getContext().getPackageName();
        ((zznk)zzna1.zzjb()).zza(new zzl(zzaag, a, s));
    }

    protected DataTypeResult zzv(Status status)
    {
        return DataTypeResult.zzD(status);
    }

    eApiClient(zzob zzob1, GoogleApiClient googleapiclient, String s)
    {
        zzaaf = zzob1;
        zzaag = s;
        super(googleapiclient);
    }
}
