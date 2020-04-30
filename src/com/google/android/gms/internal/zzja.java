// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.internal:
//            zziz, zzit

public class zzja
    implements android.os.Parcelable.Creator
{

    public zzja()
    {
    }

    static void zza(zziz zziz1, Parcel parcel, int i)
    {
        int j = zzb.zzK(parcel);
        zzb.zza(parcel, 1, zziz1.name, false);
        zzb.zzc(parcel, 1000, zziz1.zzFG);
        zzb.zza(parcel, 2, zziz1.zzGh, false);
        zzb.zza(parcel, 3, zziz1.zzGi);
        zzb.zzc(parcel, 4, zziz1.weight);
        zzb.zza(parcel, 5, zziz1.zzGj);
        zzb.zza(parcel, 6, zziz1.zzGk, false);
        zzb.zza(parcel, 7, zziz1.zzGl, i, false);
        zzb.zza(parcel, 8, zziz1.zzGm, false);
        zzb.zza(parcel, 11, zziz1.zzGn, false);
        zzb.zzH(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzr(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzX(i);
    }

    public zziz[] zzX(int i)
    {
        return new zziz[i];
    }

    public zziz zzr(Parcel parcel)
    {
        boolean flag = false;
        String s = null;
        int k = com.google.android.gms.common.internal.safeparcel.zza.zzJ(parcel);
        int i = 1;
        int ai[] = null;
        zzit azzit[] = null;
        String s1 = null;
        boolean flag1 = false;
        String s2 = null;
        String s3 = null;
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
                    s3 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, l);
                    break;

                case 1000: 
                    j = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, l);
                    break;

                case 2: // '\002'
                    s2 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, l);
                    break;

                case 3: // '\003'
                    flag1 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, l);
                    break;

                case 4: // '\004'
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, l);
                    break;

                case 5: // '\005'
                    flag = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, l);
                    break;

                case 6: // '\006'
                    s1 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, l);
                    break;

                case 7: // '\007'
                    azzit = (zzit[])com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, l, zzit.CREATOR);
                    break;

                case 8: // '\b'
                    ai = com.google.android.gms.common.internal.safeparcel.zza.zzu(parcel, l);
                    break;

                case 11: // '\013'
                    s = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, l);
                    break;
                }
            } else
            if (parcel.dataPosition() != k)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(k).toString(), parcel);
            } else
            {
                return new zziz(j, s3, s2, flag1, i, flag, s1, azzit, ai, s);
            }
        } while (true);
    }
}
