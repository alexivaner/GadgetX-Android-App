// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.panorama.Panorama;

// Referenced classes of package com.google.android.gms.internal:
//            zzsw, zzsx, zzsv

private static abstract class  extends com.google.android.gms.common.api.Client
{

    protected abstract void zza(Context context, zzsv zzsv1)
        throws RemoteException;

    protected volatile void zza(com.google.android.gms.common.api.Client client)
        throws RemoteException
    {
        zza((zzsx)client);
    }

    protected final void zza(zzsx zzsx1)
        throws RemoteException
    {
        zza(zzsx1.getContext(), (zzsv)zzsx1.zzjb());
    }

    protected piClient(GoogleApiClient googleapiclient)
    {
        super(Panorama.zzGR, googleapiclient);
    }
}
