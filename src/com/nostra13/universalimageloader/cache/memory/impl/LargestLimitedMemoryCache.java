// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.cache.memory.impl;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.cache.memory.LimitedMemoryCache;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class LargestLimitedMemoryCache extends LimitedMemoryCache
{

    private final Map valueSizes = Collections.synchronizedMap(new HashMap());

    public LargestLimitedMemoryCache(int i)
    {
        super(i);
    }

    public void clear()
    {
        valueSizes.clear();
        super.clear();
    }

    protected Reference createReference(Bitmap bitmap)
    {
        return new WeakReference(bitmap);
    }

    protected int getSize(Bitmap bitmap)
    {
        return bitmap.getRowBytes() * bitmap.getHeight();
    }

    public boolean put(String s, Bitmap bitmap)
    {
        if (super.put(s, bitmap))
        {
            valueSizes.put(bitmap, Integer.valueOf(getSize(bitmap)));
            return true;
        } else
        {
            return false;
        }
    }

    public Bitmap remove(String s)
    {
        Bitmap bitmap = super.get(s);
        if (bitmap != null)
        {
            valueSizes.remove(bitmap);
        }
        return super.remove(s);
    }

    protected Bitmap removeNext()
    {
        Bitmap bitmap;
        Integer integer;
        Object obj;
        integer = null;
        bitmap = null;
        obj = valueSizes.entrySet();
        Map map = valueSizes;
        map;
        JVM INSTR monitorenter ;
        Iterator iterator = ((Set) (obj)).iterator();
_L2:
        if (!iterator.hasNext())
        {
            valueSizes.remove(bitmap);
            return bitmap;
        }
        java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
        if (bitmap != null)
        {
            break MISSING_BLOCK_LABEL_98;
        }
        bitmap = (Bitmap)entry.getKey();
        integer = (Integer)entry.getValue();
        continue; /* Loop/switch isn't completed */
        obj = (Integer)entry.getValue();
        if (((Integer) (obj)).intValue() <= integer.intValue())
        {
            continue; /* Loop/switch isn't completed */
        }
        integer = ((Integer) (obj));
        bitmap = (Bitmap)entry.getKey();
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        map;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
