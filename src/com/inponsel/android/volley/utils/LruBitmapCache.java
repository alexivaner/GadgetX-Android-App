// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.volley.utils;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

public class LruBitmapCache extends LruCache
    implements com.android.volley.toolbox.ImageLoader.ImageCache
{

    public LruBitmapCache()
    {
        this(getDefaultLruCacheSize());
    }

    public LruBitmapCache(int i)
    {
        super(i);
    }

    public static int getDefaultLruCacheSize()
    {
        return (int)(Runtime.getRuntime().maxMemory() / 1024L) / 8;
    }

    public Bitmap getBitmap(String s)
    {
        return (Bitmap)get(s);
    }

    public void putBitmap(String s, Bitmap bitmap)
    {
        put(s, bitmap);
    }

    protected volatile int sizeOf(Object obj, Object obj1)
    {
        return sizeOf((String)obj, (Bitmap)obj1);
    }

    protected int sizeOf(String s, Bitmap bitmap)
    {
        return (bitmap.getRowBytes() * bitmap.getHeight()) / 1024;
    }
}
