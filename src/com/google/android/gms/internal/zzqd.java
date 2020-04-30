// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            zzqe

public final class zzqd
    implements SafeParcelable
{

    public static final zzqe CREATOR = new zzqe();
    public final String name;
    public final int versionCode;
    public final String zzaoQ;
    public final String zzaoR;
    public final String zzaoS;
    public final List zzaoT;

    public zzqd(int i, String s, String s1, String s2, String s3, List list)
    {
        versionCode = i;
        name = s;
        zzaoQ = s1;
        zzaoR = s2;
        zzaoS = s3;
        zzaoT = list;
    }

    public static zzqd zza(String s, String s1, String s2, String s3, List list)
    {
        return new zzqd(0, s, s1, s2, s3, list);
    }

    public int describeContents()
    {
        zzqe zzqe1 = CREATOR;
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof zzqd))
            {
                return false;
            }
            obj = (zzqd)obj;
            if (!zzw.equal(name, ((zzqd) (obj)).name) || !zzw.equal(zzaoQ, ((zzqd) (obj)).zzaoQ) || !zzw.equal(zzaoR, ((zzqd) (obj)).zzaoR) || !zzw.equal(zzaoS, ((zzqd) (obj)).zzaoS) || !zzw.equal(zzaoT, ((zzqd) (obj)).zzaoT))
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            name, zzaoQ, zzaoR, zzaoS
        });
    }

    public String toString()
    {
        return zzw.zzk(this).zza("name", name).zza("address", zzaoQ).zza("internationalPhoneNumber", zzaoR).zza("regularOpenHours", zzaoS).zza("attributions", zzaoT).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzqe zzqe1 = CREATOR;
        zzqe.zza(this, parcel, i);
    }

}
