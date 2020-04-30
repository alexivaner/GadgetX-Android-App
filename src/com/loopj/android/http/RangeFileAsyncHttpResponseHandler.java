// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;

import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.methods.HttpUriRequest;

// Referenced classes of package com.loopj.android.http:
//            FileAsyncHttpResponseHandler

public abstract class RangeFileAsyncHttpResponseHandler extends FileAsyncHttpResponseHandler
{

    private static final String LOG_TAG = "RangeFileAsyncHttpResponseHandler";
    private boolean append;
    private long current;

    public RangeFileAsyncHttpResponseHandler(File file)
    {
        super(file);
        current = 0L;
        append = false;
    }

    protected byte[] getResponseData(HttpEntity httpentity)
        throws IOException
    {
        InputStream inputstream;
        long l;
        if (httpentity == null)
        {
            break MISSING_BLOCK_LABEL_144;
        }
        inputstream = httpentity.getContent();
        l = httpentity.getContentLength() + current;
        httpentity = new FileOutputStream(getTargetFile(), append);
        if (inputstream == null)
        {
            break MISSING_BLOCK_LABEL_144;
        }
        byte abyte0[] = new byte[4096];
_L1:
        int i;
        if (current >= l)
        {
            break MISSING_BLOCK_LABEL_132;
        }
        i = inputstream.read(abyte0);
        if (i == -1)
        {
            break MISSING_BLOCK_LABEL_132;
        }
        if (Thread.currentThread().isInterrupted())
        {
            break MISSING_BLOCK_LABEL_132;
        }
        current = current + (long)i;
        httpentity.write(abyte0, 0, i);
        sendProgressMessage((int)current, (int)l);
          goto _L1
        Exception exception;
        exception;
        inputstream.close();
        httpentity.flush();
        httpentity.close();
        throw exception;
        inputstream.close();
        httpentity.flush();
        httpentity.close();
        return null;
    }

    public void sendResponseMessage(HttpResponse httpresponse)
        throws IOException
    {
        if (Thread.currentThread().isInterrupted()) goto _L2; else goto _L1
_L1:
        StatusLine statusline = httpresponse.getStatusLine();
        if (statusline.getStatusCode() != 416) goto _L4; else goto _L3
_L3:
        if (!Thread.currentThread().isInterrupted())
        {
            sendSuccessMessage(statusline.getStatusCode(), httpresponse.getAllHeaders(), null);
        }
_L2:
        return;
_L4:
        if (statusline.getStatusCode() < 300)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (Thread.currentThread().isInterrupted()) goto _L2; else goto _L5
_L5:
        sendFailureMessage(statusline.getStatusCode(), httpresponse.getAllHeaders(), null, new HttpResponseException(statusline.getStatusCode(), statusline.getReasonPhrase()));
        return;
        if (Thread.currentThread().isInterrupted()) goto _L2; else goto _L6
_L6:
        Header header = httpresponse.getFirstHeader("Content-Range");
        if (header == null)
        {
            append = false;
            current = 0L;
        } else
        {
            Log.v("RangeFileAsyncHttpResponseHandler", (new StringBuilder()).append("Content-Range: ").append(header.getValue()).toString());
        }
        sendSuccessMessage(statusline.getStatusCode(), httpresponse.getAllHeaders(), getResponseData(httpresponse.getEntity()));
        return;
    }

    public void updateRequestHeaders(HttpUriRequest httpurirequest)
    {
        if (mFile.exists() && mFile.canWrite())
        {
            current = mFile.length();
        }
        if (current > 0L)
        {
            append = true;
            httpurirequest.setHeader("Range", (new StringBuilder()).append("bytes=").append(current).append("-").toString());
        }
    }
}
