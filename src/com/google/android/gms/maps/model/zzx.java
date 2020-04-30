// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.maps.model:
//            TileOverlayOptions

public class zzx
{

    static void zza(TileOverlayOptions tileoverlayoptions, Parcel parcel, int i)
    {
        i = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, tileoverlayoptions.getVersionCode());
        zzb.zza(parcel, 2, tileoverlayoptions.zzqK(), false);
        zzb.zza(parcel, 3, tileoverlayoptions.isVisible());
        zzb.zza(parcel, 4, tileoverlayoptions.getZIndex());
        zzb.zzH(parcel, i);
    }
}
