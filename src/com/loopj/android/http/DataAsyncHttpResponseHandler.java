// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;

import android.os.Message;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.HttpEntity;
import org.apache.http.util.ByteArrayBuffer;

// Referenced classes of package com.loopj.android.http:
//            AsyncHttpResponseHandler, AsyncHttpClient

public abstract class DataAsyncHttpResponseHandler extends AsyncHttpResponseHandler
{

    private static final String LOG_TAG = "DataAsyncHttpResponseHandler";
    protected static final int PROGRESS_DATA_MESSAGE = 6;

    public DataAsyncHttpResponseHandler()
    {
    }

    public static byte[] copyOfRange(byte abyte0[], int i, int j)
        throws ArrayIndexOutOfBoundsException, IllegalArgumentException, NullPointerException
    {
        if (i > j)
        {
            throw new IllegalArgumentException();
        }
        int k = abyte0.length;
        if (i < 0 || i > k)
        {
            throw new ArrayIndexOutOfBoundsException();
        } else
        {
            j -= i;
            k = Math.min(j, k - i);
            byte abyte1[] = new byte[j];
            System.arraycopy(abyte0, i, abyte1, 0, k);
            return abyte1;
        }
    }

    byte[] getResponseData(HttpEntity httpentity)
        throws IOException
    {
        byte abyte0[];
        InputStream inputstream;
        long l;
        Object obj = null;
        abyte0 = obj;
        if (httpentity == null)
        {
            break MISSING_BLOCK_LABEL_160;
        }
        inputstream = httpentity.getContent();
        abyte0 = obj;
        if (inputstream == null)
        {
            break MISSING_BLOCK_LABEL_160;
        }
        long l1 = httpentity.getContentLength();
        if (l1 > 0x7fffffffL)
        {
            throw new IllegalArgumentException("HTTP entity too large to be buffered in memory");
        }
        l = l1;
        if (l1 < 0L)
        {
            l = 4096L;
        }
        httpentity = new ByteArrayBuffer((int)l);
        abyte0 = new byte[4096];
_L1:
        int i = inputstream.read(abyte0);
        if (i == -1)
        {
            break MISSING_BLOCK_LABEL_150;
        }
        if (Thread.currentThread().isInterrupted())
        {
            break MISSING_BLOCK_LABEL_150;
        }
        httpentity.append(abyte0, 0, i);
        sendProgressDataMessage(copyOfRange(abyte0, 0, i));
          goto _L1
        httpentity;
        try
        {
            AsyncHttpClient.silentCloseInputStream(inputstream);
            throw httpentity;
        }
        // Misplaced declaration of an exception variable
        catch (HttpEntity httpentity)
        {
            System.gc();
        }
        throw new IOException("File too large to fit into available memory");
        AsyncHttpClient.silentCloseInputStream(inputstream);
        abyte0 = httpentity.toByteArray();
        return abyte0;
    }

    protected void handleMessage(Message message)
    {
        super.handleMessage(message);
        switch (message.what)
        {
        default:
            return;

        case 6: // '\006'
            message = ((Message) ((Object[])(Object[])message.obj));
            break;
        }
        if (message != null && message.length >= 1)
        {
            try
            {
                onProgressData((byte[])(byte[])message[0]);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Message message)
            {
                Log.e("DataAsyncHttpResponseHandler", "custom onProgressData contains an error", message);
            }
            return;
        } else
        {
            Log.e("DataAsyncHttpResponseHandler", "PROGRESS_DATA_MESSAGE didn't got enough params");
            return;
        }
    }

    public void onProgressData(byte abyte0[])
    {
        Log.d("DataAsyncHttpResponseHandler", "onProgressData(byte[]) was not overriden, but callback was received");
    }

    public final void sendProgressDataMessage(byte abyte0[])
    {
        sendMessage(obtainMessage(6, ((Object) (new Object[] {
            abyte0
        }))));
    }
}
