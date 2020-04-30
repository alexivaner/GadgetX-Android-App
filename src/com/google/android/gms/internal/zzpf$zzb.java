// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import android.util.Log;

// Referenced classes of package com.google.android.gms.internal:
//            zzpf

private static final class zzand extends zzand
{

    private com.google.android.gms.location.zzanc zzanb;
    private com.google.android.gms.location.zzanc zzanc;
    private zzpf zzand;

    public void zza(int i, String as[])
        throws RemoteException
    {
        if (zzand == null)
        {
            Log.wtf("LocationClientImpl", "onAddGeofenceResult called multiple times");
            return;
        } else
        {
            zzpf zzpf1 = zzand;
            zzpf zzpf2 = zzand;
            zzpf2.getClass();
            zzpf1.zza(new <init>(zzpf2, zzanb, i, as));
            zzand = null;
            zzanb = null;
            zzanc = null;
            return;
        }
    }

    public void zzb(int i, PendingIntent pendingintent)
    {
        if (zzand == null)
        {
            Log.wtf("LocationClientImpl", "onRemoveGeofencesByPendingIntentResult called multiple times");
            return;
        } else
        {
            zzpf zzpf1 = zzand;
            zzpf zzpf2 = zzand;
            zzpf2.getClass();
            zzpf1.zza(new <init>(zzpf2, 1, zzanc, i, pendingintent));
            zzand = null;
            zzanb = null;
            zzanc = null;
            return;
        }
    }

    public void zzb(int i, String as[])
    {
        if (zzand == null)
        {
            Log.wtf("LocationClientImpl", "onRemoveGeofencesByRequestIdsResult called multiple times");
            return;
        } else
        {
            zzpf zzpf1 = zzand;
            zzpf zzpf2 = zzand;
            zzpf2.getClass();
            zzpf1.zza(new <init>(zzpf2, 2, zzanc, i, as));
            zzand = null;
            zzanb = null;
            zzanc = null;
            return;
        }
    }

    public (com.google.android.gms.location. , zzpf zzpf1)
    {
        zzanb = ;
        zzanc = null;
        zzand = zzpf1;
    }

    public zzand(com.google.android.gms.location.zzand zzand1, zzpf zzpf1)
    {
        zzanc = zzand1;
        zzanb = null;
        zzand = zzpf1;
    }
}
