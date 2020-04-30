// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.maps.model:
//            LatLngBounds

public class zzh
{

    static void zza(LatLngBounds latlngbounds, Parcel parcel, int i)
    {
        int j = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, latlngbounds.getVersionCode());
        zzb.zza(parcel, 2, latlngbounds.southwest, i, false);
        zzb.zza(parcel, 3, latlngbounds.northeast, i, false);
        zzb.zzH(parcel, j);
    }
}
