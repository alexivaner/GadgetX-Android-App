// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.HashSet;
import java.util.Set;

public class zztz
    implements android.os.Parcelable.Creator
{

    public zztz()
    {
    }

    static void zza(zztw.zzb zzb1, Parcel parcel, int i)
    {
        int j = zzb.zzK(parcel);
        Set set = zzb1.zzauX;
        if (set.contains(Integer.valueOf(1)))
        {
            zzb.zzc(parcel, 1, zzb1.zzFG);
        }
        if (set.contains(Integer.valueOf(2)))
        {
            zzb.zza(parcel, 2, zzb1.zzawq, i, true);
        }
        if (set.contains(Integer.valueOf(3)))
        {
            zzb.zza(parcel, 3, zzb1.zzawr, i, true);
        }
        if (set.contains(Integer.valueOf(4)))
        {
            zzb.zzc(parcel, 4, zzb1.zzaws);
        }
        zzb.zzH(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzeD(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzgQ(i);
    }

    public zztw.zzb zzeD(Parcel parcel)
    {
        zztw.zzb.zzb zzb1 = null;
        int i = 0;
        int k = com.google.android.gms.common.internal.safeparcel.zza.zzJ(parcel);
        HashSet hashset = new HashSet();
        zztw.zzb.zza zza1 = null;
        int j = 0;
        do
        {
            if (parcel.dataPosition() < k)
            {
                int l = com.google.android.gms.common.internal.safeparcel.zza.zzI(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.zza.zzaP(l))
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, l);
                    break;

                case 1: // '\001'
                    j = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, l);
                    hashset.add(Integer.valueOf(1));
                    break;

                case 2: // '\002'
                    zza1 = (zztw.zzb.zza)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, l, zztw.zzb.zza.CREATOR);
                    hashset.add(Integer.valueOf(2));
                    break;

                case 3: // '\003'
                    zzb1 = (zztw.zzb.zzb)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, l, zztw.zzb.zzb.CREATOR);
                    hashset.add(Integer.valueOf(3));
                    break;

                case 4: // '\004'
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, l);
                    hashset.add(Integer.valueOf(4));
                    break;
                }
            } else
            {
                if (parcel.dataPosition() != k)
                {
                    throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(k).toString(), parcel);
                }
                return new zztw.zzb(hashset, j, zza1, zzb1, i);
            }
        } while (true);
    }

    public zztw.zzb[] zzgQ(int i)
    {
        return new zztw.zzb[i];
    }
}
