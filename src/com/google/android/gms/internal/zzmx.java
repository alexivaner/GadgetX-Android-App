// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.Value;

public class zzmx
{

    public static Value zza(zzxc.zzd zzd, zzxc.zzf zzf)
    {
        Value value;
        if (zzf == null)
        {
            return null;
        }
        value = new Value(zzd.zzaIh.intValue());
        if (zzf.zzaIp == null) goto _L2; else goto _L1
_L1:
        boolean flag;
        if (zzd.zzaIh.intValue() == 2)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzb(flag, "Field format %d does not match stored value %s", new Object[] {
            zzd.zzaIh, zzf.zzaIp
        });
        value.setFloat(zzf.zzaIp.floatValue());
_L4:
        return value;
_L2:
        if (zzf.zzaIo != null)
        {
            boolean flag1;
            if (zzd.zzaIh.intValue() == 1)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            zzx.zzb(flag1, "Field format %d does not match stored value %s", new Object[] {
                zzd.zzaIh, zzf.zzaIo
            });
            value.setInt(zzf.zzaIo.intValue());
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static Value[] zza(zzxc.zzd azzd[], zzxc.zzf azzf[])
    {
        Value avalue[] = new Value[azzf.length];
        int j = Math.min(azzd.length, azzf.length);
        for (int i = 0; i < j; i++)
        {
            avalue[i] = zza(azzd[i], azzf[i]);
        }

        return avalue;
    }

    public static zzxc.zzf[] zza(Value avalue[])
    {
        zzxc.zzf azzf[] = new zzxc.zzf[avalue.length];
        for (int i = 0; i < avalue.length; i++)
        {
            azzf[i] = zzb(avalue[i]);
        }

        return azzf;
    }

    public static zzxc.zzf zzb(Value value)
    {
        zzxc.zzf zzf = new zzxc.zzf();
        if (value == null || !value.isSet())
        {
            return zzf;
        }
        if (2 == value.getFormat())
        {
            zzf.zzaIp = Double.valueOf(value.asFloat());
            return zzf;
        }
        if (1 == value.getFormat())
        {
            zzf.zzaIo = Integer.valueOf(value.asInt());
            return zzf;
        } else
        {
            throw new IllegalArgumentException((new StringBuilder()).append("unknown type: ").append(value.getFormat()).append(" in: ").append(value).toString());
        }
    }
}
