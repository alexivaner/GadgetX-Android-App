// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core;

import android.content.Context;
import com.nostra13.universalimageloader.cache.disc.DiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.MemoryCache;
import com.nostra13.universalimageloader.cache.memory.impl.FuzzyKeyMemoryCache;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.decode.ImageDecoder;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import com.nostra13.universalimageloader.core.process.BitmapProcessor;
import com.nostra13.universalimageloader.utils.L;
import com.nostra13.universalimageloader.utils.MemoryCacheUtils;
import java.util.concurrent.Executor;

// Referenced classes of package com.nostra13.universalimageloader.core:
//            ImageLoaderConfiguration, DefaultConfigurationFactory, DisplayImageOptions

public static class context
{

    public static final QueueProcessingType DEFAULT_TASK_PROCESSING_TYPE;
    public static final int DEFAULT_THREAD_POOL_SIZE = 3;
    public static final int DEFAULT_THREAD_PRIORITY = 3;
    private static final String WARNING_OVERLAP_DISK_CACHE_NAME_GENERATOR = "diskCache() and diskCacheFileNameGenerator() calls overlap each other";
    private static final String WARNING_OVERLAP_DISK_CACHE_PARAMS = "diskCache(), diskCacheSize() and diskCacheFileCount calls overlap each other";
    private static final String WARNING_OVERLAP_EXECUTOR = "threadPoolSize(), threadPriority() and tasksProcessingOrder() calls can overlap taskExecutor() and taskExecutorForCachedImages() calls.";
    private static final String WARNING_OVERLAP_MEMORY_CACHE = "memoryCache() and memoryCacheSize() calls overlap each other";
    private Context context;
    private boolean customExecutor;
    private boolean customExecutorForCachedImages;
    private ImageDecoder decoder;
    private DisplayImageOptions defaultDisplayImageOptions;
    private boolean denyCacheImageMultipleSizesInMemory;
    private DiskCache diskCache;
    private int diskCacheFileCount;
    private FileNameGenerator diskCacheFileNameGenerator;
    private long diskCacheSize;
    private ImageDownloader downloader;
    private int maxImageHeightForDiskCache;
    private int maxImageHeightForMemoryCache;
    private int maxImageWidthForDiskCache;
    private int maxImageWidthForMemoryCache;
    private MemoryCache memoryCache;
    private int memoryCacheSize;
    private BitmapProcessor processorForDiskCache;
    private Executor taskExecutor;
    private Executor taskExecutorForCachedImages;
    private QueueProcessingType tasksProcessingType;
    private int threadPoolSize;
    private int threadPriority;
    private boolean writeLogs;

    private void initEmptyFieldsWithDefaultValues()
    {
        if (taskExecutor == null)
        {
            taskExecutor = DefaultConfigurationFactory.createExecutor(threadPoolSize, threadPriority, tasksProcessingType);
        } else
        {
            customExecutor = true;
        }
        if (taskExecutorForCachedImages == null)
        {
            taskExecutorForCachedImages = DefaultConfigurationFactory.createExecutor(threadPoolSize, threadPriority, tasksProcessingType);
        } else
        {
            customExecutorForCachedImages = true;
        }
        if (diskCache == null)
        {
            if (diskCacheFileNameGenerator == null)
            {
                diskCacheFileNameGenerator = DefaultConfigurationFactory.createFileNameGenerator();
            }
            diskCache = DefaultConfigurationFactory.createDiskCache(context, diskCacheFileNameGenerator, diskCacheSize, diskCacheFileCount);
        }
        if (memoryCache == null)
        {
            memoryCache = DefaultConfigurationFactory.createMemoryCache(context, memoryCacheSize);
        }
        if (denyCacheImageMultipleSizesInMemory)
        {
            memoryCache = new FuzzyKeyMemoryCache(memoryCache, MemoryCacheUtils.createFuzzyKeyComparator());
        }
        if (downloader == null)
        {
            downloader = DefaultConfigurationFactory.createImageDownloader(context);
        }
        if (decoder == null)
        {
            decoder = DefaultConfigurationFactory.createImageDecoder(writeLogs);
        }
        if (defaultDisplayImageOptions == null)
        {
            defaultDisplayImageOptions = DisplayImageOptions.createSimple();
        }
    }

