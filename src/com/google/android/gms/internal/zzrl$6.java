// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;

// Referenced classes of package com.google.android.gms.internal:
//            zzrl, zzrk

class eApiClient extends c
{

    final String zzasJ;
    final zzrl zzata;

    protected volatile void zza(com.google.android.gms.common.api. )
        throws RemoteException
    {
        zza((zzrk));
    }

    protected void zza(zzrk zzrk1)
        throws RemoteException
    {
        zzrk1.zzq(this, zzasJ);
    }

    eApiClient(zzrl zzrl1, GoogleApiClient googleapiclient, String s)
    {
        zzata = zzrl1;
        zzasJ = s;
        super(googleapiclient, null);
    }
}
