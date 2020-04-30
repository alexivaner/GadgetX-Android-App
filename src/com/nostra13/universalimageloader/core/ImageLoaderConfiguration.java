// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.nostra13.universalimageloader.cache.disc.DiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.MemoryCache;
import com.nostra13.universalimageloader.cache.memory.impl.FuzzyKeyMemoryCache;
import com.nostra13.universalimageloader.core.assist.FlushedInputStream;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.decode.ImageDecoder;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import com.nostra13.universalimageloader.core.process.BitmapProcessor;
import com.nostra13.universalimageloader.utils.L;
import com.nostra13.universalimageloader.utils.MemoryCacheUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;

// Referenced classes of package com.nostra13.universalimageloader.core:
//            DisplayImageOptions, DefaultConfigurationFactory

public final class ImageLoaderConfiguration
{
    public static class Builder
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

        public Builder defaultDisplayImageOptions(DisplayImageOptions displayimageoptions)
        {
            defaultDisplayImageOptions = displayimageoptions;
            return this;
        }

        public Builder denyCacheImageMultipleSizesInMemory()
        {
            denyCacheImageMultipleSizesInMemory = true;
            return this;
        }

        public Builder discCache(DiskCache diskcache)
        {
            return diskCache(diskcache);
        }

        public Builder discCacheExtraOptions(int i, int j, BitmapProcessor bitmapprocessor)
        {
            return diskCacheExtraOptions(i, j, bitmapprocessor);
        }

        public Builder discCacheFileCount(int i)
        {
            return diskCacheFileCount(i);
        }

        public Builder discCacheFileNameGenerator(FileNameGenerator filenamegenerator)
        {
            return diskCacheFileNameGenerator(filenamegenerator);
        }

        public Builder discCacheSize(int i)
        {
            return diskCacheSize(i);
        }

        public Builder diskCache(DiskCache diskcache)
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

        public Builder diskCacheExtraOptions(int i, int j, BitmapProcessor bitmapprocessor)
        {
            maxImageWidthForDiskCache = i;
            maxImageHeightForDiskCache = j;
            processorForDiskCache = bitmapprocessor;
            return this;
        }

        public Builder diskCacheFileCount(int i)
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

        public Builder diskCacheFileNameGenerator(FileNameGenerator filenamegenerator)
        {
            if (diskCache != null)
            {
                L.w("diskCache() and diskCacheFileNameGenerator() calls overlap each other", new Object[0]);
            }
            diskCacheFileNameGenerator = filenamegenerator;
            return this;
        }

        public Builder diskCacheSize(int i)
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

        public Builder imageDecoder(ImageDecoder imagedecoder)
        {
            decoder = imagedecoder;
            return this;
        }

        public Builder imageDownloader(ImageDownloader imagedownloader)
        {
            downloader = imagedownloader;
            return this;
        }

        public Builder memoryCache(MemoryCache memorycache)
        {
            if (memoryCacheSize != 0)
            {
                L.w("memoryCache() and memoryCacheSize() calls overlap each other", new Object[0]);
            }
            memoryCache = memorycache;
            return this;
        }

        public Builder memoryCacheExtraOptions(int i, int j)
        {
            maxImageWidthForMemoryCache = i;
            maxImageHeightForMemoryCache = j;
            return this;
        }

        public Builder memoryCacheSize(int i)
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

        public Builder memoryCacheSizePercentage(int i)
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

        public Builder taskExecutor(Executor executor)
        {
            if (threadPoolSize != 3 || threadPriority != 3 || tasksProcessingType != DEFAULT_TASK_PROCESSING_TYPE)
            {
                L.w("threadPoolSize(), threadPriority() and tasksProcessingOrder() calls can overlap taskExecutor() and taskExecutorForCachedImages() calls.", new Object[0]);
            }
            taskExecutor = executor;
            return this;
        }

        public Builder taskExecutorForCachedImages(Executor executor)
        {
            if (threadPoolSize != 3 || threadPriority != 3 || tasksProcessingType != DEFAULT_TASK_PROCESSING_TYPE)
            {
                L.w("threadPoolSize(), threadPriority() and tasksProcessingOrder() calls can overlap taskExecutor() and taskExecutorForCachedImages() calls.", new Object[0]);
            }
            taskExecutorForCachedImages = executor;
            return this;
        }

        public Builder tasksProcessingOrder(QueueProcessingType queueprocessingtype)
        {
            if (taskExecutor != null || taskExecutorForCachedImages != null)
            {
                L.w("threadPoolSize(), threadPriority() and tasksProcessingOrder() calls can overlap taskExecutor() and taskExecutorForCachedImages() calls.", new Object[0]);
            }
            tasksProcessingType = queueprocessingtype;
            return this;
        }

