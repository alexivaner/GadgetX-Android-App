// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.maps.model:
//            VisibleRegion

public class zzz
{

    static void zza(VisibleRegion visibleregion, Parcel parcel, int i)
    {
        int j = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, visibleregion.getVersionCode());
        zzb.zza(parcel, 2, visibleregion.nearLeft, i, false);
        zzb.zza(parcel, 3, visibleregion.nearRight, i, false);
        zzb.zza(parcel, 4, visibleregion.farLeft, i, false);
        zzb.zza(parcel, 5, visibleregion.farRight, i, false);
        zzb.zza(parcel, 6, visibleregion.latLngBounds, i, false);
        zzb.zzH(parcel, j);
    }
}
