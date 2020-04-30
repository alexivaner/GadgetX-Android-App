// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.fitness.data.RawBucket;

// Referenced classes of package com.google.android.gms.internal:
//            zzmv, zzmw

public class zzms
{

    public static zzxd.zza zzb(RawBucket rawbucket)
    {
        zzxd.zza zza1 = new zzxd.zza();
        zza1.zzaIq = rawbucket.zzON;
        zza1.zzaIr = rawbucket.zzYq;
        zzxe.zza zza;
        if (rawbucket.zzYs == null)
        {
            zza = null;
        } else
        {
            zza = zzmw.zzZW.zzb(rawbucket.zzYs);
        }
        zza1.zzaIt = zza;
        zza1.zzaIu = rawbucket.zzZI;
        zza1.zzaIv = zzmv.zzm(rawbucket.zzYD);
        zza1.zzaIx = rawbucket.zzYF;
        zza1.zzaIw = rawbucket.zzYE;
        return zza1;
    }
}
