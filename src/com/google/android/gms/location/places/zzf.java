// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.places;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.google.android.gms.location.places:
//            zzg, PlaceFilter

public final class zzf
    implements SafeParcelable
{

    public static final zzg CREATOR = new zzg();
    static final long zzanO;
    private final int mPriority;
    final int zzFG;
    private final long zzalO;
    private final long zzamf;
    private final PlaceFilter zzanP;

    public zzf(int i, PlaceFilter placefilter, long l, int j, long l1)
    {
        zzFG = i;
        zzanP = placefilter;
        zzamf = l;
        mPriority = j;
        zzalO = l1;
    }

    public int describeContents()
    {
        zzg zzg1 = CREATOR;
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof zzf))
            {
                return false;
            }
            obj = (zzf)obj;
            if (!zzw.equal(zzanP, ((zzf) (obj)).zzanP) || zzamf != ((zzf) (obj)).zzamf || mPriority != ((zzf) (obj)).mPriority || zzalO != ((zzf) (obj)).zzalO)
            {
                return false;
            }
        }
        return true;
    }

    public long getExpirationTime()
    {
        return zzalO;
    }

    public long getInterval()
    {
        return zzamf;
    }

    public int getPriority()
    {
        return mPriority;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            zzanP, Long.valueOf(zzamf), Integer.valueOf(mPriority), Long.valueOf(zzalO)
        });
    }

    public String toString()
    {
        return zzw.zzk(this).zza("filter", zzanP).zza("interval", Long.valueOf(zzamf)).zza("priority", Integer.valueOf(mPriority)).zza("expireAt", Long.valueOf(zzalO)).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzg zzg1 = CREATOR;
        zzg.zza(this, parcel, i);
    }

    public PlaceFilter zzpH()
    {
        return zzanP;
    }

    static 
    {
        zzanO = TimeUnit.HOURS.toMillis(1L);
    }
}
