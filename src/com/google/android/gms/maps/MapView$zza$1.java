// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps;

import android.os.RemoteException;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;

// Referenced classes of package com.google.android.gms.maps:
//            MapView, GoogleMap, OnMapReadyCallback

class za extends com.google.android.gms.maps.internal.
{

    final OnMapReadyCallback zzapY;
    final back zzaqg;

    public void zza(IGoogleMapDelegate igooglemapdelegate)
        throws RemoteException
    {
        zzapY.onMapReady(new GoogleMap(igooglemapdelegate));
    }

    back(back back, OnMapReadyCallback onmapreadycallback)
    {
        zzaqg = back;
        zzapY = onmapreadycallback;
        super();
    }
}
