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
//            zzrv

class zzry extends zzk
{

    zzry(Context context, Looper looper, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener, zzf zzf)
    {
        super(context, looper, 62, connectioncallbacks, onconnectionfailedlistener, zzf);
    }

    protected String zzcF()
    {
        return "com.google.android.gms.nearby.messages.service.NearbyMessagesService.START";
    }

    protected String zzcG()
    {
        return "com.google.android.gms.nearby.messages.internal.INearbyMessagesService";
    }

    protected zzrv zzcm(IBinder ibinder)
    {
        return zzrv.zza.zzcl(ibinder);
    }

    public boolean zzjd()
    {
        return true;
    }

    protected IInterface zzp(IBinder ibinder)
    {
        return zzcm(ibinder);
    }
}
