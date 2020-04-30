// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core;

import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.imageaware.ImageAware;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

// Referenced classes of package com.nostra13.universalimageloader.core:
//            LoadAndDisplayImageTask, DisplayImageOptions, ImageLoaderConfiguration

class val.failCause
    implements Runnable
{

    final LoadAndDisplayImageTask this$0;
    private final Throwable val$failCause;
    private final com.nostra13.universalimageloader.core.assist.lCause val$failType;

    public void run()
    {
        if (options.shouldShowImageOnFail())
        {
            imageAware.setImageDrawable(options.getImageOnFail(LoadAndDisplayImageTask.access$0(LoadAndDisplayImageTask.this).resources));
        }
        listener.onLoadingFailed(uri, imageAware.getWrappedView(), new FailReason(val$failType, val$failCause));
    }

    ()
    {
        this$0 = final_loadanddisplayimagetask;
        val$failType = ;
        val$failCause = Throwable.this;
        super();
    }
}
