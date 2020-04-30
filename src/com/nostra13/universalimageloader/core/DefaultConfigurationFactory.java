// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.nostra13.universalimageloader.cache.disc.DiskCache;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.disc.impl.ext.LruDiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.FileNameGenerator;
import com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.MemoryCache;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.assist.deque.LIFOLinkedBlockingDeque;
import com.nostra13.universalimageloader.core.decode.BaseImageDecoder;
import com.nostra13.universalimageloader.core.decode.ImageDecoder;
import com.nostra13.universalimageloader.core.display.BitmapDisplayer;
import com.nostra13.universalimageloader.core.display.SimpleBitmapDisplayer;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import com.nostra13.universalimageloader.utils.L;
import com.nostra13.universalimageloader.utils.StorageUtils;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class DefaultConfigurationFactory
{
    private static class DefaultThreadFactory
        implements ThreadFactory
    {

        private static final AtomicInteger poolNumber = new AtomicInteger(1);
        private final ThreadGroup group = Thread.currentThread().getThreadGroup();
        private final String namePrefix;
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final int threadPriority;

        public Thread newThread(Runnable runnable)
        {
            runnable = new Thread(group, runnable, (new StringBuilder(String.valueOf(namePrefix))).append(threadNumber.getAndIncrement()).toString(), 0L);
            if (runnable.isDaemon())
            {
                runnable.setDaemon(false);
            }
            runnable.setPriority(threadPriority);
            return runnable;
        }


        DefaultThreadFactory(int i, String s)
        {
            threadPriority = i;
            namePrefix = (new StringBuilder(String.valueOf(s))).append(poolNumber.getAndIncrement()).append("-thread-").toString();
        }
    }


    public DefaultConfigurationFactory()
    {
    }

    public static BitmapDisplayer createBitmapDisplayer()
    {
        return new SimpleBitmapDisplayer();
    }

    public static DiskCache createDiskCache(Context context, FileNameGenerator filenamegenerator, long l, int i)
    {
        File file;
        Object obj;
        file = createReserveDiskCacheDir(context);
        if (l <= 0L && i <= 0)
        {
            break MISSING_BLOCK_LABEL_50;
        }
        obj = StorageUtils.getIndividualCacheDirectory(context);
        obj = new LruDiskCache(((File) (obj)), file, filenamegenerator, l, i);
        return ((DiskCache) (obj));
        IOException ioexception;
        ioexception;
        L.e(ioexception);
        return new UnlimitedDiskCache(StorageUtils.getCacheDirectory(context), file, filenamegenerator);
    }

    public static Executor createExecutor(int i, int j, QueueProcessingType queueprocessingtype)
    {
        boolean flag;
        if (queueprocessingtype == QueueProcessingType.LIFO)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            queueprocessingtype = new LIFOLinkedBlockingDeque();
        } else
        {
            queueprocessingtype = new LinkedBlockingQueue();
        }
        return new ThreadPoolExecutor(i, i, 0L, TimeUnit.MILLISECONDS, queueprocessingtype, createThreadFactory(j, "uil-pool-"));
    }

    public static FileNameGenerator createFileNameGenerator()
    {
        return new HashCodeFileNameGenerator();
    }

    public static ImageDecoder createImageDecoder(boolean flag)
    {
        return new BaseImageDecoder(flag);
    }

    public static ImageDownloader createImageDownloader(Context context)
    {
        return new BaseImageDownloader(context);
    }

    public static MemoryCache createMemoryCache(Context context, int i)
    {
        int j = i;
        if (i == 0)
        {
            ActivityManager activitymanager = (ActivityManager)context.getSystemService("activity");
            j = activitymanager.getMemoryClass();
            i = j;
            if (hasHoneycomb())
            {
                i = j;
                if (isLargeHeap(context))
                {
                    i = getLargeMemoryClass(activitymanager);
                }
            }
            j = (0x100000 * i) / 8;
        }
        return new LruMemoryCache(j);
    }

    private static File createReserveDiskCacheDir(Context context)
    {
        context = StorageUtils.getCacheDirectory(context, false);
        File file = new File(context, "uil-images");
        if (file.exists() || file.mkdir())
        {
            context = file;
        }
        return context;
    }

    public static Executor createTaskDistributor()
    {
        return Executors.newCachedThreadPool(createThreadFactory(5, "uil-pool-d-"));
    }

    private static ThreadFactory createThreadFactory(int i, String s)
    {
        return new DefaultThreadFactory(i, s);
    }

    private static int getLargeMemoryClass(ActivityManager activitymanager)
    {
        return activitymanager.getLargeMemoryClass();
    }

    private static boolean hasHoneycomb()
    {
        return android.os.Build.VERSION.SDK_INT >= 11;
    }

    private static boolean isLargeHeap(Context context)
    {
        return (context.getApplicationInfo().flags & 0x100000) != 0;
    }
}
