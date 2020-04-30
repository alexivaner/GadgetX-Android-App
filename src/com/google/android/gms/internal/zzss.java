// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.internal:
//            zzst, zzsm

public final class zzss
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzst();
    final int versionCode;
    public long zzatv;
    public zzsm zzatw;

    zzss()
    {
        versionCode = 1;
    }

    zzss(int i, long l, IBinder ibinder)
    {
        versionCode = i;
        zzatv = l;
        zzatw = zzsm.zza.zzco(ibinder);
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzst.zza(this, parcel, i);
    }

    IBinder zzrq()
    {
        return zzatw.asBinder();
    }

}
