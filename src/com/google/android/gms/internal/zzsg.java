// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.internal:
//            zzsh, zzru, zzrt

public final class zzsg
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzsh();
    final int versionCode;
    public zzru zzatm;
    public zzrt zzatn;

    zzsg()
    {
        versionCode = 1;
    }

    zzsg(int i, IBinder ibinder, IBinder ibinder1)
    {
        versionCode = i;
        zzatn = zzrt.zza.zzcj(ibinder);
        zzatm = zzru.zza.zzck(ibinder1);
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzsh.zza(this, parcel, i);
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
