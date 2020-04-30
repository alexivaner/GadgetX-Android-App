// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.maps.model.internal:
//            zzq, zza

public final class zzp
    implements SafeParcelable
{

    public static final zzq CREATOR = new zzq();
    private final int zzFG;
    private zza zzarR;

    public zzp()
    {
        zzFG = 1;
    }

    zzp(int i, zza zza)
    {
        zzFG = i;
        zzarR = zza;
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
        zzq.zza(this, parcel, i);
    }

    public zza zzqO()
    {
        return zzarR;
    }

}
