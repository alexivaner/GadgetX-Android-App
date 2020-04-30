// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.util.Log;
import com.google.android.gms.fitness.result.DataReadResult;

// Referenced classes of package com.google.android.gms.internal:
//            zzoc

private static class  extends 
{

    private final com.google.android.gms.common.api.eadResult zzHa;
    private int zzaam;
    private DataReadResult zzaan;

    public void zza(DataReadResult datareadresult)
    {
        this;
        JVM INSTR monitorenter ;
        Log.v("Fitness", "Received batch result");
        if (zzaan != null)
        {
            break MISSING_BLOCK_LABEL_62;
        }
        zzaan = datareadresult;
_L2:
        zzaam = zzaam + 1;
        if (zzaam == zzaan.zzmn())
        {
            zzHa.zd(zzaan);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        zzaan.zzb(datareadresult);
        if (true) goto _L2; else goto _L1
_L1:
        datareadresult;
        this;
        JVM INSTR monitorexit ;
        throw datareadresult;
    }

    private (com.google.android.gms.common.api. )
    {
        zzaam = 0;
        zzaan = null;
        zzHa = ;
    }

    (com.google.android.gms.common.api.Ha ha,  )
    {
        this(ha);
    }
}
