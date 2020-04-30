// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import com.google.android.gms.internal.zzkd;

// Referenced classes of package com.google.android.gms.cast:
//            RemoteMediaPlayer

class zzJw extends zzkd
{

    final RemoteMediaPlayer zzJw;

    protected void onMetadataUpdated()
    {
        RemoteMediaPlayer.zzb(zzJw);
    }

    protected void onStatusUpdated()
    {
        RemoteMediaPlayer.zza(zzJw);
    }

    (RemoteMediaPlayer remotemediaplayer, String s)
    {
        zzJw = remotemediaplayer;
        super(s);
    }
}
