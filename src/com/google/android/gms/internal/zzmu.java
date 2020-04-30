// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.fitness.data.RawDataPoint;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            zzmt, zzmx

public class zzmu
{

    public static RawDataPoint zza(zzxc.zzd azzd[], zzxd.zzb zzb1)
    {
        return new RawDataPoint(4, zzb1.zzaIA, zzmt.zza(zzb1), zzmx.zza(azzd, zzb1.zzaIC), zzb1.zzaID, zzb1.zzaIF, zzmt.zzb(zzb1), zzmt.zzc(zzb1));
    }

    public static List zza(zzxc.zzd azzd[], zzxd.zzb azzb[])
    {
        ArrayList arraylist = new ArrayList(azzb.length);
        int j = azzb.length;
        for (int i = 0; i < j; i++)
        {
            arraylist.add(zza(azzd, azzb[i]));
        }

        return arraylist;
    }

    public static zzxd.zzb zzb(RawDataPoint rawdatapoint)
    {
        zzxd.zzb zzb1 = new zzxd.zzb();
        zzb1.zzaIA = rawdatapoint.zzYG;
        zzb1.zzaIC = zzmx.zza(rawdatapoint.zzYI);
        zzb1.zzaID = rawdatapoint.zzZJ;
        zzb1.zzaIF = rawdatapoint.zzZK;
        zzb1.zzaIB = rawdatapoint.zzYH;
        zzb1.zzaIH = rawdatapoint.zzYK;
        zzb1.zzaII = rawdatapoint.zzYL;
        return zzb1;
    }

    public static zzxd.zzb[] zzl(List list)
    {
        zzxd.zzb azzb[] = new zzxd.zzb[list.size()];
        for (int i = 0; i < list.size(); i++)
        {
            azzb[i] = zzb((RawDataPoint)list.get(i));
        }

        return azzb;
    }
}
