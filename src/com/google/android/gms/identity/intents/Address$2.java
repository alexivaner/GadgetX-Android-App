// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.identity.intents;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzoq;

// Referenced classes of package com.google.android.gms.identity.intents:
//            Address, UserAddressRequest

static final class a extends a
{

    final UserAddressRequest zzalp;
    final int zzalq;

    protected volatile void zza(com.google.android.gms.common.api.ess._cls2 _pcls2)
        throws RemoteException
    {
        zza((zzoq)_pcls2);
    }

    protected void zza(zzoq zzoq1)
        throws RemoteException
    {
        zzoq1.zza(zzalp, zzalq);
        setResult(Status.zzNo);
    }

    sRequest(GoogleApiClient googleapiclient, UserAddressRequest useraddressrequest, int i)
    {
        zzalp = useraddressrequest;
        zzalq = i;
        super(googleapiclient);
    }
}
