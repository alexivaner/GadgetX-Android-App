// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.zzw;
import com.google.android.gms.fitness.result.ListSubscriptionsResult;

// Referenced classes of package com.google.android.gms.internal:
//            zzoe, zznd, zznn

class eApiClient extends a
{

    final zzoe zzaao;
    final DataType zzaap;

    protected Result createFailedResult(Status status)
    {
        return zzx(status);
    }

    protected volatile void zza(com.google.android.gms.common.api. )
        throws RemoteException
    {
        zza((zznd));
    }

    protected void zza(zznd zznd1)
        throws RemoteException
    {
        a a = new a(this, null);
        String s = zznd1.getContext().getPackageName();
        ((zznn)zznd1.zzjb()).zza(new zzw(zzaap, a, s));
    }

    protected ListSubscriptionsResult zzx(Status status)
    {
        return ListSubscriptionsResult.zzE(status);
    }

    eApiClient(zzoe zzoe1, GoogleApiClient googleapiclient, DataType datatype)
    {
        zzaao = zzoe1;
        zzaap = datatype;
        super(googleapiclient);
    }
}
