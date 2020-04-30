// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.cache.memory.impl;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.cache.memory.MemoryCache;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LimitedAgeMemoryCache
    implements MemoryCache
{

    private final MemoryCache cache;
    private final Map loadingDates = Collections.synchronizedMap(new HashMap());
    private final long maxAge;

    public LimitedAgeMemoryCache(MemoryCache memorycache, long l)
    {
        cache = memorycache;
        maxAge = 1000L * l;
    }

    public void clear()
    {
        cache.clear();
        loadingDates.clear();
    }

    public Bitmap get(String s)
    {
        Long long1 = (Long)loadingDates.get(s);
        if (long1 != null && System.currentTimeMillis() - long1.longValue() > maxAge)
        {
            cache.remove(s);
            loadingDates.remove(s);
        }
        return cache.get(s);
    }

    public Collection keys()
    {
        return cache.keys();
    }

    public boolean put(String s, Bitmap bitmap)
    {
        boolean flag = cache.put(s, bitmap);
        if (flag)
        {
            loadingDates.put(s, Long.valueOf(System.currentTimeMillis()));
        }
        return flag;
    }

    public Bitmap remove(String s)
    {
        loadingDates.remove(s);
        return cache.remove(s);
    }
}
