// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzlv;

// Referenced classes of package com.google.android.gms.tagmanager:
//            zzbe, zzo, zzbf

private class <init>
    implements zzbe
{

    final zzo zzaxX;

    public void zza( )
    {
         = zzaxX;
        ;
        JVM INSTR monitorenter ;
        if (!zzaxX.isReady())
        {
            if (com.google.android.gms.tagmanager.zzo.zzf(zzaxX) == null)
            {
                break MISSING_BLOCK_LABEL_54;
            }
            zzaxX.setResult(com.google.android.gms.tagmanager.zzo.zzf(zzaxX));
        }
_L2:
        com.google.android.gms.tagmanager.zzo.zza(zzaxX, 0x36ee80L);
        return;
        zzaxX.setResult(zzaxX.zzaN(Status.zzNr));
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        ;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void zzb(com.google.android.gms.internal.c c)
    {
label0:
        {
            synchronized (zzaxX)
            {
                if (c.zzgs != null)
                {
                    break MISSING_BLOCK_LABEL_59;
                }
                if (com.google.android.gms.tagmanager.zzo.zzi(zzaxX).zzgs != null)
                {
                    break label0;
                }
                zzbf.zzZ("Current resource is null; network resource is also null");
                com.google.android.gms.tagmanager.zzo.zza(zzaxX, 0x36ee80L);
            }
            return;
        }
        c.zzgs = com.google.android.gms.tagmanager.zzo.zzi(zzaxX).zzgs;
        com.google.android.gms.tagmanager.zzo.zza(zzaxX, c, com.google.android.gms.tagmanager.zzo.zzg(zzaxX).currentTimeMillis(), false);
        zzbf.zzab((new StringBuilder()).append("setting refresh time to current time: ").append(com.google.android.gms.tagmanager.zzo.zzj(zzaxX)).toString());
        if (!com.google.android.gms.tagmanager.zzo.zzk(zzaxX))
        {
            com.google.android.gms.tagmanager.zzo.zza(zzaxX, c);
        }
        zzo1;
        JVM INSTR monitorexit ;
        return;
        c;
        zzo1;
        JVM INSTR monitorexit ;
        throw c;
    }

    public void zzo(Object obj)
    {
        zzb((com.google.android.gms.internal.c.zzb)obj);
    }

    public void zzsR()
    {
    }

    private (zzo zzo1)
    {
        zzaxX = zzo1;
        super();
    }

    zzaxX(zzo zzo1, zzaxX zzaxx)
    {
        this(zzo1);
    }
}
