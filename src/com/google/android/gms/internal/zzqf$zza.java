// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;

// Referenced classes of package com.google.android.gms.internal:
//            zzqf

private class <init>
    implements Runnable
{

    final zzqf zzaoZ;

    public void run()
    {
        synchronized (zzqf.zzb(zzaoZ))
        {
            Intent intent = new Intent("com.google.android.location.places.METHOD_CALL");
            intent.setPackage("com.google.android.gms");
            intent.putStringArrayListExtra("PLACE_IDS", zzqf.zzc(zzaoZ));
            intent.putStringArrayListExtra("METHOD_NAMES", zzqf.zzd(zzaoZ));
            zzqf.zze(zzaoZ).sendBroadcast(intent);
            zzqf.zza(zzaoZ, null);
            zzqf.zzb(zzaoZ, null);
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private (zzqf zzqf1)
    {
        zzaoZ = zzqf1;
        super();
    }

    zzaoZ(zzqf zzqf1, zzaoZ zzaoz)
    {
        this(zzqf1);
    }
}
