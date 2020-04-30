// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.internal:
//            zzjb, zzip, zzin

public class zzjc
    implements android.os.Parcelable.Creator
{

    public zzjc()
    {
    }

    static void zza(zzjb zzjb1, Parcel parcel, int i)
    {
        int j = zzb.zzK(parcel);
        zzb.zza(parcel, 1, zzjb1.zzGw, i, false);
        zzb.zzc(parcel, 1000, zzjb1.zzFG);
        zzb.zza(parcel, 2, zzjb1.zzGx);
        zzb.zzc(parcel, 3, zzjb1.zzGy);
        zzb.zza(parcel, 4, zzjb1.zzpZ, false);
        zzb.zza(parcel, 5, zzjb1.zzGz, i, false);
        zzb.zza(parcel, 6, zzjb1.zzGA);
        zzb.zzc(parcel, 7, zzjb1.zzGB);
        zzb.zzH(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzs(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzY(i);
    }

    public zzjb[] zzY(int i)
    {
        return new zzjb[i];
    }

    public zzjb zzs(Parcel parcel)
    {
        zzin zzin1 = null;
        boolean flag = false;
        int l = com.google.android.gms.common.internal.safeparcel.zza.zzJ(parcel);
        long l1 = 0L;
        int i = -1;
        String s = null;
        int j = 0;
        zzip zzip1 = null;
        int k = 0;
        do
        {
            if (parcel.dataPosition() < l)
            {
                int i1 = com.google.android.gms.common.internal.safeparcel.zza.zzI(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.zza.zzaP(i1))
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, i1);
                    break;

                case 1: // '\001'
                    zzip1 = (zzip)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, i1, zzip.CREATOR);
                    break;

                case 1000: 
                    k = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, i1);
                    break;

                case 2: // '\002'
                    l1 = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, i1);
                    break;

                case 3: // '\003'
                    j = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, i1);
                    break;

                case 4: // '\004'
                    s = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, i1);
                    break;

                case 5: // '\005'
                    zzin1 = (zzin)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, i1, zzin.CREATOR);
                    break;

                case 6: // '\006'
                    flag = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, i1);
                    break;

                case 7: // '\007'
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, i1);
                    break;
                }
            } else
            if (parcel.dataPosition() != l)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(l).toString(), parcel);
            } else
            {
                return new zzjb(k, zzip1, l1, j, s, zzin1, flag, i);
            }
        } while (true);
    }
}
