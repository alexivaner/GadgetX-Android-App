// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.internal:
//            zzkx

public class zzkw
    implements SafeParcelable
{

    public static final zzkx CREATOR = new zzkx();
    final int zzFG;
    public final String zzQH;
    public final int zzQI;

    public zzkw(int i, String s, int j)
    {
        zzFG = i;
        zzQH = s;
        zzQI = j;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzkx.zza(this, parcel, i);
    }

}
