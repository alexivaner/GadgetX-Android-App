// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.utils;

import com.nostra13.universalimageloader.cache.disc.DiskCache;
import java.io.File;

public final class DiskCacheUtils
{

    private DiskCacheUtils()
    {
    }

    public static File findInCache(String s, DiskCache diskcache)
    {
        s = diskcache.get(s);
        if (s != null && s.exists())
        {
            return s;
        } else
        {
            return null;
        }
    }

    public static boolean removeFromCache(String s, DiskCache diskcache)
    {
        s = diskcache.get(s);
        return s != null && s.exists() && s.delete();
    }
}
