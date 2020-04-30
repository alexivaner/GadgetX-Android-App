// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core.assist;


public final class LoadedFrom extends Enum
{

    public static final LoadedFrom DISC_CACHE;
    private static final LoadedFrom ENUM$VALUES[];
    public static final LoadedFrom MEMORY_CACHE;
    public static final LoadedFrom NETWORK;

    private LoadedFrom(String s, int i)
    {
        super(s, i);
    }

    public static LoadedFrom valueOf(String s)
    {
        return (LoadedFrom)Enum.valueOf(com/nostra13/universalimageloader/core/assist/LoadedFrom, s);
    }

    public static LoadedFrom[] values()
    {
        LoadedFrom aloadedfrom[] = ENUM$VALUES;
        int i = aloadedfrom.length;
        LoadedFrom aloadedfrom1[] = new LoadedFrom[i];
        System.arraycopy(aloadedfrom, 0, aloadedfrom1, 0, i);
        return aloadedfrom1;
    }

    static 
    {
        NETWORK = new LoadedFrom("NETWORK", 0);
        DISC_CACHE = new LoadedFrom("DISC_CACHE", 1);
        MEMORY_CACHE = new LoadedFrom("MEMORY_CACHE", 2);
        ENUM$VALUES = (new LoadedFrom[] {
            NETWORK, DISC_CACHE, MEMORY_CACHE
        });
    }
}
