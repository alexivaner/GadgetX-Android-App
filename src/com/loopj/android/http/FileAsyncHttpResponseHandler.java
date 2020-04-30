// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;

// Referenced classes of package com.loopj.android.http:
//            AsyncHttpResponseHandler, AssertUtils, AsyncHttpClient

public abstract class FileAsyncHttpResponseHandler extends AsyncHttpResponseHandler
{

    static final boolean $assertionsDisabled;
    private static final String LOG_TAG = "FileAsyncHttpResponseHandler";
    protected final boolean append;
    protected final File mFile;

    public FileAsyncHttpResponseHandler(Context context)
    {
        mFile = getTemporaryFile(context);
        append = false;
    }

    public FileAsyncHttpResponseHandler(File file)
    {
        this(file, false);
    }

    public FileAsyncHttpResponseHandler(File file, boolean flag)
    {
        boolean flag1;
        if (file != null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        AssertUtils.asserts(flag1, "File passed into FileAsyncHttpResponseHandler constructor must not be null");
        mFile = file;
        append = flag;
    }

    public boolean deleteTargetFile()
    {
        return getTargetFile() != null && getTargetFile().delete();
    }

    protected byte[] getResponseData(HttpEntity httpentity)
        throws IOException
    {
        InputStream inputstream;
        long l;
        if (httpentity == null)
        {
            break MISSING_BLOCK_LABEL_124;
        }
        inputstream = httpentity.getContent();
        l = httpentity.getContentLength();
        httpentity = new FileOutputStream(getTargetFile(), append);
        if (inputstream == null)
        {
            break MISSING_BLOCK_LABEL_124;
        }
        byte abyte0[] = new byte[4096];
        int i = 0;
_L1:
        int j = inputstream.read(abyte0);
        if (j == -1)
        {
            break MISSING_BLOCK_LABEL_112;
        }
        if (Thread.currentThread().isInterrupted())
        {
            break MISSING_BLOCK_LABEL_112;
        }
        i += j;
        httpentity.write(abyte0, 0, j);
        sendProgressMessage(i, (int)l);
          goto _L1
        Exception exception;
        exception;
        AsyncHttpClient.silentCloseInputStream(inputstream);
        httpentity.flush();
        AsyncHttpClient.silentCloseOutputStream(httpentity);
        throw exception;
        AsyncHttpClient.silentCloseInputStream(inputstream);
        httpentity.flush();
        AsyncHttpClient.silentCloseOutputStream(httpentity);
        return null;
    }

    protected File getTargetFile()
    {
        if (!$assertionsDisabled && mFile == null)
        {
            throw new AssertionError();
        } else
        {
            return mFile;
        }
    }

    protected File getTemporaryFile(Context context)
    {
        boolean flag;
        if (context != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        AssertUtils.asserts(flag, "Tried creating temporary file without having Context");
        if (!$assertionsDisabled && context == null)
        {
            try
            {
                throw new AssertionError();
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                Log.e("FileAsyncHttpResponseHandler", "Cannot create temporary file", context);
            }
            return null;
        }
        context = File.createTempFile("temp_", "_handled", context.getCacheDir());
        return context;
    }

    public abstract void onFailure(int i, Header aheader[], Throwable throwable, File file);

    public final void onFailure(int i, Header aheader[], byte abyte0[], Throwable throwable)
    {
        onFailure(i, aheader, throwable, getTargetFile());
    }

    public abstract void onSuccess(int i, Header aheader[], File file);

    public final void onSuccess(int i, Header aheader[], byte abyte0[])
    {
        onSuccess(i, aheader, getTargetFile());
    }

    static 
    {
        boolean flag;
        if (!com/loopj/android/http/FileAsyncHttpResponseHandler.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        $assertionsDisabled = flag;
    }
}
