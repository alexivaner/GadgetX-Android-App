// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.SystemClock;

// Referenced classes of package com.google.android.gms.internal:
//            zzkc, zzkf

public final class zzkg
{

    private static final zzkc zzKh = new zzkc("RequestTracker");
    public static final Object zzLm = new Object();
    private long zzLi;
    private long zzLj;
    private long zzLk;
    private zzkf zzLl;

    public zzkg(long l)
    {
        zzLi = l;
        zzLj = -1L;
        zzLk = 0L;
    }

    private void zzhH()
    {
        zzLj = -1L;
        zzLl = null;
        zzLk = 0L;
    }

    public void zza(long l, zzkf zzkf1)
    {
        zzkf zzkf2;
        long l1;
        synchronized (zzLm)
        {
            zzkf2 = zzLl;
            l1 = zzLj;
            zzLj = l;
            zzLl = zzkf1;
            zzLk = SystemClock.elapsedRealtime();
        }
        if (zzkf2 != null)
        {
            zzkf2.zzn(l1);
        }
        return;
        zzkf1;
        obj;
        JVM INSTR monitorexit ;
        throw zzkf1;
    }

    public boolean zzb(long l, int i, Object obj)
    {
        zzkf zzkf1;
        boolean flag;
        flag = true;
        zzkf1 = null;
        Object obj1 = zzLm;
        obj1;
        JVM INSTR monitorenter ;
        if (zzLj == -1L || zzLj != l)
        {
            break MISSING_BLOCK_LABEL_96;
        }
        zzKh.zzb("request %d completed", new Object[] {
            Long.valueOf(zzLj)
        });
        zzkf1 = zzLl;
        zzhH();
_L2:
        if (zzkf1 != null)
        {
            zzkf1.zza(l, i, obj);
        }
        return flag;
        obj;
        obj1;
        JVM INSTR monitorexit ;
        throw obj;
        flag = false;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public boolean zzc(long l, int i)
    {
        return zzb(l, i, null);
    }

    public boolean zzd(long l, int i)
    {
        long l1;
        boolean flag;
        flag = true;
        l1 = 0L;
        Object obj1 = zzLm;
        obj1;
        JVM INSTR monitorenter ;
        Object obj;
        if (zzLj == -1L || l - zzLk < zzLi)
        {
            break MISSING_BLOCK_LABEL_105;
        }
        zzKh.zzb("request %d timed out", new Object[] {
            Long.valueOf(zzLj)
        });
        l = zzLj;
        obj = zzLl;
        zzhH();
_L2:
        if (obj != null)
        {
            ((zzkf) (obj)).zza(l, i, null);
        }
        return flag;
        obj;
        obj1;
        JVM INSTR monitorexit ;
        throw obj;
        flag = false;
        obj = null;
        l = l1;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public boolean zzhI()
    {
        Object obj = zzLm;
        obj;
        JVM INSTR monitorenter ;
        Exception exception;
        boolean flag;
        if (zzLj != -1L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj;
        JVM INSTR monitorexit ;
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean zzq(long l)
    {
        Object obj = zzLm;
        obj;
        JVM INSTR monitorenter ;
        Exception exception;
        boolean flag;
        if (zzLj != -1L && zzLj == l)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj;
        JVM INSTR monitorexit ;
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

}
