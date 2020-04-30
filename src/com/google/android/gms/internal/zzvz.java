// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.internal:
//            zzwa

public final class zzvz
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzwa();
    private final int zzFG;
    String zzaEr[];
    byte zzaEs[][];

    zzvz()
    {
        this(1, new String[0], new byte[0][]);
    }

    zzvz(int i, String as[], byte abyte0[][])
    {
        zzFG = i;
        zzaEr = as;
        zzaEs = abyte0;
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
        zzwa.zza(this, parcel, i);
    }

}
