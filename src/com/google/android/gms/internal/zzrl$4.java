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

    final String val$name;
    final byte zzahb[];
    final String zzasJ;
    final zzrl zzata;
    final zze zzatc;
    final zze zzatd;

    protected volatile void zza(com.google.android.gms.common.api. )
        throws RemoteException
    {
        zza((zzrk));
    }

    protected void zza(zzrk zzrk1)
        throws RemoteException
    {
        zzrk1.zza(this, val$name, zzasJ, zzahb, zzatc, zzatd);
    }

    eApiClient(GoogleApiClient googleapiclient, String s, String s1, byte abyte0[], zze zze, zze zze1)
    {
        zzata = final_zzrl1;
        val$name = s;
        zzasJ = s1;
        zzahb = abyte0;
        zzatc = zze;
        zzatd = zze1;
        super(googleapiclient, null);
    }
}
