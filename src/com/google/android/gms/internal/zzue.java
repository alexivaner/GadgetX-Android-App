// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.HashSet;
import java.util.Set;

public class zzue
    implements android.os.Parcelable.Creator
{

    public zzue()
    {
    }

    static void zza(zztw.zzf zzf, Parcel parcel, int i)
    {
        i = zzb.zzK(parcel);
        Set set = zzf.zzauX;
        if (set.contains(Integer.valueOf(1)))
        {
            zzb.zzc(parcel, 1, zzf.zzFG);
        }
        if (set.contains(Integer.valueOf(2)))
        {
            zzb.zza(parcel, 2, zzf.zzawz, true);
        }
        if (set.contains(Integer.valueOf(3)))
        {
            zzb.zza(parcel, 3, zzf.zzZO, true);
        }
        if (set.contains(Integer.valueOf(4)))
        {
            zzb.zza(parcel, 4, zzf.zzavu, true);
        }
        if (set.contains(Integer.valueOf(5)))
        {
            zzb.zza(parcel, 5, zzf.zzawA, true);
        }
        if (set.contains(Integer.valueOf(6)))
        {
            zzb.zza(parcel, 6, zzf.mName, true);
        }
        if (set.contains(Integer.valueOf(7)))
        {
            zzb.zza(parcel, 7, zzf.zzawB);
        }
        if (set.contains(Integer.valueOf(8)))
        {
            zzb.zza(parcel, 8, zzf.zzavK, true);
        }
        if (set.contains(Integer.valueOf(9)))
        {
            zzb.zza(parcel, 9, zzf.zzSy, true);
        }
        if (set.contains(Integer.valueOf(10)))
        {
            zzb.zzc(parcel, 10, zzf.zzJp);
        }
        zzb.zzH(parcel, i);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzeI(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzgV(i);
    }

    public zztw.zzf zzeI(Parcel parcel)
    {
        int i = 0;
        String s = null;
        int k = com.google.android.gms.common.internal.safeparcel.zza.zzJ(parcel);
        HashSet hashset = new HashSet();
        String s1 = null;
        boolean flag = false;
        String s2 = null;
        String s3 = null;
        String s4 = null;
        String s5 = null;
        String s6 = null;
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
                    s6 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, l);
                    hashset.add(Integer.valueOf(2));
                    break;

                case 3: // '\003'
                    s5 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, l);
                    hashset.add(Integer.valueOf(3));
                    break;

                case 4: // '\004'
                    s4 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, l);
                    hashset.add(Integer.valueOf(4));
                    break;

                case 5: // '\005'
                    s3 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, l);
                    hashset.add(Integer.valueOf(5));
                    break;

                case 6: // '\006'
                    s2 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, l);
                    hashset.add(Integer.valueOf(6));
                    break;

                case 7: // '\007'
                    flag = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, l);
                    hashset.add(Integer.valueOf(7));
                    break;

                case 8: // '\b'
                    s1 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, l);
                    hashset.add(Integer.valueOf(8));
                    break;

                case 9: // '\t'
                    s = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, l);
                    hashset.add(Integer.valueOf(9));
                    break;

                case 10: // '\n'
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, l);
                    hashset.add(Integer.valueOf(10));
                    break;
                }
            } else
            {
                if (parcel.dataPosition() != k)
                {
                    throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(k).toString(), parcel);
                }
                return new zztw.zzf(hashset, j, s6, s5, s4, s3, s2, flag, s1, s, i);
            }
        } while (true);
    }

    public zztw.zzf[] zzgV(int i)
    {
        return new zztw.zzf[i];
    }
}
