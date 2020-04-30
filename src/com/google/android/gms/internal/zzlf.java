// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.internal:
//            zzky

public class zzlf
    implements android.os.Parcelable.Creator
{

    public zzlf()
    {
    }

    static void zza(zzld.zza zza1, Parcel parcel, int i)
    {
        int j = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, zza1.getVersionCode());
        zzb.zzc(parcel, 2, zza1.zzjx());
        zzb.zza(parcel, 3, zza1.zzjD());
        zzb.zzc(parcel, 4, zza1.zzjy());
        zzb.zza(parcel, 5, zza1.zzjE());
        zzb.zza(parcel, 6, zza1.zzjF(), false);
        zzb.zzc(parcel, 7, zza1.zzjG());
        zzb.zza(parcel, 8, zza1.zzjI(), false);
        zzb.zza(parcel, 9, zza1.zzjK(), i, false);
        zzb.zzH(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzP(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzaV(i);
    }

    public zzld.zza zzP(Parcel parcel)
    {
        zzky zzky1 = null;
        int i = 0;
        int i1 = com.google.android.gms.common.internal.safeparcel.zza.zzJ(parcel);
        String s = null;
        String s1 = null;
        boolean flag = false;
        int j = 0;
        boolean flag1 = false;
        int k = 0;
        int l = 0;
        do
        {
            if (parcel.dataPosition() < i1)
            {
                int j1 = com.google.android.gms.common.internal.safeparcel.zza.zzI(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.zza.zzaP(j1))
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, j1);
                    break;

                case 1: // '\001'
                    l = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, j1);
                    break;

                case 2: // '\002'
                    k = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, j1);
                    break;

                case 3: // '\003'
                    flag1 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, j1);
                    break;

                case 4: // '\004'
                    j = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, j1);
                    break;

                case 5: // '\005'
                    flag = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, j1);
                    break;

                case 6: // '\006'
                    s1 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, j1);
                    break;

                case 7: // '\007'
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, j1);
                    break;

                case 8: // '\b'
                    s = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, j1);
                    break;

                case 9: // '\t'
                    zzky1 = (zzky)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, j1, zzky.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != i1)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(i1).toString(), parcel);
            } else
            {
                return new zzld.zza(l, k, flag1, j, flag, s1, i, s, zzky1);
            }
        } while (true);
    }

    public zzld.zza[] zzaV(int i)
    {
        return new zzld.zza[i];
    }
}
