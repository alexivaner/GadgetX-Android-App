// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.nostra13.universalimageloader.cache.disc.DiskCache;
import com.nostra13.universalimageloader.cache.memory.MemoryCache;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import com.nostra13.universalimageloader.core.display.BitmapDisplayer;
import com.nostra13.universalimageloader.core.imageaware.ImageAware;
import com.nostra13.universalimageloader.core.imageaware.ImageViewAware;
import com.nostra13.universalimageloader.core.imageaware.NonViewAware;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.nostra13.universalimageloader.core.listener.ImageLoadingProgressListener;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;
import com.nostra13.universalimageloader.utils.ImageSizeUtils;
import com.nostra13.universalimageloader.utils.L;
import com.nostra13.universalimageloader.utils.MemoryCacheUtils;

// Referenced classes of package com.nostra13.universalimageloader.core:
//            DisplayImageOptions, ImageLoaderEngine, ImageLoaderConfiguration, ImageLoadingInfo, 
//            ProcessAndDisplayImageTask, LoadAndDisplayImageTask

public class ImageLoader
{
    private static class SyncImageLoadingListener extends SimpleImageLoadingListener
    {

        private Bitmap loadedImage;

        public Bitmap getLoadedBitmap()
        {
            return loadedImage;
        }

        public void onLoadingComplete(String s, View view, Bitmap bitmap)
        {
            loadedImage = bitmap;
        }

        private SyncImageLoadingListener()
        {
        }

        SyncImageLoadingListener(SyncImageLoadingListener syncimageloadinglistener)
        {
            this();
        }
    }


    private static final String ERROR_INIT_CONFIG_WITH_NULL = "ImageLoader configuration can not be initialized with null";
    private static final String ERROR_NOT_INIT = "ImageLoader must be init with configuration before using";
    private static final String ERROR_WRONG_ARGUMENTS = "Wrong arguments were passed to displayImage() method (ImageView reference must not be null)";
    static final String LOG_DESTROY = "Destroy ImageLoader";
    static final String LOG_INIT_CONFIG = "Initialize ImageLoader with configuration";
    static final String LOG_LOAD_IMAGE_FROM_MEMORY_CACHE = "Load image from memory cache [%s]";
    public static final String TAG = com/nostra13/universalimageloader/core/ImageLoader.getSimpleName();
    private static final String WARNING_RE_INIT_CONFIG = "Try to initialize ImageLoader which had already been initialized before. To re-init ImageLoader with new configuration call ImageLoader.destroy() at first.";
    private static volatile ImageLoader instance;
    private ImageLoaderConfiguration configuration;
    private ImageLoadingListener defaultListener;
    private ImageLoaderEngine engine;

    protected ImageLoader()
    {
        defaultListener = new SimpleImageLoadingListener();
    }

    private void checkConfiguration()
    {
        if (configuration == null)
        {
            throw new IllegalStateException("ImageLoader must be init with configuration before using");
        } else
        {
            return;
        }
    }

    private static Handler defineHandler(DisplayImageOptions displayimageoptions)
    {
        Handler handler = displayimageoptions.getHandler();
        if (displayimageoptions.isSyncLoading())
        {
            displayimageoptions = null;
        } else
        {
            displayimageoptions = handler;
            if (handler == null)
            {
                displayimageoptions = handler;
                if (Looper.myLooper() == Looper.getMainLooper())
                {
                    return new Handler();
                }
            }
        }
        return displayimageoptions;
    }

