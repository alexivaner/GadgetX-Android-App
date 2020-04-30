// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

// Referenced classes of package com.google.android.gms.internal:
//            zzjx, zzjv

public class zzjw
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzjx();
    private final int zzFG;
    private double zzJm;
    private boolean zzJn;
    private ApplicationMetadata zzKD;
    private int zzKr;
    private int zzKs;

    public zzjw()
    {
        this(3, (0.0D / 0.0D), false, -1, null, -1);
    }

    zzjw(int i, double d, boolean flag, int j, ApplicationMetadata applicationmetadata, int k)
    {
        zzFG = i;
        zzJm = d;
        zzJn = flag;
        zzKr = j;
        zzKD = applicationmetadata;
        zzKs = k;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof zzjw))
            {
                return false;
            }
            obj = (zzjw)obj;
            if (zzJm != ((zzjw) (obj)).zzJm || zzJn != ((zzjw) (obj)).zzJn || zzKr != ((zzjw) (obj)).zzKr || !zzjv.zza(zzKD, ((zzjw) (obj)).zzKD) || zzKs != ((zzjw) (obj)).zzKs)
            {
                return false;
            }
        }
        return true;
    }

    public ApplicationMetadata getApplicationMetadata()
    {
        return zzKD;
    }

    public int getVersionCode()
    {
        return zzFG;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            Double.valueOf(zzJm), Boolean.valueOf(zzJn), Integer.valueOf(zzKr), zzKD, Integer.valueOf(zzKs)
        });
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzjx.zza(this, parcel, i);
    }

    public boolean zzhA()
    {
        return zzJn;
    }

    public int zzhB()
    {
        return zzKr;
    }

    public int zzhC()
    {
        return zzKs;
    }

    public double zzhs()
    {
        return zzJm;
    }

}
