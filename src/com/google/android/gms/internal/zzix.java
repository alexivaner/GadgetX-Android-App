// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.internal:
//            zzjb

public class zzix
    implements android.os.Parcelable.Creator
{

    public zzix()
    {
    }

    static void zza(zziv.zzb zzb1, Parcel parcel, int i)
    {
        int j = zzb.zzK(parcel);
        zzb.zzc(parcel, 1000, zzb1.zzFG);
        zzb.zza(parcel, 1, zzb1.zzGc, i, false);
        zzb.zzc(parcel, 2, zzb1.zzGd, false);
        zzb.zza(parcel, 3, zzb1.zzGe, false);
        zzb.zzH(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzq(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzU(i);
    }

    public zziv.zzb[] zzU(int i)
    {
        return new zziv.zzb[i];
    }

    public zziv.zzb zzq(Parcel parcel)
    {
        String as[];
        Object obj;
        Object obj1;
        int i;
        int j;
        as = null;
        j = com.google.android.gms.common.internal.safeparcel.zza.zzJ(parcel);
        i = 0;
        obj1 = null;
        obj = null;
_L7:
        int k;
        if (parcel.dataPosition() >= j)
        {
            break MISSING_BLOCK_LABEL_194;
        }
        k = com.google.android.gms.common.internal.safeparcel.zza.zzI(parcel);
        com.google.android.gms.common.internal.safeparcel.zza.zzaP(k);
        JVM INSTR lookupswitch 4: default 80
    //                   1: 130
    //                   2: 154
    //                   3: 174
    //                   1000: 109;
           goto _L1 _L2 _L3 _L4 _L5
_L4:
        break MISSING_BLOCK_LABEL_174;
_L5:
        break; /* Loop/switch isn't completed */
_L1:
        com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, k);
        Object obj2 = obj1;
        obj1 = obj;
        obj = obj2;
_L8:
        Object obj3 = obj1;
        obj1 = obj;
        obj = obj3;
        if (true) goto _L7; else goto _L6
_L6:
        i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, k);
        Object obj4 = obj;
        obj = obj1;
        obj1 = obj4;
          goto _L8
_L2:
        Status status = (Status)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, k, Status.CREATOR);
        obj = obj1;
        obj1 = status;
          goto _L8
_L3:
        java.util.ArrayList arraylist = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, k, zzjb.CREATOR);
        obj1 = obj;
        obj = arraylist;
          goto _L8
        as = com.google.android.gms.common.internal.safeparcel.zza.zzA(parcel, k);
        Object obj5 = obj;
        obj = obj1;
        obj1 = obj5;
          goto _L8
        if (parcel.dataPosition() != j)
        {
            throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
        } else
        {
            return new zziv.zzb(i, ((Status) (obj)), ((java.util.List) (obj1)), as);
        }
    }
}