    public ImageLoaderConfiguration build()
    {
        initEmptyFieldsWithDefaultValues();
        return new ImageLoaderConfiguration(this, null);
    }

    public initEmptyFieldsWithDefaultValues defaultDisplayImageOptions(DisplayImageOptions displayimageoptions)
    {
        defaultDisplayImageOptions = displayimageoptions;
        return this;
    }

    public defaultDisplayImageOptions denyCacheImageMultipleSizesInMemory()
    {
        denyCacheImageMultipleSizesInMemory = true;
        return this;
    }

    public denyCacheImageMultipleSizesInMemory discCache(DiskCache diskcache)
    {
        return diskCache(diskcache);
    }

    public diskCache discCacheExtraOptions(int i, int j, BitmapProcessor bitmapprocessor)
    {
        return diskCacheExtraOptions(i, j, bitmapprocessor);
    }

    public diskCacheExtraOptions discCacheFileCount(int i)
    {
        return diskCacheFileCount(i);
    }

    public diskCacheFileCount discCacheFileNameGenerator(FileNameGenerator filenamegenerator)
    {
        return diskCacheFileNameGenerator(filenamegenerator);
    }

    public diskCacheFileNameGenerator discCacheSize(int i)
    {
        return diskCacheSize(i);
    }

    public diskCacheSize diskCache(DiskCache diskcache)
    {
        if (diskCacheSize > 0L || diskCacheFileCount > 0)
        {
            L.w("diskCache(), diskCacheSize() and diskCacheFileCount calls overlap each other", new Object[0]);
        }
        if (diskCacheFileNameGenerator != null)
        {
            L.w("diskCache() and diskCacheFileNameGenerator() calls overlap each other", new Object[0]);
        }
        diskCache = diskcache;
        return this;
    }

    public diskCache diskCacheExtraOptions(int i, int j, BitmapProcessor bitmapprocessor)
    {
        maxImageWidthForDiskCache = i;
        maxImageHeightForDiskCache = j;
        processorForDiskCache = bitmapprocessor;
        return this;
    }

    public processorForDiskCache diskCacheFileCount(int i)
    {
        if (i <= 0)
        {
            throw new IllegalArgumentException("maxFileCount must be a positive number");
        }
        if (diskCache != null)
        {
            L.w("diskCache(), diskCacheSize() and diskCacheFileCount calls overlap each other", new Object[0]);
        }
        diskCacheFileCount = i;
        return this;
    }

    public diskCacheFileCount diskCacheFileNameGenerator(FileNameGenerator filenamegenerator)
    {
        if (diskCache != null)
        {
            L.w("diskCache() and diskCacheFileNameGenerator() calls overlap each other", new Object[0]);
        }
        diskCacheFileNameGenerator = filenamegenerator;
        return this;
    }

    public diskCacheFileNameGenerator diskCacheSize(int i)
    {
        if (i <= 0)
        {
            throw new IllegalArgumentException("maxCacheSize must be a positive number");
        }
        if (diskCache != null)
        {
            L.w("diskCache(), diskCacheSize() and diskCacheFileCount calls overlap each other", new Object[0]);
        }
        diskCacheSize = i;
        return this;
    }

    public diskCacheSize imageDecoder(ImageDecoder imagedecoder)
    {
        decoder = imagedecoder;
        return this;
    }

    public decoder imageDownloader(ImageDownloader imagedownloader)
    {
        downloader = imagedownloader;
        return this;
    }

    public downloader memoryCache(MemoryCache memorycache)
    {
        if (memoryCacheSize != 0)
        {
            L.w("memoryCache() and memoryCacheSize() calls overlap each other", new Object[0]);
        }
        memoryCache = memorycache;
        return this;
    }

    public memoryCache memoryCacheExtraOptions(int i, int j)
    {
        maxImageWidthForMemoryCache = i;
        maxImageHeightForMemoryCache = j;
        return this;
    }

