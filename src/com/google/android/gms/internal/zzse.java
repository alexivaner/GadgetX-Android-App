// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.internal:
//            zzsf, zzru, zzrw

public final class zzse
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzsf();
    final int versionCode;
    public zzrw zzatk;
    public zzru zzatm;

    zzse()
    {
        versionCode = 1;
    }

    zzse(int i, zzrw zzrw, IBinder ibinder)
    {
        versionCode = i;
        zzatk = zzrw;
        zzatm = zzru.zza.zzck(ibinder);
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzsf.zza(this, parcel, i);
    }

    IBinder zzrq()
    {
        return zzatm.asBinder();
    }

}
