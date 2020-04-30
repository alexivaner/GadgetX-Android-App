// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.places.PlaceFilter;
import com.google.android.gms.location.places.zzi;

// Referenced classes of package com.google.android.gms.internal:
//            zzpw, zzpx

class zc extends com.google.android.gms.location.places.
{

    final PlaceFilter zzaot;
    final zzpw zzaou;

    protected volatile void zza(com.google.android.gms.common.api. )
        throws RemoteException
    {
        zza((zzpx));
    }

    protected void zza(zzpx zzpx1)
        throws RemoteException
    {
        zzpx1.zza(new zzi(this, zzpx1.getContext()), zzaot);
    }

    eApiClient(zzpw zzpw1, com.google.android.gms.common.api. , GoogleApiClient googleapiclient, PlaceFilter placefilter)
    {
        zzaou = zzpw1;
        zzaot = placefilter;
        super(, googleapiclient);
    }
}
