// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.PlaceLikelihood;

// Referenced classes of package com.google.android.gms.internal:
//            zzqb, zzpy

public class zzqa
    implements SafeParcelable, PlaceLikelihood
{

    public static final android.os.Parcelable.Creator CREATOR = new zzqb();
    final int zzFG;
    final zzpy zzaoO;
    final float zzaoP;

    zzqa(int i, zzpy zzpy1, float f)
    {
        zzFG = i;
        zzaoO = zzpy1;
        zzaoP = f;
    }

    public static zzqa zza(zzpy zzpy1, float f)
    {
        return new zzqa(0, (zzpy)zzx.zzl(zzpy1), f);
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof zzqa))
            {
                return false;
            }
            obj = (zzqa)obj;
            if (!zzaoO.equals(((zzqa) (obj)).zzaoO) || zzaoP != ((zzqa) (obj)).zzaoP)
            {
                return false;
            }
        }
        return true;
    }

    public Object freeze()
    {
        return zzpX();
    }

    public float getLikelihood()
    {
        return zzaoP;
    }

    public Place getPlace()
    {
        return zzaoO;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            zzaoO, Float.valueOf(zzaoP)
        });
    }

    public boolean isDataValid()
    {
        return true;
    }

    public String toString()
    {
        return zzw.zzk(this).zza("place", zzaoO).zza("likelihood", Float.valueOf(zzaoP)).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzqb.zza(this, parcel, i);
    }

    public PlaceLikelihood zzpX()
    {
        return this;
    }

}
