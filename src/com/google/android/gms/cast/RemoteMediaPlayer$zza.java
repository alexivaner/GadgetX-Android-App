// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzkd;
import com.google.android.gms.internal.zzke;
import java.io.IOException;

// Referenced classes of package com.google.android.gms.cast:
//            RemoteMediaPlayer, Cast

private class zzJK
    implements zzke
{
    private final class zza
        implements ResultCallback
    {

        private final long zzJL;
        final RemoteMediaPlayer.zza zzJM;

        public void onResult(Result result)
        {
            zzi((Status)result);
        }

        public void zzi(Status status)
        {
            if (!status.isSuccess())
            {
                RemoteMediaPlayer.zze(zzJM.zzJw).zzb(zzJL, status.getStatusCode());
            }
        }

        zza(long l)
        {
            zzJM = RemoteMediaPlayer.zza.this;
            super();
            zzJL = l;
        }
    }


    private GoogleApiClient zzJJ;
    private long zzJK;
    final RemoteMediaPlayer zzJw;

    public void zza(String s, String s1, long l, String s2)
        throws IOException
    {
        if (zzJJ == null)
        {
            throw new IOException("No GoogleApiClient available");
        } else
        {
            Cast.CastApi.ge(zzJJ, s, s1).setResultCallback(new zza(l));
            return;
        }
    }

    public void zzb(GoogleApiClient googleapiclient)
    {
        zzJJ = googleapiclient;
    }

    public long zzhk()
    {
        long l = zzJK + 1L;
        zzJK = l;
        return l;
    }

    public zza.zzJL(RemoteMediaPlayer remotemediaplayer)
    {
        zzJw = remotemediaplayer;
        super();
        zzJK = 0L;
    }
}
