// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

// Referenced classes of package com.google.android.gms.internal:
//            zzqt, zzqv

public class zzqu extends zzqt
    implements SafeParcelable
{

    public static final zzqv CREATOR = new zzqv();
    final int zzFG;
    private final String zzapn;

    zzqu(int i, String s)
    {
        zzFG = i;
        zzapn = s;
    }

    public int describeContents()
    {
        zzqv zzqv1 = CREATOR;
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (!(obj instanceof zzqu))
        {
            return false;
        } else
        {
            obj = (zzqu)obj;
            return zzapn.equals(((zzqu) (obj)).zzapn);
        }
    }

    public int hashCode()
    {
        return zzapn.hashCode();
    }

    public String toString()
    {
        return zzw.zzk(this).zza("testName", zzapn).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzqv zzqv1 = CREATOR;
        zzqv.zza(this, parcel, i);
    }

    public String zzqd()
    {
        return zzapn;
    }

}
