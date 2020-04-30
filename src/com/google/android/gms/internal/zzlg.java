// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzlg
    implements android.os.Parcelable.Creator
{

    public zzlg()
    {
    }

    static void zza(zzlh.zzb zzb1, Parcel parcel, int i)
    {
        int j = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, zzb1.versionCode);
        zzb.zza(parcel, 2, zzb1.zzfv, false);
        zzb.zza(parcel, 3, zzb1.zzRd, i, false);
        zzb.zzH(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzQ(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzaW(i);
    }

    public zzlh.zzb zzQ(Parcel parcel)
    {
        zzld.zza zza1 = null;
        int j = com.google.android.gms.common.internal.safeparcel.zza.zzJ(parcel);
        int i = 0;
        String s = null;
        do
        {
            if (parcel.dataPosition() < j)
            {
                int k = com.google.android.gms.common.internal.safeparcel.zza.zzI(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.zza.zzaP(k))
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, k);
                    break;

                case 1: // '\001'
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, k);
                    break;

                case 2: // '\002'
                    s = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, k);
                    break;

                case 3: // '\003'
                    zza1 = (zzld.zza)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, k, zzld.zza.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new zzlh.zzb(i, s, zza1);
            }
        } while (true);
    }

    public zzlh.zzb[] zzaW(int i)
    {
        return new zzlh.zzb[i];
    }
}
