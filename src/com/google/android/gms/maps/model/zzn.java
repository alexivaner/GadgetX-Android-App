// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.maps.model:
//            PolygonOptions

public class zzn
{

    static void zza(PolygonOptions polygonoptions, Parcel parcel, int i)
    {
        i = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, polygonoptions.getVersionCode());
        zzb.zzc(parcel, 2, polygonoptions.getPoints(), false);
        zzb.zzd(parcel, 3, polygonoptions.zzqJ(), false);
        zzb.zza(parcel, 4, polygonoptions.getStrokeWidth());
        zzb.zzc(parcel, 5, polygonoptions.getStrokeColor());
        zzb.zzc(parcel, 6, polygonoptions.getFillColor());
        zzb.zza(parcel, 7, polygonoptions.getZIndex());
        zzb.zza(parcel, 8, polygonoptions.isVisible());
        zzb.zza(parcel, 9, polygonoptions.isGeodesic());
        zzb.zzH(parcel, i);
    }
}
