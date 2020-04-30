// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps;

import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.internal.zzl;

// Referenced classes of package com.google.android.gms.maps:
//            GoogleMap

class zza extends com.google.android.gms.maps.internal.>
{

    final arkerDragListener zzapF;
    final GoogleMap zzapt;

    public void zzb(zzl zzl)
    {
        zzapF.onMarkerDragStart(new Marker(zzl));
    }

    public void zzc(zzl zzl)
    {
        zzapF.onMarkerDragEnd(new Marker(zzl));
    }

    public void zzd(zzl zzl)
    {
        zzapF.onMarkerDrag(new Marker(zzl));
    }

    arkerDragListener(GoogleMap googlemap, arkerDragListener arkerdraglistener)
    {
        zzapt = googlemap;
        zzapF = arkerdraglistener;
        super();
    }
}
