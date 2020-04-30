// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            zzol

public class zzok
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzol();
    private final int zzFG;
    private final List zzYA;

    zzok(int i, List list)
    {
        zzFG = i;
        zzYA = list;
    }

    public int describeContents()
    {
        return 0;
    }

    public List getDataTypes()
    {
        return Collections.unmodifiableList(zzYA);
    }

    int getVersionCode()
    {
        return zzFG;
    }

    public String toString()
    {
        return zzw.zzk(this).zza("dataTypes", zzYA).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzol.zza(this, parcel, i);
    }

}
