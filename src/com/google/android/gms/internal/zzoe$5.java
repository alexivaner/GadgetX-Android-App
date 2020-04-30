// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.request.zzax;

// Referenced classes of package com.google.android.gms.internal:
//            zzoe, zznd, zzoh, zznn

class eApiClient extends c
{

    final zzoe zzaao;
    final DataSource zzaar;

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
        ((zznn)zznd1.zzjb()).zza(new zzax(null, zzaar, zzoh1, s));
    }

    eApiClient(zzoe zzoe1, GoogleApiClient googleapiclient, DataSource datasource)
    {
        zzaao = zzoe1;
        zzaar = datasource;
        super(googleapiclient);
    }
}
