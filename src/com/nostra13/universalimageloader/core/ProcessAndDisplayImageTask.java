// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core;

import android.graphics.Bitmap;
import android.os.Handler;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;
import com.nostra13.universalimageloader.core.process.BitmapProcessor;
import com.nostra13.universalimageloader.utils.L;

// Referenced classes of package com.nostra13.universalimageloader.core:
//            ImageLoadingInfo, DisplayBitmapTask, DisplayImageOptions, LoadAndDisplayImageTask, 
//            ImageLoaderEngine

final class ProcessAndDisplayImageTask
    implements Runnable
{

    private static final String LOG_POSTPROCESS_IMAGE = "PostProcess image before displaying [%s]";
    private final Bitmap bitmap;
    private final ImageLoaderEngine engine;
    private final Handler handler;
    private final ImageLoadingInfo imageLoadingInfo;

    public ProcessAndDisplayImageTask(ImageLoaderEngine imageloaderengine, Bitmap bitmap1, ImageLoadingInfo imageloadinginfo, Handler handler1)
    {
        engine = imageloaderengine;
        bitmap = bitmap1;
        imageLoadingInfo = imageloadinginfo;
        handler = handler1;
    }

    public void run()
    {
        L.d("PostProcess image before displaying [%s]", new Object[] {
            imageLoadingInfo.memoryCacheKey
        });
        LoadAndDisplayImageTask.runTask(new DisplayBitmapTask(imageLoadingInfo.options.getPostProcessor().process(bitmap), imageLoadingInfo, engine, LoadedFrom.MEMORY_CACHE), imageLoadingInfo.options.isSyncLoading(), handler, engine);
    }
}
