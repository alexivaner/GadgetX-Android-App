// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

// Referenced classes of package com.google.android.gms.internal:
//            zzrx, zzro

public class zzrw
    implements SafeParcelable
{

    public static final zzrx CREATOR = new zzrx();
    final int versionCode;
    public final zzro zzati;

    zzrw(int i, zzro zzro1)
    {
        versionCode = i;
        zzati = (zzro)zzx.zzl(zzro1);
    }

    public int describeContents()
    {
        zzrx zzrx1 = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzrx zzrx1 = CREATOR;
        zzrx.zza(this, parcel, i);
    }

}
