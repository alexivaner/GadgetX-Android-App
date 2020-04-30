// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.internal.zzk;

// Referenced classes of package com.google.android.gms.internal:
//            zzsv

public class zzsx extends zzk
{

    public zzsx(Context context, Looper looper, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
    {
        super(context, looper, 3, connectioncallbacks, onconnectionfailedlistener);
    }

    protected String zzcF()
    {
        return "com.google.android.gms.panorama.service.START";
    }

    protected String zzcG()
    {
        return "com.google.android.gms.panorama.internal.IPanoramaService";
    }

    public zzsv zzct(IBinder ibinder)
    {
        return zzsv.zza.zzcs(ibinder);
    }

    public IInterface zzp(IBinder ibinder)
    {
        return zzct(ibinder);
    }
}
