// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.cache.disc.impl.ext;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

// Referenced classes of package com.nostra13.universalimageloader.cache.disc.impl.ext:
//            DiskLruCache

private final class <init>
{

    private  currentEditor;
    private final String key;
    private final long lengths[];
    private boolean readable;
    private long sequenceNumber;
    final DiskLruCache this$0;

    private IOException invalidLengths(String as[])
        throws IOException
    {
        throw new IOException((new StringBuilder("unexpected journal line: ")).append(Arrays.toString(as)).toString());
    }

    private void setLengths(String as[])
        throws IOException
    {
        int i;
        if (as.length != DiskLruCache.access$8(DiskLruCache.this))
        {
            throw invalidLengths(as);
        }
        i = 0;
_L1:
        try
        {
            if (i >= as.length)
            {
                return;
            }
        }
        catch (NumberFormatException numberformatexception)
        {
            throw invalidLengths(as);
        }
        lengths[i] = Long.parseLong(as[i]);
        i++;
          goto _L1
    }

    public File getCleanFile(int i)
    {
        return new File(DiskLruCache.access$9(DiskLruCache.this), (new StringBuilder(String.valueOf(key))).append(i).toString());
    }

    public File getDirtyFile(int i)
    {
        return new File(DiskLruCache.access$9(DiskLruCache.this), (new StringBuilder(String.valueOf(key))).append(i).append(".tmp").toString());
    }

    public String getLengths()
        throws IOException
    {
        StringBuilder stringbuilder = new StringBuilder();
        long al[] = lengths;
        int j = al.length;
        int i = 0;
        do
        {
            if (i >= j)
            {
                return stringbuilder.toString();
            }
            long l = al[i];
            stringbuilder.append(' ').append(l);
            i++;
        } while (true);
    }










    private (String s)
    {
        this$0 = DiskLruCache.this;
        super();
        key = s;
        lengths = new long[DiskLruCache.access$8(DiskLruCache.this)];
    }

    ._cls8(String s, ._cls8 _pcls8)
    {
        this(s);
    }
}
