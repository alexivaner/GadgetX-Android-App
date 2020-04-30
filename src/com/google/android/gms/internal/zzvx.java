// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.internal:
//            zzvy

public final class zzvx
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzvy();
    private final int zzFG;
    int zzaEq[];

    zzvx()
    {
        this(1, null);
    }

    zzvx(int i, int ai[])
    {
        zzFG = i;
        zzaEq = ai;
    }

    public int describeContents()
    {
        return 0;
    }

    public int getVersionCode()
    {
        return zzFG;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzvy.zza(this, parcel, i);
    }

}
