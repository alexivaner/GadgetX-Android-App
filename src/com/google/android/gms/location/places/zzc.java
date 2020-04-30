// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.places;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

// Referenced classes of package com.google.android.gms.location.places:
//            zzd, PlaceFilter

public final class zzc
    implements SafeParcelable
{

    public static final zzd CREATOR = new zzd();
    private final int zzFG;
    private final int zzalN;
    private final int zzanA;
    private final PlaceFilter zzanB;

    zzc(int i, int j, int k, PlaceFilter placefilter)
    {
        zzFG = i;
        zzalN = j;
        zzanA = k;
        zzanB = placefilter;
    }

    public int describeContents()
    {
        zzd zzd1 = CREATOR;
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof zzc))
            {
                return false;
            }
            obj = (zzc)obj;
            if (zzalN != ((zzc) (obj)).zzalN || zzanA != ((zzc) (obj)).zzanA || !zzanB.equals(((zzc) (obj)).zzanB))
            {
                return false;
            }
        }
        return true;
    }

    public int getVersionCode()
    {
        return zzFG;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            Integer.valueOf(zzalN), Integer.valueOf(zzanA)
        });
    }

    public String toString()
    {
        return zzw.zzk(this).zza("transitionTypes", Integer.valueOf(zzalN)).zza("loiteringTimeMillis", Integer.valueOf(zzanA)).zza("placeFilter", zzanB).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzd zzd1 = CREATOR;
        zzd.zza(this, parcel, i);
    }

    public int zzpD()
    {
        return zzalN;
    }

    public int zzpG()
    {
        return zzanA;
    }

    public PlaceFilter zzpH()
    {
        return zzanB;
    }

}
