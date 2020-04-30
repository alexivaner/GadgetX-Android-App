// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.plus.internal.zze;
import com.google.android.gms.plus.model.moments.Moment;

// Referenced classes of package com.google.android.gms.internal:
//            zztp

class eApiClient extends c
{

    final zztp zzauJ;
    final Moment zzauO;

    protected volatile void zza(com.google.android.gms.common.api. )
        throws RemoteException
    {
        zza((zze));
    }

    protected void zza(zze zze1)
    {
        zze1.zza(this, zzauO);
    }

    eApiClient(zztp zztp1, GoogleApiClient googleapiclient, Moment moment)
    {
        zzauJ = zztp1;
        zzauO = moment;
        super(googleapiclient, null);
    }
}
