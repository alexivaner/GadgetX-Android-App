// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;

// Referenced classes of package com.google.android.gms.internal:
//            zzjj, zzje, zzjb

class eApiClient extends c
{

    final String zzGD;
    final zzjb zzGE[];
    final zzjj zzGF;

    protected void zza(zzje zzje1)
        throws RemoteException
    {
        zzje1.zza(new d(this), zzGD, zzGE);
    }

    eApiClient(zzjj zzjj1, GoogleApiClient googleapiclient, String s, zzjb azzjb[])
    {
        zzGF = zzjj1;
        zzGD = s;
        zzGE = azzjb;
        super(googleapiclient);
    }
}
