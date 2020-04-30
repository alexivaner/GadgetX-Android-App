// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.cache.disc.impl.ext;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.nostra13.universalimageloader.cache.disc.impl.ext:
//            DiskLruCache, Util

public final class <init>
    implements Closeable
{

    private File files[];
    private final InputStream ins[];
    private final String key;
    private final long lengths[];
    private final long sequenceNumber;
    final DiskLruCache this$0;

    public void close()
    {
        InputStream ainputstream[] = ins;
        int j = ainputstream.length;
        int i = 0;
        do
        {
            if (i >= j)
            {
                return;
            }
            Util.closeQuietly(ainputstream[i]);
            i++;
        } while (true);
    }

    public ins edit()
        throws IOException
    {
        return DiskLruCache.access$6(DiskLruCache.this, key, sequenceNumber);
    }

    public File getFile(int i)
    {
        return files[i];
    }

    public InputStream getInputStream(int i)
    {
        return ins[i];
    }

    public long getLength(int i)
    {
        return lengths[i];
    }

    public String getString(int i)
        throws IOException
    {
        return DiskLruCache.access$7(getInputStream(i));
    }

    private Q(String s, long l, File afile[], InputStream ainputstream[], long al[])
    {
        this$0 = DiskLruCache.this;
        super();
        key = s;
        sequenceNumber = l;
        files = afile;
        ins = ainputstream;
        lengths = al;
    }

    lengths(String s, long l, File afile[], InputStream ainputstream[], long al[], 
            lengths lengths1)
    {
        this(s, l, afile, ainputstream, al);
    }
}
