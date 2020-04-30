// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.fitness.data.Subscription;
import com.google.android.gms.fitness.request.zzat;

// Referenced classes of package com.google.android.gms.internal:
//            zzoe, zznd, zzoh, zznn

class eApiClient extends c
{

    final zzoe zzaao;
    final Subscription zzaaq;

    protected volatile void zza(com.google.android.gms.common.api. )
        throws RemoteException
    {
        zza((zznd));
    }

    protected void zza(zznd zznd1)
        throws RemoteException
    {
        zzoh zzoh1 = new zzoh(this);
        String s = zznd1.getContext().getPackageName();
        ((zznn)zznd1.zzjb()).zza(new zzat(zzaaq, false, zzoh1, s));
    }

    eApiClient(zzoe zzoe1, GoogleApiClient googleapiclient, Subscription subscription)
    {
        zzaao = zzoe1;
        zzaaq = subscription;
        super(googleapiclient);
    }
}