        public Builder threadPoolSize(int i)
        {
            if (taskExecutor != null || taskExecutorForCachedImages != null)
            {
                L.w("threadPoolSize(), threadPriority() and tasksProcessingOrder() calls can overlap taskExecutor() and taskExecutorForCachedImages() calls.", new Object[0]);
            }
            threadPoolSize = i;
            return this;
        }

        public Builder threadPriority(int i)
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

        public Builder writeDebugLogs()
        {
            writeLogs = true;
            return this;
        }

        static 
        {
            DEFAULT_TASK_PROCESSING_TYPE = QueueProcessingType.FIFO;
        }




















        public Builder(Context context1)
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

    private static class NetworkDeniedImageDownloader
        implements ImageDownloader
    {

        private static int $SWITCH_TABLE$com$nostra13$universalimageloader$core$download$ImageDownloader$Scheme[];
        private final ImageDownloader wrappedDownloader;

        static int[] $SWITCH_TABLE$com$nostra13$universalimageloader$core$download$ImageDownloader$Scheme()
        {
            int ai[] = $SWITCH_TABLE$com$nostra13$universalimageloader$core$download$ImageDownloader$Scheme;
            if (ai != null)
            {
                return ai;
            }
            ai = new int[com.nostra13.universalimageloader.core.download.ImageDownloader.Scheme.values().length];
            try
            {
                ai[com.nostra13.universalimageloader.core.download.ImageDownloader.Scheme.ASSETS.ordinal()] = 5;
            }
            catch (NoSuchFieldError nosuchfielderror6) { }
            try
            {
                ai[com.nostra13.universalimageloader.core.download.ImageDownloader.Scheme.CONTENT.ordinal()] = 4;
            }
            catch (NoSuchFieldError nosuchfielderror5) { }
            try
            {
                ai[com.nostra13.universalimageloader.core.download.ImageDownloader.Scheme.DRAWABLE.ordinal()] = 6;
            }
            catch (NoSuchFieldError nosuchfielderror4) { }
            try
            {
                ai[com.nostra13.universalimageloader.core.download.ImageDownloader.Scheme.FILE.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror3) { }
            try
            {
                ai[com.nostra13.universalimageloader.core.download.ImageDownloader.Scheme.HTTP.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                ai[com.nostra13.universalimageloader.core.download.ImageDownloader.Scheme.HTTPS.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                ai[com.nostra13.universalimageloader.core.download.ImageDownloader.Scheme.UNKNOWN.ordinal()] = 7;
            }
            catch (NoSuchFieldError nosuchfielderror) { }
            $SWITCH_TABLE$com$nostra13$universalimageloader$core$download$ImageDownloader$Scheme = ai;
            return ai;
        }

        public InputStream getStream(String s, Object obj)
            throws IOException
        {
            switch ($SWITCH_TABLE$com$nostra13$universalimageloader$core$download$ImageDownloader$Scheme()[com.nostra13.universalimageloader.core.download.ImageDownloader.Scheme.ofUri(s).ordinal()])
            {
            default:
                return wrappedDownloader.getStream(s, obj);

            case 1: // '\001'
            case 2: // '\002'
                throw new IllegalStateException();
            }
        }

        public NetworkDeniedImageDownloader(ImageDownloader imagedownloader)
        {
            wrappedDownloader = imagedownloader;
        }
    }

    private static class SlowNetworkImageDownloader
        implements ImageDownloader
    {

        private static int $SWITCH_TABLE$com$nostra13$universalimageloader$core$download$ImageDownloader$Scheme[];
        private final ImageDownloader wrappedDownloader;

        static int[] $SWITCH_TABLE$com$nostra13$universalimageloader$core$download$ImageDownloader$Scheme()
        {
            int ai[] = $SWITCH_TABLE$com$nostra13$universalimageloader$core$download$ImageDownloader$Scheme;
            if (ai != null)
            {
                return ai;
            }
            ai = new int[com.nostra13.universalimageloader.core.download.ImageDownloader.Scheme.values().length];
            try
            {
                ai[com.nostra13.universalimageloader.core.download.ImageDownloader.Scheme.ASSETS.ordinal()] = 5;
            }
            catch (NoSuchFieldError nosuchfielderror6) { }
            try
            {
                ai[com.nostra13.universalimageloader.core.download.ImageDownloader.Scheme.CONTENT.ordinal()] = 4;
            }
            catch (NoSuchFieldError nosuchfielderror5) { }
            try
            {
                ai[com.nostra13.universalimageloader.core.download.ImageDownloader.Scheme.DRAWABLE.ordinal()] = 6;
            }
            catch (NoSuchFieldError nosuchfielderror4) { }
            try
            {
                ai[com.nostra13.universalimageloader.core.download.ImageDownloader.Scheme.FILE.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror3) { }
            try
            {
                ai[com.nostra13.universalimageloader.core.download.ImageDownloader.Scheme.HTTP.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                ai[com.nostra13.universalimageloader.core.download.ImageDownloader.Scheme.HTTPS.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                ai[com.nostra13.universalimageloader.core.download.ImageDownloader.Scheme.UNKNOWN.ordinal()] = 7;
            }
            catch (NoSuchFieldError nosuchfielderror) { }
            $SWITCH_TABLE$com$nostra13$universalimageloader$core$download$ImageDownloader$Scheme = ai;
            return ai;
        }

        public InputStream getStream(String s, Object obj)
            throws IOException
        {
            obj = wrappedDownloader.getStream(s, obj);
            switch ($SWITCH_TABLE$com$nostra13$universalimageloader$core$download$ImageDownloader$Scheme()[com.nostra13.universalimageloader.core.download.ImageDownloader.Scheme.ofUri(s).ordinal()])
            {
            default:
                return ((InputStream) (obj));

            case 1: // '\001'
            case 2: // '\002'
                return new FlushedInputStream(((InputStream) (obj)));
            }
        }

        public SlowNetworkImageDownloader(ImageDownloader imagedownloader)
        {
            wrappedDownloader = imagedownloader;
        }
    }


    final boolean customExecutor;
    final boolean customExecutorForCachedImages;
    final ImageDecoder decoder;
    final DisplayImageOptions defaultDisplayImageOptions;
    final DiskCache diskCache;
    final ImageDownloader downloader;
    final int maxImageHeightForDiskCache;
    final int maxImageHeightForMemoryCache;
    final int maxImageWidthForDiskCache;
    final int maxImageWidthForMemoryCache;
    final MemoryCache memoryCache;
    final ImageDownloader networkDeniedDownloader;
    final BitmapProcessor processorForDiskCache;
    final Resources resources;
    final ImageDownloader slowNetworkDownloader;
    final Executor taskExecutor;
    final Executor taskExecutorForCachedImages;
    final QueueProcessingType tasksProcessingType;
    final int threadPoolSize;
    final int threadPriority;

    private ImageLoaderConfiguration(Builder builder)
    {
        resources = builder.context.getResources();
        maxImageWidthForMemoryCache = builder.maxImageWidthForMemoryCache;
        maxImageHeightForMemoryCache = builder.maxImageHeightForMemoryCache;
        maxImageWidthForDiskCache = builder.maxImageWidthForDiskCache;
        maxImageHeightForDiskCache = builder.maxImageHeightForDiskCache;
        processorForDiskCache = builder.processorForDiskCache;
        taskExecutor = builder.taskExecutor;
        taskExecutorForCachedImages = builder.taskExecutorForCachedImages;
        threadPoolSize = builder.threadPoolSize;
        threadPriority = builder.threadPriority;
        tasksProcessingType = builder.tasksProcessingType;
        diskCache = builder.diskCache;
        memoryCache = builder.memoryCache;
        defaultDisplayImageOptions = builder.defaultDisplayImageOptions;
        downloader = builder.downloader;
        decoder = builder.decoder;
        customExecutor = builder.customExecutor;
        customExecutorForCachedImages = builder.customExecutorForCachedImages;
        networkDeniedDownloader = new NetworkDeniedImageDownloader(downloader);
        slowNetworkDownloader = new SlowNetworkImageDownloader(downloader);
        L.writeDebugLogs(builder.writeLogs);
    }

    ImageLoaderConfiguration(Builder builder, ImageLoaderConfiguration imageloaderconfiguration)
    {
        this(builder);
    }

    public static ImageLoaderConfiguration createDefault(Context context)
    {
        return (new Builder(context)).build();
    }

    ImageSize getMaxImageSize()
    {
        DisplayMetrics displaymetrics = resources.getDisplayMetrics();
        int j = maxImageWidthForMemoryCache;
        int i = j;
        if (j <= 0)
        {
            i = displaymetrics.widthPixels;
        }
        int k = maxImageHeightForMemoryCache;
        j = k;
        if (k <= 0)
        {
            j = displaymetrics.heightPixels;
        }
        return new ImageSize(i, j);
    }
}
