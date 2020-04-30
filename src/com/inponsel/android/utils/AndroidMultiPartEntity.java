// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.utils;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;

public class AndroidMultiPartEntity extends MultipartEntity
{
    public static class CountingOutputStream extends FilterOutputStream
    {

        private final ProgressListener listener;
        private long transferred;

        public void write(int i)
            throws IOException
        {
            out.write(i);
            transferred = transferred + 1L;
            listener.transferred(transferred);
        }

        public void write(byte abyte0[], int i, int j)
            throws IOException
        {
            out.write(abyte0, i, j);
            transferred = transferred + (long)j;
            listener.transferred(transferred);
        }

        public CountingOutputStream(OutputStream outputstream, ProgressListener progresslistener)
        {
            super(outputstream);
            listener = progresslistener;
            transferred = 0L;
        }
    }

    public static interface ProgressListener
    {

        public abstract void transferred(long l);
    }


    private final ProgressListener listener;

    public AndroidMultiPartEntity(ProgressListener progresslistener)
    {
        listener = progresslistener;
    }

    public AndroidMultiPartEntity(HttpMultipartMode httpmultipartmode, ProgressListener progresslistener)
    {
        super(httpmultipartmode);
        listener = progresslistener;
    }

    public AndroidMultiPartEntity(HttpMultipartMode httpmultipartmode, String s, Charset charset, ProgressListener progresslistener)
    {
        super(httpmultipartmode, s, charset);
        listener = progresslistener;
    }

    public void writeTo(OutputStream outputstream)
        throws IOException
    {
        super.writeTo(new CountingOutputStream(outputstream, listener));
    }
}
