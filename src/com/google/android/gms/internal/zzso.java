// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzk;

// Referenced classes of package com.google.android.gms.internal:
//            zzsn

class zzso extends zzk
{

    public zzso(Context context, Looper looper, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener, zzf zzf)
    {
        super(context, looper, 49, connectioncallbacks, onconnectionfailedlistener, zzf);
    }

    protected String zzcF()
    {
        return "com.google.android.gms.nearby.sharing.service.NearbySharingService.START";
    }

    protected String zzcG()
    {
        return "com.google.android.gms.nearby.sharing.internal.INearbySharingService";
    }

    protected zzsn zzcq(IBinder ibinder)
    {
        return zzsn.zza.zzcp(ibinder);
    }

    public boolean zzjd()
    {
        return true;
    }

    protected IInterface zzp(IBinder ibinder)
    {
        return zzcq(ibinder);
    }
}
