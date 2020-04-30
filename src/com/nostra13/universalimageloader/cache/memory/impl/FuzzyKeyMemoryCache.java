// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.cache.memory.impl;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.cache.memory.MemoryCache;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

public class FuzzyKeyMemoryCache
    implements MemoryCache
{

    private final MemoryCache cache;
    private final Comparator keyComparator;

    public FuzzyKeyMemoryCache(MemoryCache memorycache, Comparator comparator)
    {
        cache = memorycache;
        keyComparator = comparator;
    }

    public void clear()
    {
        cache.clear();
    }

    public Bitmap get(String s)
    {
        return cache.get(s);
    }

    public Collection keys()
    {
        return cache.keys();
    }

    public boolean put(String s, Bitmap bitmap)
    {
        MemoryCache memorycache = cache;
        memorycache;
        JVM INSTR monitorenter ;
        String s1 = null;
        Iterator iterator = cache.keys().iterator();
_L5:
        if (iterator.hasNext()) goto _L2; else goto _L1
_L1:
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_52;
        }
        cache.remove(s1);
        memorycache;
        JVM INSTR monitorexit ;
        return cache.put(s, bitmap);
_L2:
        String s2;
        s2 = (String)iterator.next();
        if (keyComparator.compare(s, s2) != 0)
        {
            break; /* Loop/switch isn't completed */
        }
        s1 = s2;
        if (true) goto _L1; else goto _L3
_L3:
        if (true) goto _L5; else goto _L4
_L4:
        s;
        memorycache;
        JVM INSTR monitorexit ;
        throw s;
    }

    public Bitmap remove(String s)
    {
        return cache.remove(s);
    }
}
