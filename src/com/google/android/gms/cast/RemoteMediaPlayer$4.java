// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzju;
import com.google.android.gms.internal.zzkd;
import java.io.IOException;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.cast:
//            RemoteMediaPlayer, MediaInfo

class t extends b
{

    final MediaInfo zzJA;
    final boolean zzJB;
    final long zzJC;
    final long zzJD[];
    final JSONObject zzJE;
    final RemoteMediaPlayer zzJw;
    final GoogleApiClient zzJx;

    protected volatile void zza(com.google.android.gms.common.api.t> t>)
        throws RemoteException
    {
        zza((zzju)t>);
    }

    protected void zza(zzju zzju1)
    {
        zzju1 = ((zzju) (RemoteMediaPlayer.zzc(zzJw)));
        zzju1;
        JVM INSTR monitorenter ;
        RemoteMediaPlayer.zzd(zzJw).zzb(zzJx);
        RemoteMediaPlayer.zze(zzJw).zza(zzJN, zzJA, zzJB, zzJC, zzJD, zzJE);
        RemoteMediaPlayer.zzd(zzJw).zzb(null);
_L1:
        zzju1;
        JVM INSTR monitorexit ;
        return;
        Object obj;
        obj;
        setResult(zzj(new Status(2100)));
        RemoteMediaPlayer.zzd(zzJw).zzb(null);
          goto _L1
        obj;
        zzju1;
        JVM INSTR monitorexit ;
        throw obj;
        obj;
        RemoteMediaPlayer.zzd(zzJw).zzb(null);
        throw obj;
    }

    t(RemoteMediaPlayer remotemediaplayer, GoogleApiClient googleapiclient, GoogleApiClient googleapiclient1, MediaInfo mediainfo, boolean flag, long l, 
            long al[], JSONObject jsonobject)
    {
        zzJw = remotemediaplayer;
        zzJx = googleapiclient1;
        zzJA = mediainfo;
        zzJB = flag;
        zzJC = l;
        zzJD = al;
        zzJE = jsonobject;
        super(googleapiclient);
    }
}