    public maxImageHeightForMemoryCache memoryCacheSize(int i)
    {
        if (i <= 0)
        {
            throw new IllegalArgumentException("memoryCacheSize must be a positive number");
        }
        if (memoryCache != null)
        {
            L.w("memoryCache() and memoryCacheSize() calls overlap each other", new Object[0]);
        }
        memoryCacheSize = i;
        return this;
    }

    public memoryCacheSize memoryCacheSizePercentage(int i)
    {
        if (i <= 0 || i >= 100)
        {
            throw new IllegalArgumentException("availableMemoryPercent must be in range (0 < % < 100)");
        }
        if (memoryCache != null)
        {
            L.w("memoryCache() and memoryCacheSize() calls overlap each other", new Object[0]);
        }
        memoryCacheSize = (int)((float)Runtime.getRuntime().maxMemory() * ((float)i / 100F));
        return this;
    }

    public memoryCacheSize taskExecutor(Executor executor)
    {
        if (threadPoolSize != 3 || threadPriority != 3 || tasksProcessingType != DEFAULT_TASK_PROCESSING_TYPE)
        {
            L.w("threadPoolSize(), threadPriority() and tasksProcessingOrder() calls can overlap taskExecutor() and taskExecutorForCachedImages() calls.", new Object[0]);
        }
        taskExecutor = executor;
        return this;
    }

    public taskExecutor taskExecutorForCachedImages(Executor executor)
    {
        if (threadPoolSize != 3 || threadPriority != 3 || tasksProcessingType != DEFAULT_TASK_PROCESSING_TYPE)
        {
            L.w("threadPoolSize(), threadPriority() and tasksProcessingOrder() calls can overlap taskExecutor() and taskExecutorForCachedImages() calls.", new Object[0]);
        }
        taskExecutorForCachedImages = executor;
        return this;
    }

    public taskExecutorForCachedImages tasksProcessingOrder(QueueProcessingType queueprocessingtype)
    {
        if (taskExecutor != null || taskExecutorForCachedImages != null)
        {
            L.w("threadPoolSize(), threadPriority() and tasksProcessingOrder() calls can overlap taskExecutor() and taskExecutorForCachedImages() calls.", new Object[0]);
        }
        tasksProcessingType = queueprocessingtype;
        return this;
    }

    public tasksProcessingType threadPoolSize(int i)
    {
        if (taskExecutor != null || taskExecutorForCachedImages != null)
        {
            L.w("threadPoolSize(), threadPriority() and tasksProcessingOrder() calls can overlap taskExecutor() and taskExecutorForCachedImages() calls.", new Object[0]);
        }
        threadPoolSize = i;
        return this;
    }

    public threadPoolSize threadPriority(int i)
    {
        if (taskExecutor != null || taskExecutorForCachedImages != null)
        {
            L.w("threadPoolSize(), threadPriority() and tasksProcessingOrder() calls can overlap taskExecutor() and taskExecutorForCachedImages() calls.", new Object[0]);
        }
        if (i < 1)
        {
            threadPriority = 1;
            return this;
        }
        if (i > 10)
        {
            threadPriority = 10;
            return this;
        } else
        {
            threadPriority = i;
            return this;
        }
    }

    public threadPriority writeDebugLogs()
    {
        writeLogs = true;
        return this;
    }

    static 
    {
        DEFAULT_TASK_PROCESSING_TYPE = QueueProcessingType.FIFO;
    }




















    public (Context context1)
    {
        maxImageWidthForMemoryCache = 0;
        maxImageHeightForMemoryCache = 0;
        maxImageWidthForDiskCache = 0;
        maxImageHeightForDiskCache = 0;
        processorForDiskCache = null;
        taskExecutor = null;
        taskExecutorForCachedImages = null;
        customExecutor = false;
        customExecutorForCachedImages = false;
        threadPoolSize = 3;
        threadPriority = 3;
        denyCacheImageMultipleSizesInMemory = false;
        tasksProcessingType = DEFAULT_TASK_PROCESSING_TYPE;
        memoryCacheSize = 0;
        diskCacheSize = 0L;
        diskCacheFileCount = 0;
        memoryCache = null;
        diskCache = null;
        diskCacheFileNameGenerator = null;
        downloader = null;
        defaultDisplayImageOptions = null;
        writeLogs = false;
        context = context1.getApplicationContext();
    }
}
