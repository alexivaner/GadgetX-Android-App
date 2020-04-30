// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.internal:
//            zzsd, zzru, zzrt, zzrr

public final class zzsc
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzsd();
    final int versionCode;
    public zzrr zzatl;
    public zzru zzatm;
    public zzrt zzatn;

    zzsc()
    {
        versionCode = 1;
    }

    zzsc(int i, IBinder ibinder, zzrr zzrr1, IBinder ibinder1)
    {
        versionCode = i;
        zzatn = zzrt.zza.zzcj(ibinder);
        zzatl = zzrr1;
        zzatm = zzru.zza.zzck(ibinder1);
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzsd.zza(this, parcel, i);
    }

    IBinder zzrq()
    {
        return zzatm.asBinder();
    }

    IBinder zzrr()
    {
        return zzatn.asBinder();
    }

}
