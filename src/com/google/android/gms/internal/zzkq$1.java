// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;

// Referenced classes of package com.google.android.gms.internal:
//            zzkq, zzks, zzku

class eApiClient extends a
{

    final zzkq zzQz;

    protected volatile void zza(com.google.android.gms.common.api. )
        throws RemoteException
    {
        zza((zzks));
    }

    protected void zza(zzks zzks1)
        throws RemoteException
    {
        ((zzku)zzks1.zzjb()).zza(new a(this));
    }

    eApiClient(zzkq zzkq1, GoogleApiClient googleapiclient)
    {
        zzQz = zzkq1;
        super(googleapiclient);
    }
}
