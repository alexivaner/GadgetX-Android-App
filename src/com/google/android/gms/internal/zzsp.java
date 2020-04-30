// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            zzsq, zzsm, zzsl

public final class zzsp
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzsq();
    final int versionCode;
    public IBinder zzats;
    public zzsl zzatt;
    public List zzatu;
    public long zzatv;
    public zzsm zzatw;

    zzsp()
    {
        versionCode = 1;
    }

    zzsp(int i, IBinder ibinder, IBinder ibinder1, List list, long l, IBinder ibinder2)
    {
        versionCode = i;
        zzats = ibinder;
        zzatt = zzsl.zza.zzcn(ibinder1);
        zzatu = list;
        zzatv = l;
        zzatw = zzsm.zza.zzco(ibinder2);
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzsq.zza(this, parcel, i);
    }

    IBinder zzrq()
    {
        return zzatw.asBinder();
    }

    IBinder zzru()
    {
        if (zzatt == null)
        {
            return null;
        } else
        {
            return zzatt.asBinder();
        }
    }

}
