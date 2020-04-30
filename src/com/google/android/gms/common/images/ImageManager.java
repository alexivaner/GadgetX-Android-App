// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.images;

import android.app.ActivityManager;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.util.Log;
import android.widget.ImageView;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.internal.zzkm;
import com.google.android.gms.internal.zzkv;
import com.google.android.gms.internal.zzme;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Referenced classes of package com.google.android.gms.common.images:
//            zza

public final class ImageManager
{
    private final class ImageReceiver extends ResultReceiver
    {

        private final Uri mUri;
        private final ArrayList zzOv = new ArrayList();
        final ImageManager zzOw;

        static ArrayList zza(ImageReceiver imagereceiver)
        {
            return imagereceiver.zzOv;
        }

        public void onReceiveResult(int i, Bundle bundle)
        {
            bundle = (ParcelFileDescriptor)bundle.getParcelable("com.google.android.gms.extra.fileDescriptor");
            ImageManager.zzf(zzOw).execute(zzOw. new zzc(mUri, bundle));
        }

        public void zzb(com.google.android.gms.common.images.zza zza1)
        {
            com.google.android.gms.common.internal.zzb.zzbd("ImageReceiver.addImageRequest() must be called in the main thread");
            zzOv.add(zza1);
        }

        public void zzc(com.google.android.gms.common.images.zza zza1)
        {
            com.google.android.gms.common.internal.zzb.zzbd("ImageReceiver.removeImageRequest() must be called in the main thread");
            zzOv.remove(zza1);
        }

        public void zziH()
        {
            Intent intent = new Intent("com.google.android.gms.common.images.LOAD_IMAGE");
            intent.putExtra("com.google.android.gms.extras.uri", mUri);
            intent.putExtra("com.google.android.gms.extras.resultReceiver", this);
            intent.putExtra("com.google.android.gms.extras.priority", 3);
            com.google.android.gms.common.images.ImageManager.zzb(zzOw).sendBroadcast(intent);
        }

        ImageReceiver(Uri uri)
        {
            zzOw = ImageManager.this;
            super(new Handler(Looper.getMainLooper()));
            mUri = uri;
        }
    }

    public static interface OnImageLoadedListener
    {

        public abstract void onImageLoaded(Uri uri, Drawable drawable, boolean flag);
    }

    private static final class zza
    {

        static int zza(ActivityManager activitymanager)
        {
            return activitymanager.getLargeMemoryClass();
        }
    }

    private static final class zzb extends zzkv
    {

        private static int zzO(Context context)
        {
            ActivityManager activitymanager = (ActivityManager)context.getSystemService("activity");
            int i;
            if ((context.getApplicationInfo().flags & 0x100000) != 0)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            if (i != 0 && zzme.zzkd())
            {
                i = zza.zza(activitymanager);
            } else
            {
                i = activitymanager.getMemoryClass();
            }
            return (int)((float)(i * 0x100000) * 0.33F);
        }

        protected void entryRemoved(boolean flag, Object obj, Object obj1, Object obj2)
        {
            zza(flag, (zza.zza)obj, (Bitmap)obj1, (Bitmap)obj2);
        }

        protected int sizeOf(Object obj, Object obj1)
        {
            return zza((zza.zza)obj, (Bitmap)obj1);
        }

        protected int zza(zza.zza zza1, Bitmap bitmap)
        {
            return bitmap.getHeight() * bitmap.getRowBytes();
        }

        protected void zza(boolean flag, zza.zza zza1, Bitmap bitmap, Bitmap bitmap1)
        {
            super.entryRemoved(flag, zza1, bitmap, bitmap1);
        }

        public zzb(Context context)
        {
            super(zzO(context));
        }
    }

    private final class zzc
        implements Runnable
    {

        private final Uri mUri;
        final ImageManager zzOw;
        private final ParcelFileDescriptor zzOx;

        public void run()
        {
            Object obj;
            CountDownLatch countdownlatch;
            boolean flag;
            boolean flag1;
            com.google.android.gms.common.internal.zzb.zzbe("LoadBitmapFromDiskRunnable can't be executed in the main thread");
            flag = false;
            flag1 = false;
            obj = null;
            countdownlatch = null;
            if (zzOx == null) goto _L2; else goto _L1
_L1:
            obj = BitmapFactory.decodeFileDescriptor(zzOx.getFileDescriptor());
            flag = flag1;
_L3:
            OutOfMemoryError outofmemoryerror;
            try
            {
                zzOx.close();
            }
            catch (IOException ioexception)
            {
                Log.e("ImageManager", "closed failed", ioexception);
            }
_L2:
            countdownlatch = new CountDownLatch(1);
            ImageManager.zzg(zzOw).post(zzOw. new zzf(mUri, ((Bitmap) (obj)), flag, countdownlatch));
            try
            {
                countdownlatch.await();
                return;
            }
            catch (InterruptedException interruptedexception)
            {
                Log.w("ImageManager", (new StringBuilder()).append("Latch interrupted while posting ").append(mUri).toString());
            }
            break MISSING_BLOCK_LABEL_164;
            outofmemoryerror;
            Log.e("ImageManager", (new StringBuilder()).append("OOM while loading bitmap for uri: ").append(mUri).toString(), outofmemoryerror);
            flag = true;
            outofmemoryerror = countdownlatch;
              goto _L3
        }

        public zzc(Uri uri, ParcelFileDescriptor parcelfiledescriptor)
        {
            zzOw = ImageManager.this;
            super();
            mUri = uri;
            zzOx = parcelfiledescriptor;
        }
    }

