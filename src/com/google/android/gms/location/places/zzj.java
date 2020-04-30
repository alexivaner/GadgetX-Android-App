// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.places;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

// Referenced classes of package com.google.android.gms.location.places:
//            zzk

public final class zzj
    implements SafeParcelable
{

    public static final zzk CREATOR = new zzk();
    public static final zzj zzaod;
    public static final zzj zzaoe;
    public static final zzj zzaof;
    public static final Set zzaog;
    final int zzFG;
    final int zzaoh;
    final String zzxV;

    zzj(int i, String s, int j)
    {
        zzx.zzbn(s);
        zzFG = i;
        zzxV = s;
        zzaoh = j;
    }

    private static zzj zzB(String s, int i)
    {
        return new zzj(0, s, i);
    }

    public int describeContents()
    {
        zzk zzk1 = CREATOR;
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof zzj))
            {
                return false;
            }
            obj = (zzj)obj;
            if (!zzxV.equals(((zzj) (obj)).zzxV) || zzaoh != ((zzj) (obj)).zzaoh)
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        return zzxV.hashCode();
    }

    public String toString()
    {
        return zzxV;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzk zzk1 = CREATOR;
        zzk.zza(this, parcel, i);
    }

    static 
    {
        zzaod = zzB("test_type", 1);
        zzaoe = zzB("labeled_place", 6);
        zzaof = zzB("here_content", 7);
        zzaog = Collections.unmodifiableSet(new HashSet(Arrays.asList(new zzj[] {
            zzaod, zzaoe, zzaof
        })));
    }
}
