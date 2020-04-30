// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core;

import com.nostra13.universalimageloader.cache.disc.DiskCache;
import com.nostra13.universalimageloader.core.imageaware.ImageAware;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

// Referenced classes of package com.nostra13.universalimageloader.core:
//            ImageLoaderConfiguration, DefaultConfigurationFactory, LoadAndDisplayImageTask, ProcessAndDisplayImageTask

class ImageLoaderEngine
{

    private final Map cacheKeysForImageAwares = Collections.synchronizedMap(new HashMap());
    final ImageLoaderConfiguration configuration;
    private final AtomicBoolean networkDenied = new AtomicBoolean(false);
    private final Object pauseLock = new Object();
    private final AtomicBoolean paused = new AtomicBoolean(false);
    private final AtomicBoolean slowNetwork = new AtomicBoolean(false);
    private Executor taskDistributor;
    private Executor taskExecutor;
    private Executor taskExecutorForCachedImages;
    private final Map uriLocks = new WeakHashMap();

    ImageLoaderEngine(ImageLoaderConfiguration imageloaderconfiguration)
    {
        configuration = imageloaderconfiguration;
        taskExecutor = imageloaderconfiguration.taskExecutor;
        taskExecutorForCachedImages = imageloaderconfiguration.taskExecutorForCachedImages;
        taskDistributor = DefaultConfigurationFactory.createTaskDistributor();
    }

    private Executor createTaskExecutor()
    {
        return DefaultConfigurationFactory.createExecutor(configuration.threadPoolSize, configuration.threadPriority, configuration.tasksProcessingType);
    }

    private void initExecutorsIfNeed()
    {
        if (!configuration.customExecutor && ((ExecutorService)taskExecutor).isShutdown())
        {
            taskExecutor = createTaskExecutor();
        }
        if (!configuration.customExecutorForCachedImages && ((ExecutorService)taskExecutorForCachedImages).isShutdown())
        {
            taskExecutorForCachedImages = createTaskExecutor();
        }
    }

    void cancelDisplayTaskFor(ImageAware imageaware)
    {
        cacheKeysForImageAwares.remove(Integer.valueOf(imageaware.getId()));
    }

    void denyNetworkDownloads(boolean flag)
    {
        networkDenied.set(flag);
    }

    void fireCallback(Runnable runnable)
    {
        taskDistributor.execute(runnable);
    }

    String getLoadingUriForView(ImageAware imageaware)
    {
        return (String)cacheKeysForImageAwares.get(Integer.valueOf(imageaware.getId()));
    }

    ReentrantLock getLockForUri(String s)
    {
        ReentrantLock reentrantlock1 = (ReentrantLock)uriLocks.get(s);
        ReentrantLock reentrantlock = reentrantlock1;
        if (reentrantlock1 == null)
        {
            reentrantlock = new ReentrantLock();
            uriLocks.put(s, reentrantlock);
        }
        return reentrantlock;
    }

    AtomicBoolean getPause()
    {
        return paused;
    }

    Object getPauseLock()
    {
        return pauseLock;
    }

    void handleSlowNetwork(boolean flag)
    {
        slowNetwork.set(flag);
    }

    boolean isNetworkDenied()
    {
        return networkDenied.get();
    }

    boolean isSlowNetwork()
    {
        return slowNetwork.get();
    }

    void pause()
    {
        paused.set(true);
    }

    void prepareDisplayTaskFor(ImageAware imageaware, String s)
    {
        cacheKeysForImageAwares.put(Integer.valueOf(imageaware.getId()), s);
    }

    void resume()
    {
        paused.set(false);
        synchronized (pauseLock)
        {
            pauseLock.notifyAll();
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    void stop()
    {
        if (!configuration.customExecutor)
        {
            ((ExecutorService)taskExecutor).shutdownNow();
        }
        if (!configuration.customExecutorForCachedImages)
        {
            ((ExecutorService)taskExecutorForCachedImages).shutdownNow();
        }
        cacheKeysForImageAwares.clear();
        uriLocks.clear();
    }

    void submit(final LoadAndDisplayImageTask task)
    {
        taskDistributor.execute(new Runnable() {

            final ImageLoaderEngine this$0;
            private final LoadAndDisplayImageTask val$task;

            public void run()
            {
                File file = configuration.diskCache.get(task.getLoadingUri());
                boolean flag;
                if (file != null && file.exists())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                initExecutorsIfNeed();
                if (flag)
                {
                    taskExecutorForCachedImages.execute(task);
                    return;
                } else
                {
                    taskExecutor.execute(task);
                    return;
                }
            }

            
            {
                this$0 = ImageLoaderEngine.this;
                task = loadanddisplayimagetask;
                super();
            }
        });
    }

    void submit(ProcessAndDisplayImageTask processanddisplayimagetask)
    {
        initExecutorsIfNeed();
        taskExecutorForCachedImages.execute(processanddisplayimagetask);
    }



}