    public static ImageLoader getInstance()
    {
        if (instance != null) goto _L2; else goto _L1
_L1:
        com/nostra13/universalimageloader/core/ImageLoader;
        JVM INSTR monitorenter ;
        if (instance == null)
        {
            instance = new ImageLoader();
        }
        com/nostra13/universalimageloader/core/ImageLoader;
        JVM INSTR monitorexit ;
_L2:
        return instance;
        Exception exception;
        exception;
        com/nostra13/universalimageloader/core/ImageLoader;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void cancelDisplayTask(ImageView imageview)
    {
        engine.cancelDisplayTaskFor(new ImageViewAware(imageview));
    }

    public void cancelDisplayTask(ImageAware imageaware)
    {
        engine.cancelDisplayTaskFor(imageaware);
    }

    public void clearDiscCache()
    {
        clearDiskCache();
    }

    public void clearDiskCache()
    {
        checkConfiguration();
        configuration.diskCache.clear();
    }

    public void clearMemoryCache()
    {
        checkConfiguration();
        configuration.memoryCache.clear();
    }

    public void denyNetworkDownloads(boolean flag)
    {
        engine.denyNetworkDownloads(flag);
    }

    public void destroy()
    {
        if (configuration != null)
        {
            L.d("Destroy ImageLoader", new Object[0]);
        }
        stop();
        configuration.diskCache.close();
        engine = null;
        configuration = null;
    }

    public void displayImage(String s, ImageView imageview)
    {
        displayImage(s, ((ImageAware) (new ImageViewAware(imageview))), null, null, null);
    }

    public void displayImage(String s, ImageView imageview, DisplayImageOptions displayimageoptions)
    {
        displayImage(s, ((ImageAware) (new ImageViewAware(imageview))), displayimageoptions, null, null);
    }

    public void displayImage(String s, ImageView imageview, DisplayImageOptions displayimageoptions, ImageLoadingListener imageloadinglistener)
    {
        displayImage(s, imageview, displayimageoptions, imageloadinglistener, null);
    }

    public void displayImage(String s, ImageView imageview, DisplayImageOptions displayimageoptions, ImageLoadingListener imageloadinglistener, ImageLoadingProgressListener imageloadingprogresslistener)
    {
        displayImage(s, ((ImageAware) (new ImageViewAware(imageview))), displayimageoptions, imageloadinglistener, imageloadingprogresslistener);
    }

    public void displayImage(String s, ImageView imageview, ImageSize imagesize)
    {
        displayImage(s, ((ImageAware) (new ImageViewAware(imageview))), null, imagesize, null, null);
    }

    public void displayImage(String s, ImageView imageview, ImageLoadingListener imageloadinglistener)
    {
        displayImage(s, ((ImageAware) (new ImageViewAware(imageview))), null, imageloadinglistener, null);
    }

    public void displayImage(String s, ImageAware imageaware)
    {
        displayImage(s, imageaware, null, null, null);
    }

    public void displayImage(String s, ImageAware imageaware, DisplayImageOptions displayimageoptions)
    {
        displayImage(s, imageaware, displayimageoptions, null, null);
    }

    public void displayImage(String s, ImageAware imageaware, DisplayImageOptions displayimageoptions, ImageSize imagesize, ImageLoadingListener imageloadinglistener, ImageLoadingProgressListener imageloadingprogresslistener)
    {
        checkConfiguration();
        if (imageaware == null)
        {
            throw new IllegalArgumentException("Wrong arguments were passed to displayImage() method (ImageView reference must not be null)");
        }
        ImageLoadingListener imageloadinglistener1 = imageloadinglistener;
        if (imageloadinglistener == null)
        {
            imageloadinglistener1 = defaultListener;
        }
        imageloadinglistener = displayimageoptions;
        if (displayimageoptions == null)
        {
            imageloadinglistener = configuration.defaultDisplayImageOptions;
        }
        if (TextUtils.isEmpty(s))
        {
            engine.cancelDisplayTaskFor(imageaware);
            imageloadinglistener1.onLoadingStarted(s, imageaware.getWrappedView());
            if (imageloadinglistener.shouldShowImageForEmptyUri())
            {
                imageaware.setImageDrawable(imageloadinglistener.getImageForEmptyUri(configuration.resources));
            } else
            {
                imageaware.setImageDrawable(null);
            }
            imageloadinglistener1.onLoadingComplete(s, imageaware.getWrappedView(), null);
            return;
        }
        displayimageoptions = imagesize;
        if (imagesize == null)
        {
            displayimageoptions = ImageSizeUtils.defineTargetSizeForView(imageaware, configuration.getMaxImageSize());
        }
        String s1 = MemoryCacheUtils.generateKey(s, displayimageoptions);
        engine.prepareDisplayTaskFor(imageaware, s1);
        imageloadinglistener1.onLoadingStarted(s, imageaware.getWrappedView());
        imagesize = configuration.memoryCache.get(s1);
        if (imagesize != null && !imagesize.isRecycled())
        {
            L.d("Load image from memory cache [%s]", new Object[] {
                s1
            });
            if (imageloadinglistener.shouldPostProcess())
            {
                s = new ImageLoadingInfo(s, imageaware, displayimageoptions, s1, imageloadinglistener, imageloadinglistener1, imageloadingprogresslistener, engine.getLockForUri(s));
                s = new ProcessAndDisplayImageTask(engine, imagesize, s, defineHandler(imageloadinglistener));
                if (imageloadinglistener.isSyncLoading())
                {
                    s.run();
                    return;
                } else
                {
                    engine.submit(s);
                    return;
                }
            } else
            {
                imageloadinglistener.getDisplayer().display(imagesize, imageaware, LoadedFrom.MEMORY_CACHE);
                imageloadinglistener1.onLoadingComplete(s, imageaware.getWrappedView(), imagesize);
                return;
            }
        }
        if (imageloadinglistener.shouldShowImageOnLoading())
        {
            imageaware.setImageDrawable(imageloadinglistener.getImageOnLoading(configuration.resources));
        } else
        if (imageloadinglistener.isResetViewBeforeLoading())
        {
            imageaware.setImageDrawable(null);
        }
        s = new ImageLoadingInfo(s, imageaware, displayimageoptions, s1, imageloadinglistener, imageloadinglistener1, imageloadingprogresslistener, engine.getLockForUri(s));
        s = new LoadAndDisplayImageTask(engine, s, defineHandler(imageloadinglistener));
        if (imageloadinglistener.isSyncLoading())
        {
            s.run();
            return;
        } else
        {
            engine.submit(s);
            return;
        }
    }

    public void displayImage(String s, ImageAware imageaware, DisplayImageOptions displayimageoptions, ImageLoadingListener imageloadinglistener)
    {
        displayImage(s, imageaware, displayimageoptions, imageloadinglistener, null);
    }

    public void displayImage(String s, ImageAware imageaware, DisplayImageOptions displayimageoptions, ImageLoadingListener imageloadinglistener, ImageLoadingProgressListener imageloadingprogresslistener)
    {
        displayImage(s, imageaware, displayimageoptions, null, imageloadinglistener, imageloadingprogresslistener);
    }

    public void displayImage(String s, ImageAware imageaware, ImageLoadingListener imageloadinglistener)
    {
        displayImage(s, imageaware, null, imageloadinglistener, null);
    }

    public DiskCache getDiscCache()
    {
        return getDiskCache();
    }

    public DiskCache getDiskCache()
    {
        checkConfiguration();
        return configuration.diskCache;
    }

    public String getLoadingUriForView(ImageView imageview)
    {
        return engine.getLoadingUriForView(new ImageViewAware(imageview));
    }

    public String getLoadingUriForView(ImageAware imageaware)
    {
        return engine.getLoadingUriForView(imageaware);
    }

    public MemoryCache getMemoryCache()
    {
        checkConfiguration();
        return configuration.memoryCache;
    }

    public void handleSlowNetwork(boolean flag)
    {
        engine.handleSlowNetwork(flag);
    }

    public void init(ImageLoaderConfiguration imageloaderconfiguration)
    {
        this;
        JVM INSTR monitorenter ;
        if (imageloaderconfiguration != null)
        {
            break MISSING_BLOCK_LABEL_21;
        }
        throw new IllegalArgumentException("ImageLoader configuration can not be initialized with null");
        imageloaderconfiguration;
        this;
        JVM INSTR monitorexit ;
        throw imageloaderconfiguration;
        if (configuration != null)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        L.d("Initialize ImageLoader with configuration", new Object[0]);
        engine = new ImageLoaderEngine(imageloaderconfiguration);
        configuration = imageloaderconfiguration;
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
        L.w("Try to initialize ImageLoader which had already been initialized before. To re-init ImageLoader with new configuration call ImageLoader.destroy() at first.", new Object[0]);
          goto _L1
    }

    public boolean isInited()
    {
        return configuration != null;
    }

    public void loadImage(String s, DisplayImageOptions displayimageoptions, ImageLoadingListener imageloadinglistener)
    {
        loadImage(s, null, displayimageoptions, imageloadinglistener, null);
    }

    public void loadImage(String s, ImageSize imagesize, DisplayImageOptions displayimageoptions, ImageLoadingListener imageloadinglistener)
    {
        loadImage(s, imagesize, displayimageoptions, imageloadinglistener, null);
    }

    public void loadImage(String s, ImageSize imagesize, DisplayImageOptions displayimageoptions, ImageLoadingListener imageloadinglistener, ImageLoadingProgressListener imageloadingprogresslistener)
    {
        checkConfiguration();
        ImageSize imagesize1 = imagesize;
        if (imagesize == null)
        {
            imagesize1 = configuration.getMaxImageSize();
        }
        imagesize = displayimageoptions;
        if (displayimageoptions == null)
        {
            imagesize = configuration.defaultDisplayImageOptions;
        }
        displayImage(s, new NonViewAware(s, imagesize1, ViewScaleType.CROP), imagesize, imageloadinglistener, imageloadingprogresslistener);
    }

    public void loadImage(String s, ImageSize imagesize, ImageLoadingListener imageloadinglistener)
    {
        loadImage(s, imagesize, null, imageloadinglistener, null);
    }

    public void loadImage(String s, ImageLoadingListener imageloadinglistener)
    {
        loadImage(s, null, null, imageloadinglistener, null);
    }

    public Bitmap loadImageSync(String s)
    {
        return loadImageSync(s, null, null);
    }

    public Bitmap loadImageSync(String s, DisplayImageOptions displayimageoptions)
    {
        return loadImageSync(s, null, displayimageoptions);
    }

    public Bitmap loadImageSync(String s, ImageSize imagesize)
    {
        return loadImageSync(s, imagesize, null);
    }

    public Bitmap loadImageSync(String s, ImageSize imagesize, DisplayImageOptions displayimageoptions)
    {
        Object obj = displayimageoptions;
        if (displayimageoptions == null)
        {
            obj = configuration.defaultDisplayImageOptions;
        }
        displayimageoptions = (new DisplayImageOptions.Builder()).cloneFrom(((DisplayImageOptions) (obj))).syncLoading(true).build();
        obj = new SyncImageLoadingListener(null);
        loadImage(s, imagesize, displayimageoptions, ((ImageLoadingListener) (obj)));
        return ((SyncImageLoadingListener) (obj)).getLoadedBitmap();
    }

    public void pause()
    {
        engine.pause();
    }

    public void resume()
    {
        engine.resume();
    }

    public void setDefaultLoadingListener(ImageLoadingListener imageloadinglistener)
    {
        Object obj = imageloadinglistener;
        if (imageloadinglistener == null)
        {
            obj = new SimpleImageLoadingListener();
        }
        defaultListener = ((ImageLoadingListener) (obj));
    }

    public void stop()
    {
        engine.stop();
    }

}
