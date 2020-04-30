// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core;

import android.graphics.Bitmap;
import android.os.Handler;
import com.nostra13.universalimageloader.cache.disc.DiskCache;
import com.nostra13.universalimageloader.cache.memory.MemoryCache;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import com.nostra13.universalimageloader.core.decode.ImageDecoder;
import com.nostra13.universalimageloader.core.decode.ImageDecodingInfo;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import com.nostra13.universalimageloader.core.imageaware.ImageAware;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.nostra13.universalimageloader.core.listener.ImageLoadingProgressListener;
import com.nostra13.universalimageloader.core.process.BitmapProcessor;
import com.nostra13.universalimageloader.utils.IoUtils;
import com.nostra13.universalimageloader.utils.L;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

// Referenced classes of package com.nostra13.universalimageloader.core:
//            ImageLoaderEngine, ImageLoaderConfiguration, ImageLoadingInfo, DisplayImageOptions, 
//            DisplayBitmapTask

final class LoadAndDisplayImageTask
    implements Runnable, com.nostra13.universalimageloader.utils.IoUtils.CopyListener
{
    class TaskCancelledException extends Exception
    {

        final LoadAndDisplayImageTask this$0;

        TaskCancelledException()
        {
            this$0 = LoadAndDisplayImageTask.this;
            super();
        }
    }


    private static final String ERROR_NO_IMAGE_STREAM = "No stream for image [%s]";
    private static final String ERROR_POST_PROCESSOR_NULL = "Post-processor returned null [%s]";
    private static final String ERROR_PRE_PROCESSOR_NULL = "Pre-processor returned null [%s]";
    private static final String ERROR_PROCESSOR_FOR_DISK_CACHE_NULL = "Bitmap processor for disk cache returned null [%s]";
    private static final String LOG_CACHE_IMAGE_IN_MEMORY = "Cache image in memory [%s]";
    private static final String LOG_CACHE_IMAGE_ON_DISK = "Cache image on disk [%s]";
    private static final String LOG_DELAY_BEFORE_LOADING = "Delay %d ms before loading...  [%s]";
    private static final String LOG_GET_IMAGE_FROM_MEMORY_CACHE_AFTER_WAITING = "...Get cached bitmap from memory after waiting. [%s]";
    private static final String LOG_LOAD_IMAGE_FROM_DISK_CACHE = "Load image from disk cache [%s]";
    private static final String LOG_LOAD_IMAGE_FROM_NETWORK = "Load image from network [%s]";
    private static final String LOG_POSTPROCESS_IMAGE = "PostProcess image before displaying [%s]";
    private static final String LOG_PREPROCESS_IMAGE = "PreProcess image before caching in memory [%s]";
    private static final String LOG_PROCESS_IMAGE_BEFORE_CACHE_ON_DISK = "Process image before cache on disk [%s]";
    private static final String LOG_RESIZE_CACHED_IMAGE_FILE = "Resize image in disk cache [%s]";
    private static final String LOG_RESUME_AFTER_PAUSE = ".. Resume loading [%s]";
    private static final String LOG_START_DISPLAY_IMAGE_TASK = "Start display image task [%s]";
    private static final String LOG_TASK_CANCELLED_IMAGEAWARE_COLLECTED = "ImageAware was collected by GC. Task is cancelled. [%s]";
    private static final String LOG_TASK_CANCELLED_IMAGEAWARE_REUSED = "ImageAware is reused for another image. Task is cancelled. [%s]";
    private static final String LOG_TASK_INTERRUPTED = "Task was interrupted [%s]";
    private static final String LOG_WAITING_FOR_IMAGE_LOADED = "Image already is loading. Waiting... [%s]";
    private static final String LOG_WAITING_FOR_RESUME = "ImageLoader is paused. Waiting...  [%s]";
    private final ImageLoaderConfiguration configuration;
    private final ImageDecoder decoder;
    private final ImageDownloader downloader;
    private final ImageLoaderEngine engine;
    private final Handler handler;
    final ImageAware imageAware;
    private final ImageLoadingInfo imageLoadingInfo;
    final ImageLoadingListener listener;
    private LoadedFrom loadedFrom;
    private final String memoryCacheKey;
    private final ImageDownloader networkDeniedDownloader;
    final DisplayImageOptions options;
    final ImageLoadingProgressListener progressListener;
    private final ImageDownloader slowNetworkDownloader;
    private final boolean syncLoading;
    private final ImageSize targetSize;
    final String uri;

    public LoadAndDisplayImageTask(ImageLoaderEngine imageloaderengine, ImageLoadingInfo imageloadinginfo, Handler handler1)
    {
        loadedFrom = LoadedFrom.NETWORK;
        engine = imageloaderengine;
        imageLoadingInfo = imageloadinginfo;
        handler = handler1;
        configuration = imageloaderengine.configuration;
        downloader = configuration.downloader;
        networkDeniedDownloader = configuration.networkDeniedDownloader;
        slowNetworkDownloader = configuration.slowNetworkDownloader;
        decoder = configuration.decoder;
        uri = imageloadinginfo.uri;
        memoryCacheKey = imageloadinginfo.memoryCacheKey;
        imageAware = imageloadinginfo.imageAware;
        targetSize = imageloadinginfo.targetSize;
        options = imageloadinginfo.options;
        listener = imageloadinginfo.listener;
        progressListener = imageloadinginfo.progressListener;
        syncLoading = options.isSyncLoading();
    }

    private void checkTaskInterrupted()
        throws TaskCancelledException
    {
        if (isTaskInterrupted())
        {
            throw new TaskCancelledException();
        } else
        {
            return;
        }
    }

    private void checkTaskNotActual()
        throws TaskCancelledException
    {
        checkViewCollected();
        checkViewReused();
    }

    private void checkViewCollected()
        throws TaskCancelledException
    {
        if (isViewCollected())
        {
            throw new TaskCancelledException();
        } else
        {
            return;
        }
    }

    private void checkViewReused()
        throws TaskCancelledException
    {
        if (isViewReused())
        {
            throw new TaskCancelledException();
        } else
        {
            return;
        }
    }

    private Bitmap decodeImage(String s)
        throws IOException
    {
        ViewScaleType viewscaletype = imageAware.getScaleType();
        s = new ImageDecodingInfo(memoryCacheKey, s, uri, targetSize, viewscaletype, getDownloader(), options);
        return decoder.decode(s);
    }

    private boolean delayIfNeed()
    {
        if (options.shouldDelayBeforeLoading())
        {
            L.d("Delay %d ms before loading...  [%s]", new Object[] {
                Integer.valueOf(options.getDelayBeforeLoading()), memoryCacheKey
            });
            try
            {
                Thread.sleep(options.getDelayBeforeLoading());
            }
            catch (InterruptedException interruptedexception)
            {
                L.e("Task was interrupted [%s]", new Object[] {
                    memoryCacheKey
                });
                return true;
            }
            return isTaskNotActual();
        } else
        {
            return false;
        }
    }

    private boolean downloadImage()
        throws IOException
    {
        java.io.InputStream inputstream;
        inputstream = getDownloader().getStream(uri, options.getExtraForDownloader());
        if (inputstream == null)
        {
            L.e("No stream for image [%s]", new Object[] {
                memoryCacheKey
            });
            return false;
        }
        boolean flag = configuration.diskCache.save(uri, inputstream, this);
        IoUtils.closeSilently(inputstream);
        return flag;
        Exception exception;
        exception;
        IoUtils.closeSilently(inputstream);
        throw exception;
    }

    private void fireCancelEvent()
    {
        if (syncLoading || isTaskInterrupted())
        {
            return;
        } else
        {
            runTask(new Runnable() {

                final LoadAndDisplayImageTask this$0;

                public void run()
                {
                    listener.onLoadingCancelled(uri, imageAware.getWrappedView());
                }

            
            {
                this$0 = LoadAndDisplayImageTask.this;
                super();
            }
            }, false, handler, engine);
            return;
        }
    }

    private void fireFailEvent(final com.nostra13.universalimageloader.core.assist.FailReason.FailType failType, final Throwable failCause)
    {
        if (syncLoading || isTaskInterrupted() || isTaskNotActual())
        {
            return;
        } else
        {
            runTask(new Runnable() {

                final LoadAndDisplayImageTask this$0;
                private final Throwable val$failCause;
                private final com.nostra13.universalimageloader.core.assist.FailReason.FailType val$failType;

                public void run()
                {
                    if (options.shouldShowImageOnFail())
                    {
                        imageAware.setImageDrawable(options.getImageOnFail(configuration.resources));
                    }
                    listener.onLoadingFailed(uri, imageAware.getWrappedView(), new FailReason(failType, failCause));
                }

            
            {
                this$0 = LoadAndDisplayImageTask.this;
                failType = failtype;
                failCause = throwable;
                super();
            }
            }, false, handler, engine);
            return;
        }
    }

    private boolean fireProgressEvent(final int current, final int total)
    {
        if (isTaskInterrupted() || isTaskNotActual())
        {
            return false;
        }
        if (progressListener != null)
        {
            runTask(new Runnable() {

                final LoadAndDisplayImageTask this$0;
                private final int val$current;
                private final int val$total;

                public void run()
                {
                    progressListener.onProgressUpdate(uri, imageAware.getWrappedView(), current, total);
                }

            
            {
                this$0 = LoadAndDisplayImageTask.this;
                current = i;
                total = j;
                super();
            }
            }, false, handler, engine);
        }
        return true;
    }

    private ImageDownloader getDownloader()
    {
        if (engine.isNetworkDenied())
        {
            return networkDeniedDownloader;
        }
        if (engine.isSlowNetwork())
        {
            return slowNetworkDownloader;
        } else
        {
            return downloader;
        }
    }

    private boolean isTaskInterrupted()
    {
        if (Thread.interrupted())
        {
            L.d("Task was interrupted [%s]", new Object[] {
                memoryCacheKey
            });
            return true;
        } else
        {
            return false;
        }
    }

    private boolean isTaskNotActual()
    {
        return isViewCollected() || isViewReused();
    }

    private boolean isViewCollected()
    {
        if (imageAware.isCollected())
        {
            L.d("ImageAware was collected by GC. Task is cancelled. [%s]", new Object[] {
                memoryCacheKey
            });
            return true;
        } else
        {
            return false;
        }
    }

    private boolean isViewReused()
    {
        String s = engine.getLoadingUriForView(imageAware);
        boolean flag;
        if (memoryCacheKey.equals(s))
        {
            flag = false;
        } else
        {
            flag = true;
        }
        if (flag)
        {
            L.d("ImageAware is reused for another image. Task is cancelled. [%s]", new Object[] {
                memoryCacheKey
            });
            return true;
        } else
        {
            return false;
        }
    }

    private boolean resizeAndSaveImage(int i, int j)
        throws IOException
    {
        boolean flag1 = false;
        Object obj = configuration.diskCache.get(uri);
        boolean flag = flag1;
        if (obj != null)
        {
            flag = flag1;
            if (((File) (obj)).exists())
            {
                Object obj1 = new ImageSize(i, j);
                DisplayImageOptions displayimageoptions = (new DisplayImageOptions.Builder()).cloneFrom(options).imageScaleType(ImageScaleType.IN_SAMPLE_INT).build();
                obj = new ImageDecodingInfo(memoryCacheKey, com.nostra13.universalimageloader.core.download.ImageDownloader.Scheme.FILE.wrap(((File) (obj)).getAbsolutePath()), uri, ((ImageSize) (obj1)), ViewScaleType.FIT_INSIDE, getDownloader(), displayimageoptions);
                obj1 = decoder.decode(((ImageDecodingInfo) (obj)));
                obj = obj1;
                if (obj1 != null)
                {
                    obj = obj1;
                    if (configuration.processorForDiskCache != null)
                    {
                        L.d("Process image before cache on disk [%s]", new Object[] {
                            memoryCacheKey
                        });
                        obj1 = configuration.processorForDiskCache.process(((Bitmap) (obj1)));
                        obj = obj1;
                        if (obj1 == null)
                        {
                            L.e("Bitmap processor for disk cache returned null [%s]", new Object[] {
                                memoryCacheKey
                            });
                            obj = obj1;
                        }
                    }
                }
                flag = flag1;
                if (obj != null)
                {
                    flag = configuration.diskCache.save(uri, ((Bitmap) (obj)));
                    ((Bitmap) (obj)).recycle();
                }
            }
        }
        return flag;
    }

    static void runTask(Runnable runnable, boolean flag, Handler handler1, ImageLoaderEngine imageloaderengine)
    {
        if (flag)
        {
            runnable.run();
            return;
        }
        if (handler1 == null)
        {
            imageloaderengine.fireCallback(runnable);
            return;
        } else
        {
            handler1.post(runnable);
            return;
        }
    }

    private boolean tryCacheImageOnDisk()
        throws TaskCancelledException
    {
        L.d("Cache image on disk [%s]", new Object[] {
            memoryCacheKey
        });
        int i;
        int j;
        boolean flag;
        try
        {
            flag = downloadImage();
        }
        catch (IOException ioexception)
        {
            L.e(ioexception);
            return false;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_74;
        }
        i = configuration.maxImageWidthForDiskCache;
        j = configuration.maxImageHeightForDiskCache;
        if (i <= 0 && j <= 0)
        {
            break MISSING_BLOCK_LABEL_74;
        }
        L.d("Resize image in disk cache [%s]", new Object[] {
            memoryCacheKey
        });
        resizeAndSaveImage(i, j);
        return flag;
    }

    private Bitmap tryLoadBitmap()
        throws TaskCancelledException
    {
        String s = null;
        File file = null;
        Object obj1 = null;
        Object obj2 = null;
        Object obj = null;
        Bitmap bitmap1 = s;
        Bitmap bitmap2 = file;
        Bitmap bitmap3 = obj1;
        Bitmap bitmap4 = obj2;
        Bitmap bitmap;
        File file1;
        try
        {
            file1 = configuration.diskCache.get(uri);
        }
        catch (IllegalStateException illegalstateexception)
        {
            fireFailEvent(com.nostra13.universalimageloader.core.assist.FailReason.FailType.NETWORK_DENIED, null);
            return bitmap1;
        }
        catch (TaskCancelledException taskcancelledexception)
        {
            throw taskcancelledexception;
        }
        catch (IOException ioexception)
        {
            L.e(ioexception);
            fireFailEvent(com.nostra13.universalimageloader.core.assist.FailReason.FailType.IO_ERROR, ioexception);
            return bitmap2;
        }
        catch (OutOfMemoryError outofmemoryerror)
        {
            L.e(outofmemoryerror);
            fireFailEvent(com.nostra13.universalimageloader.core.assist.FailReason.FailType.OUT_OF_MEMORY, outofmemoryerror);
            return bitmap3;
        }
        catch (Throwable throwable)
        {
            L.e(throwable);
            fireFailEvent(com.nostra13.universalimageloader.core.assist.FailReason.FailType.UNKNOWN, throwable);
            return bitmap4;
        }
        bitmap = ((Bitmap) (obj));
        if (file1 == null)
        {
            break MISSING_BLOCK_LABEL_206;
        }
        bitmap = ((Bitmap) (obj));
        bitmap1 = s;
        bitmap2 = file;
        bitmap3 = obj1;
        bitmap4 = obj2;
        if (!file1.exists())
        {
            break MISSING_BLOCK_LABEL_206;
        }
        bitmap = ((Bitmap) (obj));
        bitmap1 = s;
        bitmap2 = file;
        bitmap3 = obj1;
        bitmap4 = obj2;
        if (file1.length() <= 0L)
        {
            break MISSING_BLOCK_LABEL_206;
        }
        bitmap1 = s;
        bitmap2 = file;
        bitmap3 = obj1;
        bitmap4 = obj2;
        L.d("Load image from disk cache [%s]", new Object[] {
            memoryCacheKey
        });
        bitmap1 = s;
        bitmap2 = file;
        bitmap3 = obj1;
        bitmap4 = obj2;
        loadedFrom = LoadedFrom.DISC_CACHE;
        bitmap1 = s;
        bitmap2 = file;
        bitmap3 = obj1;
        bitmap4 = obj2;
        checkTaskNotActual();
        bitmap1 = s;
        bitmap2 = file;
        bitmap3 = obj1;
        bitmap4 = obj2;
        bitmap = decodeImage(com.nostra13.universalimageloader.core.download.ImageDownloader.Scheme.FILE.wrap(file1.getAbsolutePath()));
        if (bitmap == null)
        {
            break MISSING_BLOCK_LABEL_247;
        }
        bitmap1 = bitmap;
        bitmap2 = bitmap;
        bitmap3 = bitmap;
        bitmap4 = bitmap;
        if (bitmap.getWidth() <= 0)
        {
            break MISSING_BLOCK_LABEL_247;
        }
        obj = bitmap;
        bitmap1 = bitmap;
        bitmap2 = bitmap;
        bitmap3 = bitmap;
        bitmap4 = bitmap;
        if (bitmap.getHeight() > 0)
        {
            break MISSING_BLOCK_LABEL_504;
        }
        bitmap1 = bitmap;
        bitmap2 = bitmap;
        bitmap3 = bitmap;
        bitmap4 = bitmap;
        L.d("Load image from network [%s]", new Object[] {
            memoryCacheKey
        });
        bitmap1 = bitmap;
        bitmap2 = bitmap;
        bitmap3 = bitmap;
        bitmap4 = bitmap;
        loadedFrom = LoadedFrom.NETWORK;
        bitmap1 = bitmap;
        bitmap2 = bitmap;
        bitmap3 = bitmap;
        bitmap4 = bitmap;
        s = uri;
        obj = s;
        bitmap1 = bitmap;
        bitmap2 = bitmap;
        bitmap3 = bitmap;
        bitmap4 = bitmap;
        if (!options.isCacheOnDisk())
        {
            break MISSING_BLOCK_LABEL_411;
        }
        obj = s;
        bitmap1 = bitmap;
        bitmap2 = bitmap;
        bitmap3 = bitmap;
        bitmap4 = bitmap;
        if (!tryCacheImageOnDisk())
        {
            break MISSING_BLOCK_LABEL_411;
        }
        bitmap1 = bitmap;
        bitmap2 = bitmap;
        bitmap3 = bitmap;
        bitmap4 = bitmap;
        file = configuration.diskCache.get(uri);
        obj = s;
        if (file == null)
        {
            break MISSING_BLOCK_LABEL_411;
        }
        bitmap1 = bitmap;
        bitmap2 = bitmap;
        bitmap3 = bitmap;
        bitmap4 = bitmap;
        obj = com.nostra13.universalimageloader.core.download.ImageDownloader.Scheme.FILE.wrap(file.getAbsolutePath());
        bitmap1 = bitmap;
        bitmap2 = bitmap;
        bitmap3 = bitmap;
        bitmap4 = bitmap;
        checkTaskNotActual();
        bitmap1 = bitmap;
        bitmap2 = bitmap;
        bitmap3 = bitmap;
        bitmap4 = bitmap;
        bitmap = decodeImage(((String) (obj)));
        if (bitmap == null)
        {
            break MISSING_BLOCK_LABEL_483;
        }
        bitmap1 = bitmap;
        bitmap2 = bitmap;
        bitmap3 = bitmap;
        bitmap4 = bitmap;
        if (bitmap.getWidth() <= 0)
        {
            break MISSING_BLOCK_LABEL_483;
        }
        obj = bitmap;
        bitmap1 = bitmap;
        bitmap2 = bitmap;
        bitmap3 = bitmap;
        bitmap4 = bitmap;
        if (bitmap.getHeight() > 0)
        {
            break MISSING_BLOCK_LABEL_504;
        }
        bitmap1 = bitmap;
        bitmap2 = bitmap;
        bitmap3 = bitmap;
        bitmap4 = bitmap;
        fireFailEvent(com.nostra13.universalimageloader.core.assist.FailReason.FailType.DECODING_ERROR, null);
        obj = bitmap;
        return ((Bitmap) (obj));
    }

    private boolean waitIfPaused()
    {
        AtomicBoolean atomicboolean;
        atomicboolean = engine.getPause();
        if (!atomicboolean.get())
        {
            break MISSING_BLOCK_LABEL_75;
        }
        Object obj = engine.getPauseLock();
        obj;
        JVM INSTR monitorenter ;
        if (!atomicboolean.get())
        {
            break MISSING_BLOCK_LABEL_74;
        }
        L.d("ImageLoader is paused. Waiting...  [%s]", new Object[] {
            memoryCacheKey
        });
        engine.getPauseLock().wait();
        L.d(".. Resume loading [%s]", new Object[] {
            memoryCacheKey
        });
        return isTaskNotActual();
        Object obj1;
        obj1;
        L.e("Task was interrupted [%s]", new Object[] {
            memoryCacheKey
        });
        obj;
        JVM INSTR monitorexit ;
        return true;
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
    }

    String getLoadingUri()
    {
        return uri;
    }

    public boolean onBytesCopied(int i, int j)
    {
        return syncLoading || fireProgressEvent(i, j);
    }

    public void run()
    {
        ReentrantLock reentrantlock;
        while (waitIfPaused() || delayIfNeed()) 
        {
            return;
        }
        reentrantlock = imageLoadingInfo.loadFromUriLock;
        L.d("Start display image task [%s]", new Object[] {
            memoryCacheKey
        });
        if (reentrantlock.isLocked())
        {
            L.d("Image already is loading. Waiting... [%s]", new Object[] {
                memoryCacheKey
            });
        }
        reentrantlock.lock();
        Bitmap bitmap1;
        checkTaskNotActual();
        bitmap1 = configuration.memoryCache.get(memoryCacheKey);
        if (bitmap1 == null)
        {
            break MISSING_BLOCK_LABEL_98;
        }
        if (!bitmap1.isRecycled())
        {
            break MISSING_BLOCK_LABEL_360;
        }
        bitmap1 = tryLoadBitmap();
        if (bitmap1 == null)
        {
            reentrantlock.unlock();
            return;
        }
        checkTaskNotActual();
        checkTaskInterrupted();
        Bitmap bitmap = bitmap1;
        if (!options.shouldPreProcess())
        {
            break MISSING_BLOCK_LABEL_186;
        }
        L.d("PreProcess image before caching in memory [%s]", new Object[] {
            memoryCacheKey
        });
        bitmap1 = options.getPreProcessor().process(bitmap1);
        bitmap = bitmap1;
        if (bitmap1 != null)
        {
            break MISSING_BLOCK_LABEL_186;
        }
        L.e("Pre-processor returned null [%s]", new Object[] {
            memoryCacheKey
        });
        bitmap = bitmap1;
        bitmap1 = bitmap;
        if (bitmap == null)
        {
            break MISSING_BLOCK_LABEL_240;
        }
        bitmap1 = bitmap;
        if (!options.isCacheInMemory())
        {
            break MISSING_BLOCK_LABEL_240;
        }
        L.d("Cache image in memory [%s]", new Object[] {
            memoryCacheKey
        });
        configuration.memoryCache.put(memoryCacheKey, bitmap);
        bitmap1 = bitmap;
_L2:
        bitmap = bitmap1;
        if (bitmap1 == null)
        {
            break MISSING_BLOCK_LABEL_312;
        }
        bitmap = bitmap1;
        if (!options.shouldPostProcess())
        {
            break MISSING_BLOCK_LABEL_312;
        }
        L.d("PostProcess image before displaying [%s]", new Object[] {
            memoryCacheKey
        });
        bitmap1 = options.getPostProcessor().process(bitmap1);
        bitmap = bitmap1;
        if (bitmap1 != null)
        {
            break MISSING_BLOCK_LABEL_312;
        }
        L.e("Post-processor returned null [%s]", new Object[] {
            memoryCacheKey
        });
        bitmap = bitmap1;
        checkTaskNotActual();
        checkTaskInterrupted();
        reentrantlock.unlock();
        runTask(new DisplayBitmapTask(bitmap, imageLoadingInfo, engine, loadedFrom), syncLoading, handler, engine);
        return;
        loadedFrom = LoadedFrom.MEMORY_CACHE;
        L.d("...Get cached bitmap from memory after waiting. [%s]", new Object[] {
            memoryCacheKey
        });
        if (true) goto _L2; else goto _L1
_L1:
        Object obj;
        obj;
        fireCancelEvent();
        reentrantlock.unlock();
        return;
        obj;
        reentrantlock.unlock();
        throw obj;
    }

}