    private final class zzd
        implements Runnable
    {

        final ImageManager zzOw;
        private final com.google.android.gms.common.images.zza zzOy;

        public void run()
        {
            com.google.android.gms.common.internal.zzb.zzbd("LoadImageRunnable must be executed on the main thread");
            Object obj = (ImageReceiver)ImageManager.zza(zzOw).get(zzOy);
            if (obj != null)
            {
                ImageManager.zza(zzOw).remove(zzOy);
                ((ImageReceiver) (obj)).zzc(zzOy);
            }
            zza.zza zza1 = zzOy.zzOA;
            if (zza1.uri == null)
            {
                zzOy.zza(com.google.android.gms.common.images.ImageManager.zzb(zzOw), ImageManager.zzc(zzOw), true);
                return;
            }
            obj = ImageManager.zza(zzOw, zza1);
            if (obj != null)
            {
                zzOy.zza(com.google.android.gms.common.images.ImageManager.zzb(zzOw), ((Bitmap) (obj)), true);
                return;
            }
            obj = (Long)ImageManager.zzd(zzOw).get(zza1.uri);
            if (obj != null)
            {
                if (SystemClock.elapsedRealtime() - ((Long) (obj)).longValue() < 0x36ee80L)
                {
                    zzOy.zza(com.google.android.gms.common.images.ImageManager.zzb(zzOw), ImageManager.zzc(zzOw), true);
                    return;
                }
                ImageManager.zzd(zzOw).remove(zza1.uri);
            }
            zzOy.zza(com.google.android.gms.common.images.ImageManager.zzb(zzOw), ImageManager.zzc(zzOw));
            ImageReceiver imagereceiver = (ImageReceiver)ImageManager.zze(zzOw).get(zza1.uri);
            obj = imagereceiver;
            if (imagereceiver == null)
            {
                obj = zzOw. new ImageReceiver(zza1.uri);
                ImageManager.zze(zzOw).put(zza1.uri, obj);
            }
            ((ImageReceiver) (obj)).zzb(zzOy);
            if (!(zzOy instanceof zza.zzc))
            {
                ImageManager.zza(zzOw).put(zzOy, obj);
            }
            synchronized (ImageManager.zziF())
            {
                if (!ImageManager.zziG().contains(zza1.uri))
                {
                    ImageManager.zziG().add(zza1.uri);
                    ((ImageReceiver) (obj)).zziH();
                }
            }
            return;
            exception;
            obj1;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public zzd(com.google.android.gms.common.images.zza zza1)
        {
            zzOw = ImageManager.this;
            super();
            zzOy = zza1;
        }
    }

    private static final class zze
        implements ComponentCallbacks2
    {

        private final zzb zzOq;

        public void onConfigurationChanged(Configuration configuration)
        {
        }

        public void onLowMemory()
        {
            zzOq.evictAll();
        }

        public void onTrimMemory(int i)
        {
            if (i >= 60)
            {
                zzOq.evictAll();
            } else
            if (i >= 20)
            {
                zzOq.trimToSize(zzOq.size() / 2);
                return;
            }
        }

        public zze(zzb zzb1)
        {
            zzOq = zzb1;
        }
    }

    private final class zzf
        implements Runnable
    {

        private final Bitmap mBitmap;
        private final Uri mUri;
        final ImageManager zzOw;
        private boolean zzOz;
        private final CountDownLatch zzmx;

        private void zza(ImageReceiver imagereceiver, boolean flag)
        {
            imagereceiver = ImageReceiver.zza(imagereceiver);
            int j = imagereceiver.size();
            int i = 0;
            while (i < j) 
            {
                com.google.android.gms.common.images.zza zza1 = (com.google.android.gms.common.images.zza)imagereceiver.get(i);
                if (flag)
                {
                    zza1.zza(com.google.android.gms.common.images.ImageManager.zzb(zzOw), mBitmap, false);
                } else
                {
                    ImageManager.zzd(zzOw).put(mUri, Long.valueOf(SystemClock.elapsedRealtime()));
                    zza1.zza(com.google.android.gms.common.images.ImageManager.zzb(zzOw), ImageManager.zzc(zzOw), false);
                }
                if (!(zza1 instanceof zza.zzc))
                {
                    ImageManager.zza(zzOw).remove(zza1);
                }
                i++;
            }
        }

        public void run()
        {
            com.google.android.gms.common.internal.zzb.zzbd("OnBitmapLoadedRunnable must be executed in the main thread");
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
                    ImageManager.zzh(zzOw).put(new zza.zza(mUri), mBitmap);
                }
            }
            ImageReceiver imagereceiver = (ImageReceiver)ImageManager.zze(zzOw).remove(mUri);
            if (imagereceiver != null)
            {
                zza(imagereceiver, flag);
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

        public zzf(Uri uri, Bitmap bitmap, boolean flag, CountDownLatch countdownlatch)
        {
            zzOw = ImageManager.this;
            super();
            mUri = uri;
            mBitmap = bitmap;
            zzOz = flag;
            zzmx = countdownlatch;
        }
    }


    private static final Object zzOl = new Object();
    private static HashSet zzOm = new HashSet();
    private static ImageManager zzOn;
    private static ImageManager zzOo;
    private final Context mContext;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private final ExecutorService zzOp = Executors.newFixedThreadPool(4);
    private final zzb zzOq;
    private final zzkm zzOr = new zzkm();
    private final Map zzOs = new HashMap();
    private final Map zzOt = new HashMap();
    private final Map zzOu = new HashMap();

    private ImageManager(Context context, boolean flag)
    {
        mContext = context.getApplicationContext();
        if (flag)
        {
            zzOq = new zzb(mContext);
            if (zzme.zzkg())
            {
                zziE();
            }
        } else
        {
            zzOq = null;
        }
    }

    public static ImageManager create(Context context)
    {
        return zzb(context, false);
    }

    static Bitmap zza(ImageManager imagemanager, zza.zza zza1)
    {
        return imagemanager.zza(zza1);
    }

    private Bitmap zza(zza.zza zza1)
    {
        if (zzOq == null)
        {
            return null;
        } else
        {
            return (Bitmap)zzOq.get(zza1);
        }
    }

    static Map zza(ImageManager imagemanager)
    {
        return imagemanager.zzOs;
    }

    static Context zzb(ImageManager imagemanager)
    {
        return imagemanager.mContext;
    }

    public static ImageManager zzb(Context context, boolean flag)
    {
        if (flag)
        {
            if (zzOo == null)
            {
                zzOo = new ImageManager(context, true);
            }
            return zzOo;
        }
        if (zzOn == null)
        {
            zzOn = new ImageManager(context, false);
        }
        return zzOn;
    }

    static zzkm zzc(ImageManager imagemanager)
    {
        return imagemanager.zzOr;
    }

    static Map zzd(ImageManager imagemanager)
    {
        return imagemanager.zzOu;
    }

    static Map zze(ImageManager imagemanager)
    {
        return imagemanager.zzOt;
    }

    static ExecutorService zzf(ImageManager imagemanager)
    {
        return imagemanager.zzOp;
    }

    static Handler zzg(ImageManager imagemanager)
    {
        return imagemanager.mHandler;
    }

    static zzb zzh(ImageManager imagemanager)
    {
        return imagemanager.zzOq;
    }

    private void zziE()
    {
        mContext.registerComponentCallbacks(new zze(zzOq));
    }

    static Object zziF()
    {
        return zzOl;
    }

    static HashSet zziG()
    {
        return zzOm;
    }

    public void loadImage(ImageView imageview, int i)
    {
        zza(new zza.zzb(imageview, i));
    }

    public void loadImage(ImageView imageview, Uri uri)
    {
        zza(new zza.zzb(imageview, uri));
    }

    public void loadImage(ImageView imageview, Uri uri, int i)
    {
        imageview = new zza.zzb(imageview, uri);
        imageview.zzaC(i);
        zza(imageview);
    }

    public void loadImage(OnImageLoadedListener onimageloadedlistener, Uri uri)
    {
        zza(new zza.zzc(onimageloadedlistener, uri));
    }

    public void loadImage(OnImageLoadedListener onimageloadedlistener, Uri uri, int i)
    {
        onimageloadedlistener = new zza.zzc(onimageloadedlistener, uri);
        onimageloadedlistener.zzaC(i);
        zza(onimageloadedlistener);
    }

    public void zza(com.google.android.gms.common.images.zza zza1)
    {
        com.google.android.gms.common.internal.zzb.zzbd("ImageManager.loadImage() must be called in the main thread");
        (new zzd(zza1)).run();
    }

}
