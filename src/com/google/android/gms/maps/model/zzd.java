// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.maps.model:
//            CircleOptions

public class zzd
{

    static void zza(CircleOptions circleoptions, Parcel parcel, int i)
    {
        int j = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, circleoptions.getVersionCode());
        zzb.zza(parcel, 2, circleoptions.getCenter(), i, false);
        zzb.zza(parcel, 3, circleoptions.getRadius());
        zzb.zza(parcel, 4, circleoptions.getStrokeWidth());
        zzb.zzc(parcel, 5, circleoptions.getStrokeColor());
        zzb.zzc(parcel, 6, circleoptions.getFillColor());
        zzb.zza(parcel, 7, circleoptions.getZIndex());
        zzb.zza(parcel, 8, circleoptions.isVisible());
        zzb.zzH(parcel, j);
    }
}
