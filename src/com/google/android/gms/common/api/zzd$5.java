// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;


// Referenced classes of package com.google.android.gms.common.api:
//            ResultCallback, zzd, Status, zzg, 
//            GoogleApiClient, Result

class zzJx
    implements ResultCallback
{

    final GoogleApiClient zzJx;
    final zzd zzNb;
    final zzg zzNd;
    final boolean zzNe;

    public void onResult(Result result)
    {
        zzi((Status)result);
    }

    public void zzi(Status status)
    {
        if (status.isSuccess() && zzNb.isConnected())
        {
            zzNb.reconnect();
        }
        zzNd.setResult(status);
        if (zzNe)
        {
            zzJx.disconnect();
        }
    }

    ApiClient(zzd zzd1, zzg zzg1, boolean flag, GoogleApiClient googleapiclient)
    {
        zzNb = zzd1;
        zzNd = zzg1;
        zzNe = flag;
        zzJx = googleapiclient;
        super();
    }
}
