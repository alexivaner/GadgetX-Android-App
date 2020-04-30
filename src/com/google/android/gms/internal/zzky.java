// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.internal:
//            zzkz, zzla

public class zzky
    implements SafeParcelable
{

    public static final zzkz CREATOR = new zzkz();
    private final int zzFG;
    private final zzla zzQJ;

    zzky(int i, zzla zzla1)
    {
        zzFG = i;
        zzQJ = zzla1;
    }

    private zzky(zzla zzla1)
    {
        zzFG = 1;
        zzQJ = zzla1;
    }

    public static zzky zza(zzld.zzb zzb)
    {
        if (zzb instanceof zzla)
        {
            return new zzky((zzla)zzb);
        } else
        {
            throw new IllegalArgumentException("Unsupported safe parcelable field converter class.");
        }
    }

    public int describeContents()
    {
        zzkz zzkz1 = CREATOR;
        return 0;
    }

    int getVersionCode()
    {
        return zzFG;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzkz zzkz1 = CREATOR;
        zzkz.zza(this, parcel, i);
    }

    zzla zzju()
    {
        return zzQJ;
    }

    public zzld.zzb zzjv()
    {
        if (zzQJ != null)
        {
            return zzQJ;
        } else
        {
            throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
        }
    }

}
