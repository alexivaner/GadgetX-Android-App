// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.HashSet;
import java.util.Set;

// Referenced classes of package com.google.android.gms.internal:
//            zztt, zztr

public class zztu
    implements android.os.Parcelable.Creator
{

    public zztu()
    {
    }

    static void zza(zztt zztt1, Parcel parcel, int i)
    {
        int j = zzb.zzK(parcel);
        Set set = zztt1.zzauX;
        if (set.contains(Integer.valueOf(1)))
        {
            zzb.zzc(parcel, 1, zztt1.zzFG);
        }
        if (set.contains(Integer.valueOf(2)))
        {
            zzb.zza(parcel, 2, zztt1.zzFA, true);
        }
        if (set.contains(Integer.valueOf(4)))
        {
            zzb.zza(parcel, 4, zztt1.zzavS, i, true);
        }
        if (set.contains(Integer.valueOf(5)))
        {
            zzb.zza(parcel, 5, zztt1.zzavK, true);
        }
        if (set.contains(Integer.valueOf(6)))
        {
            zzb.zza(parcel, 6, zztt1.zzavT, i, true);
        }
        if (set.contains(Integer.valueOf(7)))
        {
            zzb.zza(parcel, 7, zztt1.zzxV, true);
        }
        zzb.zzH(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzeA(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzgN(i);
    }

    public zztt zzeA(Parcel parcel)
    {
        String s = null;
        int j = com.google.android.gms.common.internal.safeparcel.zza.zzJ(parcel);
        HashSet hashset = new HashSet();
        int i = 0;
        zztr zztr1 = null;
        String s1 = null;
        zztr zztr2 = null;
        String s2 = null;
        do
        {
            if (parcel.dataPosition() < j)
            {
                int k = com.google.android.gms.common.internal.safeparcel.zza.zzI(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.zza.zzaP(k))
                {
                case 3: // '\003'
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, k);
                    break;

                case 1: // '\001'
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, k);
                    hashset.add(Integer.valueOf(1));
                    break;

                case 2: // '\002'
                    s2 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, k);
                    hashset.add(Integer.valueOf(2));
                    break;

                case 4: // '\004'
                    zztr2 = (zztr)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, k, zztr.CREATOR);
                    hashset.add(Integer.valueOf(4));
                    break;

                case 5: // '\005'
                    s1 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, k);
                    hashset.add(Integer.valueOf(5));
                    break;

                case 6: // '\006'
                    zztr1 = (zztr)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, k, zztr.CREATOR);
                    hashset.add(Integer.valueOf(6));
                    break;

                case 7: // '\007'
                    s = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, k);
                    hashset.add(Integer.valueOf(7));
                    break;
                }
            } else
            {
                if (parcel.dataPosition() != j)
                {
                    throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
                }
                return new zztt(hashset, i, s2, zztr2, s1, zztr1, s);
            }
        } while (true);
    }

    public zztt[] zzgN(int i)
    {
        return new zztt[i];
    }
}
