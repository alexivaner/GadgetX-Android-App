// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.internal;

import android.graphics.Point;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.maps.internal:
//            zzz

public class zzy
    implements SafeParcelable
{

    public static final zzz CREATOR = new zzz();
    private final int versionCode;
    private final Point zzaqO;

    public zzy(int i, Point point)
    {
        versionCode = i;
        zzaqO = point;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (!(obj instanceof zzy))
        {
            return false;
        } else
        {
            obj = (zzy)obj;
            return zzaqO.equals(((zzy) (obj)).zzaqO);
        }
    }

    int getVersionCode()
    {
        return versionCode;
    }

    public int hashCode()
    {
        return zzaqO.hashCode();
    }

    public String toString()
    {
        return zzaqO.toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzz.zza(this, parcel, i);
    }

    public Point zzqE()
    {
        return zzaqO;
    }

}
