// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.images;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import com.google.android.gms.common.internal.zzb;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

// Referenced classes of package com.google.android.gms.common.images:
//            ImageManager, zza

private final class zzmx
    implements Runnable
{

    private final Bitmap mBitmap;
    private final Uri mUri;
    final ImageManager zzOw;
    private boolean zzOz;
    private final CountDownLatch zzmx;

    private void zza(eReceiver ereceiver, boolean flag)
    {
        ereceiver = eReceiver.zza(ereceiver);
        int j = ereceiver.size();
        int i = 0;
        while (i < j) 
        {
            zza zza1 = (zza)ereceiver.get(i);
            if (flag)
            {
                zza1.zza(com.google.android.gms.common.images.ImageManager.zzb(zzOw), mBitmap, false);
            } else
            {
                ImageManager.zzd(zzOw).put(mUri, Long.valueOf(SystemClock.elapsedRealtime()));
                zza1.zza(com.google.android.gms.common.images.ImageManager.zzb(zzOw), ImageManager.zzc(zzOw), false);
            }
            if (!(zza1 instanceof zzOw))
            {
                ImageManager.zza(zzOw).remove(zza1);
            }
            i++;
        }
    }

    public void run()
    {
        zzb.zzbd("OnBitmapLoadedRunnable must be executed in the main thread");
        boolean flag;
        if (mBitmap != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (ImageManager.zzh(zzOw) != null)
        {
            if (zzOz)
            {
                ImageManager.zzh(zzOw).evictAll();
                System.gc();
                zzOz = false;
                ImageManager.zzg(zzOw).post(this);
                return;
            }
            if (flag)
            {
                ImageManager.zzh(zzOw).put(new put(mUri), mBitmap);
            }
        }
        eReceiver ereceiver = (eReceiver)ImageManager.zze(zzOw).remove(mUri);
        if (ereceiver != null)
        {
            zza(ereceiver, flag);
        }
        zzmx.countDown();
        synchronized (ImageManager.zziF())
        {
            ImageManager.zziG().remove(mUri);
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public eReceiver(ImageManager imagemanager, Uri uri, Bitmap bitmap, boolean flag, CountDownLatch countdownlatch)
    {
        zzOw = imagemanager;
        super();
        mUri = uri;
        mBitmap = bitmap;
        zzOz = flag;
        zzmx = countdownlatch;
    }
}
