// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.plus.internal.zze;

// Referenced classes of package com.google.android.gms.internal:
//            zztq

class eApiClient extends a
{

    final zztq zzauS;
    final String zzauU[];

    protected volatile void zza(com.google.android.gms.common.api. )
        throws RemoteException
    {
        zza((zze));
    }

    protected void zza(zze zze1)
    {
        zze1.zzd(this, zzauU);
    }

    eApiClient(zztq zztq1, GoogleApiClient googleapiclient, String as[])
    {
        zzauS = zztq1;
        zzauU = as;
        super(googleapiclient, null);
    }
}
