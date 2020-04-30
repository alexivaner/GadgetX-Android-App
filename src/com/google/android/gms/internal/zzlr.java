// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.SystemClock;
import android.support.v4.util.SimpleArrayMap;
import android.util.Log;

public class zzlr
{

    private final long zzRK;
    private final int zzRL;
    private final SimpleArrayMap zzRM;

    public zzlr()
    {
        zzRK = 60000L;
        zzRL = 10;
        zzRM = new SimpleArrayMap(10);
    }

    public zzlr(int i, long l)
    {
        zzRK = l;
        zzRL = i;
        zzRM = new SimpleArrayMap();
    }

    private void zzc(long l, long l1)
    {
        for (int i = zzRM.size() - 1; i >= 0; i--)
        {
            if (l1 - ((Long)zzRM.valueAt(i)).longValue() > l)
            {
                zzRM.removeAt(i);
            }
        }

    }

    public Long zza(Long long1)
    {
        long l1 = SystemClock.elapsedRealtime();
        long l = zzRK;
        this;
        JVM INSTR monitorenter ;
        for (; zzRM.size() >= zzRL; Log.w("PassiveTimedConnectionMap", (new StringBuilder()).append("The max capacity ").append(zzRL).append(" is not enough. Current durationThreshold is: ").append(l).toString()))
        {
            zzc(l, l1);
            l /= 2L;
        }

        break MISSING_BLOCK_LABEL_84;
        long1;
        this;
        JVM INSTR monitorexit ;
        throw long1;
        long1 = (Long)zzRM.put(long1, Long.valueOf(l1));
        this;
        JVM INSTR monitorexit ;
        return long1;
    }

    public boolean zzr(long l)
    {
        this;
        JVM INSTR monitorenter ;
        Exception exception;
        boolean flag;
        if (zzRM.remove(Long.valueOf(l)) != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        this;
        JVM INSTR monitorexit ;
        return flag;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
