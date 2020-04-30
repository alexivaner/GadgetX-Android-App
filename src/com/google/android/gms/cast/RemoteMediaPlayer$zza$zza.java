// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzkd;

// Referenced classes of package com.google.android.gms.cast:
//            RemoteMediaPlayer

private final class zzJL
    implements ResultCallback
{

    private final long zzJL;
    final  zzJM;

    public void onResult(Result result)
    {
        zzi((Status)result);
    }

    public void zzi(Status status)
    {
        if (!status.isSuccess())
        {
            RemoteMediaPlayer.zze(zzJM.).zzb(zzJL, status.getStatusCode());
        }
    }

    ( , long l)
    {
        zzJM = ;
        super();
        zzJL = l;
    }
}
