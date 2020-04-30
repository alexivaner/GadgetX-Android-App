// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core.assist;

import java.io.IOException;
import java.io.InputStream;

public class ContentLengthInputStream extends InputStream
{

    private final int length;
    private final InputStream stream;

    public ContentLengthInputStream(InputStream inputstream, int i)
    {
        stream = inputstream;
        length = i;
    }

    public int available()
    {
        return length;
    }

    public void close()
        throws IOException
    {
        stream.close();
    }

    public void mark(int i)
    {
        stream.mark(i);
    }

    public boolean markSupported()
    {
        return stream.markSupported();
    }

    public int read()
        throws IOException
    {
        return stream.read();
    }

    public int read(byte abyte0[])
        throws IOException
    {
        return stream.read(abyte0);
    }

    public int read(byte abyte0[], int i, int j)
        throws IOException
    {
        return stream.read(abyte0, i, j);
    }

    public void reset()
        throws IOException
    {
        stream.reset();
    }

    public long skip(long l)
        throws IOException
    {
        return stream.skip(l);
    }
}
