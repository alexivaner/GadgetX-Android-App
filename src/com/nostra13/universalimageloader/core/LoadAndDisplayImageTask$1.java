// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core;

import com.nostra13.universalimageloader.core.imageaware.ImageAware;
import com.nostra13.universalimageloader.core.listener.ImageLoadingProgressListener;

// Referenced classes of package com.nostra13.universalimageloader.core:
//            LoadAndDisplayImageTask

class val.total
    implements Runnable
{

    final LoadAndDisplayImageTask this$0;
    private final int val$current;
    private final int val$total;

    public void run()
    {
        progressListener.onProgressUpdate(uri, imageAware.getWrappedView(), val$current, val$total);
    }

    essListener()
    {
        this$0 = final_loadanddisplayimagetask;
        val$current = i;
        val$total = I.this;
        super();
    }
}
