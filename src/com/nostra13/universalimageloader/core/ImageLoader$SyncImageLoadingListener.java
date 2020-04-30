// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core;

import android.graphics.Bitmap;
import android.view.View;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

// Referenced classes of package com.nostra13.universalimageloader.core:
//            ImageLoader

private static class <init> extends SimpleImageLoadingListener
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

    private Q()
    {
    }

    Q(Q q)
    {
        this();
    }
}
