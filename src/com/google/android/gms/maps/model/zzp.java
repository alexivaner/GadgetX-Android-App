// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.maps.model:
//            PolylineOptions

public class zzp
{

    static void zza(PolylineOptions polylineoptions, Parcel parcel, int i)
    {
        i = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, polylineoptions.getVersionCode());
        zzb.zzc(parcel, 2, polylineoptions.getPoints(), false);
        zzb.zza(parcel, 3, polylineoptions.getWidth());
        zzb.zzc(parcel, 4, polylineoptions.getColor());
        zzb.zza(parcel, 5, polylineoptions.getZIndex());
        zzb.zza(parcel, 6, polylineoptions.isVisible());
        zzb.zza(parcel, 7, polylineoptions.isGeodesic());
        zzb.zzH(parcel, i);
    }
}
