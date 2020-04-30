// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps;

import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.internal.zzl;

// Referenced classes of package com.google.android.gms.maps:
//            GoogleMap

class zza extends com.google.android.gms.maps.internal.>
{

    final oWindowAdapter zzapH;
    final GoogleMap zzapt;

    public zzd zzf(zzl zzl)
    {
        return zze.zzn(zzapH.getInfoWindow(new Marker(zzl)));
    }

    public zzd zzg(zzl zzl)
    {
        return zze.zzn(zzapH.getInfoContents(new Marker(zzl)));
    }

    oWindowAdapter(GoogleMap googlemap, oWindowAdapter owindowadapter)
    {
        zzapt = googlemap;
        zzapH = owindowadapter;
        super();
    }
}
