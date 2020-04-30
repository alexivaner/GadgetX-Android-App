// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.fitness.request.zzp;

// Referenced classes of package com.google.android.gms.internal:
//            zzob, zzna, zzoh, zznk

class eApiClient extends c
{

    final zzob zzaaf;

    protected volatile void zza(com.google.android.gms.common.api. )
        throws RemoteException
    {
        zza((zzna));
    }

    protected void zza(zzna zzna1)
        throws RemoteException
    {
        zzoh zzoh1 = new zzoh(this);
        String s = zzna1.getContext().getPackageName();
        ((zznk)zzna1.zzjb()).zza(new zzp(zzoh1, s));
    }

    eApiClient(zzob zzob1, GoogleApiClient googleapiclient)
    {
        zzaaf = zzob1;
        super(googleapiclient);
    }
}
