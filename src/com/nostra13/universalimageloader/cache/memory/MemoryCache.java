// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.cache.memory;

import android.graphics.Bitmap;
import java.util.Collection;

public interface MemoryCache
{

    public abstract void clear();

    public abstract Bitmap get(String s);

    public abstract Collection keys();

    public abstract boolean put(String s, Bitmap bitmap);

    public abstract Bitmap remove(String s);
}
