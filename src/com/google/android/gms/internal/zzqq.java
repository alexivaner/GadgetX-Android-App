// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            zzqs

public class zzqq
    implements SafeParcelable
{

    public static final zzqs CREATOR = new zzqs();
    final int zzFG;
    private final String zzHg;
    private final String zzanM;
    private final List zzapk;
    private final List zzapl;
    private final List zzapm;

    zzqq(int i, String s, String s1, List list, List list1, List list2)
    {
        zzFG = i;
        zzHg = s;
        zzanM = s1;
        zzapk = list;
        zzapl = list1;
        zzapm = list2;
    }

    public int describeContents()
    {
        zzqs zzqs1 = CREATOR;
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof zzqq))
            {
                return false;
            }
            obj = (zzqq)obj;
            if (!zzHg.equals(((zzqq) (obj)).zzHg) || !zzanM.equals(((zzqq) (obj)).zzanM) || !zzapk.equals(((zzqq) (obj)).zzapk) || !zzapl.equals(((zzqq) (obj)).zzapl) || !zzapm.equals(((zzqq) (obj)).zzapm))
            {
                return false;
            }
        }
        return true;
    }

    public String getPlaceId()
    {
        return zzanM;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            zzHg, zzanM, zzapk, zzapl, zzapm
        });
    }

    public String toString()
    {
        return zzw.zzk(this).zza("accountName", zzHg).zza("placeId", zzanM).zza("testDataImpls", zzapk).zza("placeAliases", zzapl).zza("hereContents", zzapm).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzqs zzqs1 = CREATOR;
        zzqs.zza(this, parcel, i);
    }

    public String zzpZ()
    {
        return zzHg;
    }

    public List zzqa()
    {
        return zzapl;
    }

    public List zzqb()
    {
        return zzapm;
    }

    public List zzqc()
    {
        return zzapk;
    }

}
