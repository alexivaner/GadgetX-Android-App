// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.request.zzam;
import com.google.android.gms.fitness.result.SessionStopResult;

// Referenced classes of package com.google.android.gms.internal:
//            zzog, zznf, zznp

class eApiClient extends a
{

    final String val$name;
    final zzog zzaaD;
    final String zzaaE;

    protected Result createFailedResult(Status status)
    {
        return zzz(status);
    }

    protected volatile void zza(com.google.android.gms.common.api. )
        throws RemoteException
    {
        zza((zznf));
    }

    protected void zza(zznf zznf1)
        throws RemoteException
    {
        b b = new b(this, null);
        String s = zznf1.getContext().getPackageName();
        ((zznp)zznf1.zzjb()).zza(new zzam(val$name, zzaaE, b, s));
    }

    protected SessionStopResult zzz(Status status)
    {
        return SessionStopResult.zzG(status);
    }

    eApiClient(GoogleApiClient googleapiclient, String s, String s1)
    {
        zzaaD = final_zzog1;
        val$name = s;
        zzaaE = s1;
        super(googleapiclient);
    }
}
