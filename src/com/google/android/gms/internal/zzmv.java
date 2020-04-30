// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.fitness.data.RawDataSet;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            zzmu

public class zzmv
{

    public static zzxd.zzc zzb(RawDataSet rawdataset)
    {
        zzxd.zzc zzc = new zzxd.zzc();
        zzc.zzaID = rawdataset.zzZJ;
        zzc.zzaIK = zzmu.zzl(rawdataset.zzZM);
        zzc.zzaIx = rawdataset.zzYF;
        return zzc;
    }

    public static zzxd.zzc[] zzm(List list)
    {
        zzxd.zzc azzc[] = new zzxd.zzc[list.size()];
        for (int i = 0; i < list.size(); i++)
        {
            azzc[i] = zzb((RawDataSet)list.get(i));
        }

        return azzc;
    }
}
