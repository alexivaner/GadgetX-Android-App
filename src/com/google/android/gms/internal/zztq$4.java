// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.plus.internal.zze;
import java.util.Collection;

// Referenced classes of package com.google.android.gms.internal:
//            zztq

class eApiClient extends a
{

    final zztq zzauS;
    final Collection zzauT;

    protected volatile void zza(com.google.android.gms.common.api. )
        throws RemoteException
    {
        zza((zze));
    }

    protected void zza(zze zze1)
    {
        zze1.zza(this, zzauT);
    }

    eApiClient(zztq zztq1, GoogleApiClient googleapiclient, Collection collection)
    {
        zzauS = zztq1;
        zzauT = collection;
        super(googleapiclient, null);
    }
}
