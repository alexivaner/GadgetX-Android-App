// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location;

import android.content.Intent;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzc;

// Referenced classes of package com.google.android.gms.location:
//            zzk

public class LocationSettingsStates
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzk();
    private final int zzFG;
    private final boolean zzamq;
    private final boolean zzamr;
    private final boolean zzams;
    private final boolean zzamt;
    private final boolean zzamu;
    private final boolean zzamv;

    LocationSettingsStates(int i, boolean flag, boolean flag1, boolean flag2, boolean flag3, boolean flag4, boolean flag5)
    {
        zzFG = i;
        zzamq = flag;
        zzamr = flag1;
        zzams = flag2;
        zzamt = flag3;
        zzamu = flag4;
        zzamv = flag5;
    }

    public static LocationSettingsStates fromIntent(Intent intent)
    {
        return (LocationSettingsStates)zzc.zza(intent, "com.google.android.gms.location.LOCATION_SETTINGS_STATES", CREATOR);
    }

    public int describeContents()
    {
        return 0;
    }

    public int getVersionCode()
    {
        return zzFG;
    }

    public boolean isBlePresent()
    {
        return zzamv;
    }

    public boolean isBleUsable()
    {
        return zzams;
    }

    public boolean isGpsPresent()
    {
        return zzamt;
    }

    public boolean isGpsUsable()
    {
        return zzamq;
    }

    public boolean isLocationPresent()
    {
        return zzamt || zzamu;
    }

    public boolean isLocationUsable()
    {
        return zzamq || zzamr;
    }

    public boolean isNetworkLocationPresent()
    {
        return zzamu;
    }

    public boolean isNetworkLocationUsable()
    {
        return zzamr;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzk.zza(this, parcel, i);
    }

}
