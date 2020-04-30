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

    final byte zzahb[];
    final String zzasJ;
    final zzrl zzata;
    final zze zzatd;

    protected volatile void zza(com.google.android.gms.common.api. )
        throws RemoteException
    {
        zza((zzrk));
    }

    protected void zza(zzrk zzrk1)
        throws RemoteException
    {
        zzrk1.zza(this, zzasJ, zzahb, zzatd);
    }

    eApiClient(zzrl zzrl1, GoogleApiClient googleapiclient, String s, byte abyte0[], zze zze)
    {
        zzata = zzrl1;
        zzasJ = s;
        zzahb = abyte0;
        zzatd = zze;
        super(googleapiclient, null);
    }
}
