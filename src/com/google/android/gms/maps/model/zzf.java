// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.maps.model:
//            GroundOverlayOptions

public class zzf
{

    static void zza(GroundOverlayOptions groundoverlayoptions, Parcel parcel, int i)
    {
        int j = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, groundoverlayoptions.getVersionCode());
        zzb.zza(parcel, 2, groundoverlayoptions.zzqH(), false);
        zzb.zza(parcel, 3, groundoverlayoptions.getLocation(), i, false);
        zzb.zza(parcel, 4, groundoverlayoptions.getWidth());
        zzb.zza(parcel, 5, groundoverlayoptions.getHeight());
        zzb.zza(parcel, 6, groundoverlayoptions.getBounds(), i, false);
        zzb.zza(parcel, 7, groundoverlayoptions.getBearing());
        zzb.zza(parcel, 8, groundoverlayoptions.getZIndex());
        zzb.zza(parcel, 9, groundoverlayoptions.isVisible());
        zzb.zza(parcel, 10, groundoverlayoptions.getTransparency());
        zzb.zza(parcel, 11, groundoverlayoptions.getAnchorU());
        zzb.zza(parcel, 12, groundoverlayoptions.getAnchorV());
        zzb.zzH(parcel, j);
    }
}
