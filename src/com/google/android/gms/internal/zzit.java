// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.internal:
//            zziu

public class zzit
    implements SafeParcelable
{

    public static final zziu CREATOR = new zziu();
    public final int id;
    final int zzFG;
    final Bundle zzFX;

    zzit(int i, int j, Bundle bundle)
    {
        zzFG = i;
        id = j;
        zzFX = bundle;
    }

    public int describeContents()
    {
        zziu zziu1 = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zziu zziu1 = CREATOR;
        zziu.zza(this, parcel, i);
    }

}
