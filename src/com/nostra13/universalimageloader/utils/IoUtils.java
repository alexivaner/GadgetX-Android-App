// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.utils;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class IoUtils
{
    public static interface CopyListener
    {

        public abstract boolean onBytesCopied(int i, int j);
    }


    public static final int CONTINUE_LOADING_PERCENTAGE = 75;
    public static final int DEFAULT_BUFFER_SIZE = 32768;
    public static final int DEFAULT_IMAGE_TOTAL_SIZE = 0x7d000;

    private IoUtils()
    {
    }

    public static void closeSilently(Closeable closeable)
    {
        if (closeable == null)
        {
            break MISSING_BLOCK_LABEL_10;
        }
        closeable.close();
        return;
        closeable;
    }

    public static boolean copyStream(InputStream inputstream, OutputStream outputstream, CopyListener copylistener)
        throws IOException
    {
        return copyStream(inputstream, outputstream, copylistener, 32768);
    }

    public static boolean copyStream(InputStream inputstream, OutputStream outputstream, CopyListener copylistener, int i)
        throws IOException
    {
        int k = 0;
        int l = inputstream.available();
        int j = l;
        if (l <= 0)
        {
            j = 0x7d000;
        }
        byte abyte0[] = new byte[i];
        if (!shouldStopLoading(copylistener, 0, j))
        {
            do
            {
                i1 = inputstream.read(abyte0, 0, i);
                if (i1 == -1)
                {
                    outputstream.flush();
                    return true;
                }
                outputstream.write(abyte0, 0, i1);
                k += i1;
            } while (!shouldStopLoading(copylistener, k, j));
        }
        return false;
    }

    public static void readAndCloseStream(InputStream inputstream)
    {
        byte abyte0[] = new byte[32768];
        int i;
        do
        {
            i = inputstream.read(abyte0, 0, 32768);
        } while (i != -1);
        closeSilently(inputstream);
        return;
        Object obj;
        obj;
        closeSilently(inputstream);
        return;
        obj;
        closeSilently(inputstream);
        throw obj;
    }

    private static boolean shouldStopLoading(CopyListener copylistener, int i, int j)
    {
        return copylistener != null && !copylistener.onBytesCopied(i, j) && (i * 100) / j < 75;
    }
}
