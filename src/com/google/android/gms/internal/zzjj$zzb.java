// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;

// Referenced classes of package com.google.android.gms.internal:
//            zzjj, zzim, zzjh, zzje

private static abstract class  extends com.google.android.gms.common.api.Client
{

    protected volatile void zza(com.google.android.gms.common.api.Client client)
        throws RemoteException
    {
        zza((zzjh)client);
    }

    protected abstract void zza(zzje zzje)
        throws RemoteException;

    protected final void zza(zzjh zzjh1)
        throws RemoteException
    {
        zza(zzjh1.zzgY());
    }

    public piClient(GoogleApiClient googleapiclient)
    {
        super(zzim.zzFC, googleapiclient);
    }
}
