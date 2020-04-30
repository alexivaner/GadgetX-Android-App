// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import com.google.android.gms.common.ConnectionResult;

// Referenced classes of package com.google.android.gms.common.api:
//            zzd, Status, zzg

class zzNd
    implements ApiClient.OnConnectionFailedListener
{

    final zzd zzNb;
    final zzg zzNd;

    public void onConnectionFailed(ConnectionResult connectionresult)
    {
        zzNd.setResult(new Status(8));
    }

    Result(zzd zzd1, zzg zzg1)
    {
        zzNb = zzd1;
        zzNd = zzg1;
        super();
    }
}
