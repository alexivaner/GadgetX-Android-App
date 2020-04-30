// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.maps.model.internal:
//            zzd

public final class zzc
    implements SafeParcelable
{

    public static final zzd CREATOR = new zzd();
    private int type;
    private final int zzFG;
    private Bundle zzarO;

    zzc(int i, int j, Bundle bundle)
    {
        zzFG = i;
        type = j;
        zzarO = bundle;
    }

    public int describeContents()
    {
        return 0;
    }

    public int getType()
    {
        return type;
    }

    public int getVersionCode()
    {
        return zzFG;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzd.zza(this, parcel, i);
    }

    public Bundle zzqL()
    {
        return zzarO;
    }

}
