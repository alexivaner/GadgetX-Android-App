// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.HashSet;
import java.util.Set;

public class zzug
    implements android.os.Parcelable.Creator
{

    public zzug()
    {
    }

    static void zza(zztw.zzh zzh, Parcel parcel, int i)
    {
        i = zzb.zzK(parcel);
        Set set = zzh.zzauX;
        if (set.contains(Integer.valueOf(1)))
        {
            zzb.zzc(parcel, 1, zzh.zzFG);
        }
        if (set.contains(Integer.valueOf(3)))
        {
            zzb.zzc(parcel, 3, zzh.zzso());
        }
        if (set.contains(Integer.valueOf(4)))
        {
            zzb.zza(parcel, 4, zzh.mValue, true);
        }
        if (set.contains(Integer.valueOf(5)))
        {
            zzb.zza(parcel, 5, zzh.zzawC, true);
        }
        if (set.contains(Integer.valueOf(6)))
        {
            zzb.zzc(parcel, 6, zzh.zzJp);
        }
        zzb.zzH(parcel, i);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzeK(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzgX(i);
    }

    public zztw.zzh zzeK(Parcel parcel)
    {
        String s = null;
        int i = 0;
        int l = com.google.android.gms.common.internal.safeparcel.zza.zzJ(parcel);
        HashSet hashset = new HashSet();
        int j = 0;
        String s1 = null;
        int k = 0;
        do
        {
            if (parcel.dataPosition() < l)
            {
                int i1 = com.google.android.gms.common.internal.safeparcel.zza.zzI(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.zza.zzaP(i1))
                {
                case 2: // '\002'
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, i1);
                    break;

                case 1: // '\001'
                    k = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, i1);
                    hashset.add(Integer.valueOf(1));
                    break;

                case 3: // '\003'
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, i1);
                    hashset.add(Integer.valueOf(3));
                    break;

                case 4: // '\004'
                    s = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, i1);
                    hashset.add(Integer.valueOf(4));
                    break;

                case 5: // '\005'
                    s1 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, i1);
                    hashset.add(Integer.valueOf(5));
                    break;

                case 6: // '\006'
                    j = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, i1);
                    hashset.add(Integer.valueOf(6));
                    break;
                }
            } else
            {
                if (parcel.dataPosition() != l)
                {
                    throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(l).toString(), parcel);
                }
                return new zztw.zzh(hashset, k, s1, j, s, i);
            }
        } while (true);
    }

    public zztw.zzh[] zzgX(int i)
    {
        return new zztw.zzh[i];
    }
}
