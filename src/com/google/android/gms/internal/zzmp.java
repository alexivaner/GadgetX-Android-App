// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Field;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            zzmq

public class zzmp
{

    public static final zzmp zzZU = new zzmp();

    public zzmp()
    {
    }

    public zzxc.zzc zzc(DataType datatype)
    {
        zzxc.zzc zzc1 = new zzxc.zzc();
        zzc1.name = datatype.getName();
        datatype = datatype.getFields();
        zzc1.zzaIf = new zzxc.zzd[datatype.size()];
        for (int i = 0; i < datatype.size(); i++)
        {
            zzc1.zzaIf[i] = zzmq.zzZV.zzb((Field)datatype.get(i));
        }

        return zzc1;
    }

}
