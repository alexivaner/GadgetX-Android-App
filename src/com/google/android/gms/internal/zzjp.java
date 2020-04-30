// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

// Referenced classes of package com.google.android.gms.internal:
//            zzjq, zzjv

public class zzjp
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzjq();
    private final int zzFG;
    private String zzJZ;

    public zzjp()
    {
        this(1, null);
    }

    zzjp(int i, String s)
    {
        zzFG = i;
        zzJZ = s;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }
        if (!(obj instanceof zzjp))
        {
            return false;
        } else
        {
            obj = (zzjp)obj;
            return zzjv.zza(zzJZ, ((zzjp) (obj)).zzJZ);
        }
    }

    public int getVersionCode()
    {
        return zzFG;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            zzJZ
        });
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzjq.zza(this, parcel, i);
    }

    public String zzhl()
    {
        return zzJZ;
    }

}
