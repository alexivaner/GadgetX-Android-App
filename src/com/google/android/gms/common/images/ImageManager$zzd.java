// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.images;

import android.os.SystemClock;
import com.google.android.gms.common.internal.zzb;
import java.util.HashSet;
import java.util.Map;

// Referenced classes of package com.google.android.gms.common.images:
//            ImageManager, zza

private final class zzOy
    implements Runnable
{

    final ImageManager zzOw;
    private final zza zzOy;

    public void run()
    {
        zzb.zzbd("LoadImageRunnable must be executed on the main thread");
        Object obj = (eReceiver)ImageManager.zza(zzOw).get(zzOy);
        if (obj != null)
        {
            ImageManager.zza(zzOw).remove(zzOy);
            ((eReceiver) (obj)).zzc(zzOy);
        }
        eReceiver ereceiver1 = zzOy.zzOA;
        if (ereceiver1.zzOy == null)
        {
            zzOy.zza(com.google.android.gms.common.images.ImageManager.zzb(zzOw), ImageManager.zzc(zzOw), true);
            return;
        }
        obj = ImageManager.zza(zzOw, ereceiver1);
        if (obj != null)
        {
            zzOy.zza(com.google.android.gms.common.images.ImageManager.zzb(zzOw), ((android.graphics.Bitmap) (obj)), true);
            return;
        }
        obj = (Long)ImageManager.zzd(zzOw).get(ereceiver1.zzOw);
        if (obj != null)
        {
            if (SystemClock.elapsedRealtime() - ((Long) (obj)).longValue() < 0x36ee80L)
            {
                zzOy.zza(com.google.android.gms.common.images.ImageManager.zzb(zzOw), ImageManager.zzc(zzOw), true);
                return;
            }
            ImageManager.zzd(zzOw).remove(ereceiver1.zzOw);
        }
        zzOy.zza(com.google.android.gms.common.images.ImageManager.zzb(zzOw), ImageManager.zzc(zzOw));
        eReceiver ereceiver = (eReceiver)ImageManager.zze(zzOw).get(ereceiver1.zzOw);
        obj = ereceiver;
        if (ereceiver == null)
        {
            obj = new eReceiver(zzOw, ereceiver1.zzOw);
            ImageManager.zze(zzOw).put(ereceiver1.zzOw, obj);
        }
        ((eReceiver) (obj)).zzb(zzOy);
        if (!(zzOy instanceof zzOy))
        {
            ImageManager.zza(zzOw).put(zzOy, obj);
        }
        synchronized (ImageManager.zziF())
        {
            if (!ImageManager.zziG().contains(ereceiver1.))
            {
                ImageManager.zziG().add(ereceiver1.);
                ((eReceiver) (obj)).zziH();
            }
        }
        return;
        exception;
        obj1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public eReceiver(ImageManager imagemanager, zza zza1)
    {
        zzOw = imagemanager;
        super();
        zzOy = zza1;
    }
}
