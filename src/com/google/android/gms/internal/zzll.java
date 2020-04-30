// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.internal:
//            zzlk, zzlh

public class zzll
    implements android.os.Parcelable.Creator
{

    public zzll()
    {
    }

    static void zza(zzlk zzlk1, Parcel parcel, int i)
    {
        int j = zzb.zzK(parcel);
        zzb.zzc(parcel, 1, zzlk1.getVersionCode());
        zzb.zza(parcel, 2, zzlk1.zzjR(), false);
        zzb.zza(parcel, 3, zzlk1.zzjS(), i, false);
        zzb.zzH(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzT(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzaZ(i);
    }

    public zzlk zzT(Parcel parcel)
    {
        zzlh zzlh1 = null;
        int j = com.google.android.gms.common.internal.safeparcel.zza.zzJ(parcel);
        int i = 0;
        Parcel parcel1 = null;
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
                    parcel1 = com.google.android.gms.common.internal.safeparcel.zza.zzD(parcel, k);
                    break;

                case 3: // '\003'
                    zzlh1 = (zzlh)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, k, zzlh.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new zzlk(i, parcel1, zzlh1);
            }
        } while (true);
    }

    public zzlk[] zzaZ(int i)
    {
        return new zzlk[i];
    }
}
