// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps;

import android.os.RemoteException;
import com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate;

// Referenced classes of package com.google.android.gms.maps:
//            StreetViewPanoramaFragment, StreetViewPanorama, OnStreetViewPanoramaReadyCallback

class zzaqs extends com.google.android.gms.maps.internal.
{

    final OnStreetViewPanoramaReadyCallback zzaqs;
    final  zzaqt;

    public void zza(IStreetViewPanoramaDelegate istreetviewpanoramadelegate)
        throws RemoteException
    {
        zzaqs.onStreetViewPanoramaReady(new StreetViewPanorama(istreetviewpanoramadelegate));
    }

    ( , OnStreetViewPanoramaReadyCallback onstreetviewpanoramareadycallback)
    {
        zzaqt = ;
        zzaqs = onstreetviewpanoramareadycallback;
        super();
    }
}
