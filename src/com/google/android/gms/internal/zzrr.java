// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.internal:
//            zzrs

public class zzrr
    implements SafeParcelable
{
    public static class zza
    {

        private int zzatf;
        private int zzatg;
        private int zzath;

        public zzrr zzrp()
        {
            return new zzrr(1, zzatf, zzatg, zzath);
        }

        public zza()
        {
            zzatf = 1;
            zzatg = 300;
            zzath = 0;
        }
    }


    public static final zzrs CREATOR = new zzrs();
    final int versionCode;
    final int zzatf;
    final int zzatg;
    final int zzath;

    zzrr(int i, int j, int k, int l)
    {
        versionCode = i;
        zzatf = j;
        zzatg = k;
        zzath = l;
    }

    public int describeContents()
    {
        zzrs zzrs1 = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzrs zzrs1 = CREATOR;
        zzrs.zza(this, parcel, i);
    }

}
