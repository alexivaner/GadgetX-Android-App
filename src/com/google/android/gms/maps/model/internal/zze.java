// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.maps.model.internal:
//            zzf, zza

public final class zze
    implements SafeParcelable
{

    public static final zzf CREATOR = new zzf();
    private final int zzFG;
    private zza zzarQ;

    public zze()
    {
        zzFG = 1;
    }

    zze(int i, zza zza)
    {
        zzFG = i;
        zzarQ = zza;
    }

    public int describeContents()
    {
        return 0;
    }

    int getVersionCode()
    {
        return zzFG;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzf.zza(this, parcel, i);
    }

    public zza zzqM()
    {
        return zzarQ;
    }

}
