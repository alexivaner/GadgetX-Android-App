// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

// Referenced classes of package com.google.android.gms.internal:
//            zzqp

public class zzqo
    implements SafeParcelable
{

    public static final zzqp CREATOR = new zzqp();
    public static final zzqo zzaph = new zzqo(0, "Home");
    public static final zzqo zzapi = new zzqo(0, "Work");
    final int zzFG;
    private final String zzapj;

    zzqo(int i, String s)
    {
        zzFG = i;
        zzapj = s;
    }

    public int describeContents()
    {
        zzqp zzqp1 = CREATOR;
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (!(obj instanceof zzqo))
        {
            return false;
        } else
        {
            obj = (zzqo)obj;
            return zzw.equal(zzapj, ((zzqo) (obj)).zzapj);
        }
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            zzapj
        });
    }

    public String toString()
    {
        return zzw.zzk(this).zza("alias", zzapj).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzqp zzqp1 = CREATOR;
        zzqp.zza(this, parcel, i);
    }

    public String zzpY()
    {
        return zzapj;
    }

}
