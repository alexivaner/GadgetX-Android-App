// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.maps.model:
//            MarkerOptions

public class zzl
{

    static void zza(MarkerOptions markeroptions, Parcel parcel, int i)
    {
        int j = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, markeroptions.getVersionCode());
        zzb.zza(parcel, 2, markeroptions.getPosition(), i, false);
        zzb.zza(parcel, 3, markeroptions.getTitle(), false);
        zzb.zza(parcel, 4, markeroptions.getSnippet(), false);
        zzb.zza(parcel, 5, markeroptions.zzqI(), false);
        zzb.zza(parcel, 6, markeroptions.getAnchorU());
        zzb.zza(parcel, 7, markeroptions.getAnchorV());
        zzb.zza(parcel, 8, markeroptions.isDraggable());
        zzb.zza(parcel, 9, markeroptions.isVisible());
        zzb.zzH(parcel, j);
    }
}
