// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import com.google.android.gms.common.internal.zzx;

// Referenced classes of package com.google.android.gms.maps.model:
//            LatLngBounds, LatLng

public static final class zzarr
{

    private double zzaro;
    private double zzarp;
    private double zzarq;
    private double zzarr;

    private boolean zzd(double d)
    {
        boolean flag = false;
        if (zzarq <= zzarr)
        {
            return zzarq <= d && d <= zzarr;
        }
        if (zzarq <= d || d <= zzarr)
        {
            flag = true;
        }
        return flag;
    }

    public LatLngBounds build()
    {
        boolean flag;
        if (!Double.isNaN(zzarq))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zza(flag, "no included points");
        return new LatLngBounds(new LatLng(zzaro, zzarq), new LatLng(zzarp, zzarr));
    }

    public zzarr include(LatLng latlng)
    {
        zzaro = Math.min(zzaro, latlng.latitude);
        zzarp = Math.max(zzarp, latlng.latitude);
        double d = latlng.longitude;
        if (Double.isNaN(zzarq))
        {
            zzarq = d;
            zzarr = d;
        } else
        if (!zzd(d))
        {
            if (LatLngBounds.zzd(zzarq, d) < LatLngBounds.zze(zzarr, d))
            {
                zzarq = d;
                return this;
            } else
            {
                zzarr = d;
                return this;
            }
        }
        return this;
    }

    public ()
    {
        zzaro = (1.0D / 0.0D);
        zzarp = (-1.0D / 0.0D);
        zzarq = (0.0D / 0.0D);
        zzarr = (0.0D / 0.0D);
    }
}
