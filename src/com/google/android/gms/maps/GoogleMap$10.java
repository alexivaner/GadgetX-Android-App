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

    final arkerClickListener zzapE;
    final GoogleMap zzapt;

    public boolean zza(zzl zzl)
    {
        return zzapE.onMarkerClick(new Marker(zzl));
    }

    arkerClickListener(GoogleMap googlemap, arkerClickListener arkerclicklistener)
    {
        zzapt = googlemap;
        zzapE = arkerclicklistener;
        super();
    }
}
