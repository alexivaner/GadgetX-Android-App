// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.util.zip.GZIPInputStream;
import org.apache.http.HttpEntity;
import org.apache.http.entity.HttpEntityWrapper;

// Referenced classes of package com.loopj.android.http:
//            AsyncHttpClient

private static class  extends HttpEntityWrapper
{

    GZIPInputStream gzippedStream;
    PushbackInputStream pushbackStream;
    InputStream wrappedStream;

    public void consumeContent()
        throws IOException
    {
        AsyncHttpClient.silentCloseInputStream(wrappedStream);
        AsyncHttpClient.silentCloseInputStream(pushbackStream);
        AsyncHttpClient.silentCloseInputStream(gzippedStream);
        super.consumeContent();
    }

    public InputStream getContent()
        throws IOException
    {
        wrappedStream = wrappedEntity.getContent();
        pushbackStream = new PushbackInputStream(wrappedStream, 2);
        if (AsyncHttpClient.isInputStreamGZIPCompressed(pushbackStream))
        {
            gzippedStream = new GZIPInputStream(pushbackStream);
            return gzippedStream;
        } else
        {
            return pushbackStream;
        }
    }

    public long getContentLength()
    {
        if (wrappedEntity == null)
        {
            return 0L;
        } else
        {
            return wrappedEntity.getContentLength();
        }
    }

    public (HttpEntity httpentity)
    {
        super(httpentity);
    }
}
