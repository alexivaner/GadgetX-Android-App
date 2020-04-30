// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.zze;

// Referenced classes of package com.google.android.gms.internal:
//            zzrl, zzrk

class eApiClient extends c
{

    final String zzasV;
    final long zzasY;
    final zzrl zzata;
    final zze zzatb;

    protected volatile void zza(com.google.android.gms.common.api. )
        throws RemoteException
    {
        zza((zzrk));
    }

    protected void zza(zzrk zzrk1)
        throws RemoteException
    {
        zzrk1.zza(this, zzasV, zzasY, zzatb);
    }

    eApiClient(zzrl zzrl1, GoogleApiClient googleapiclient, String s, long l, zze zze)
    {
        zzata = zzrl1;
        zzasV = s;
        zzasY = l;
        zzatb = zze;
        super(googleapiclient, null);
    }
}
