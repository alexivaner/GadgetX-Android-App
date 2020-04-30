// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;
import org.apache.http.util.ByteArrayBuffer;

// Referenced classes of package com.loopj.android.http:
//            ResponseHandlerInterface, AsyncHttpClient, AssertUtils

public abstract class AsyncHttpResponseHandler
    implements ResponseHandlerInterface
{
    private static class ResponderHandler extends Handler
    {

        private final AsyncHttpResponseHandler mResponder;

        public void handleMessage(Message message)
        {
            mResponder.handleMessage(message);
        }

        ResponderHandler(AsyncHttpResponseHandler asynchttpresponsehandler, Looper looper1)
        {
            super(looper1);
            mResponder = asynchttpresponsehandler;
        }
    }


    protected static final int BUFFER_SIZE = 4096;
    protected static final int CANCEL_MESSAGE = 6;
    public static final String DEFAULT_CHARSET = "UTF-8";
    protected static final int FAILURE_MESSAGE = 1;
    protected static final int FINISH_MESSAGE = 3;
    private static final String LOG_TAG = "AsyncHttpResponseHandler";
    protected static final int PROGRESS_MESSAGE = 4;
    protected static final int RETRY_MESSAGE = 5;
    protected static final int START_MESSAGE = 2;
    protected static final int SUCCESS_MESSAGE = 0;
    public static final String UTF8_BOM = "\uFEFF";
    private Handler handler;
    private Looper looper;
    private Header requestHeaders[];
    private URI requestURI;
    private String responseCharset;
    private boolean useSynchronousMode;

    public AsyncHttpResponseHandler()
    {
        this(null);
    }

    public AsyncHttpResponseHandler(Looper looper1)
    {
        responseCharset = "UTF-8";
        requestURI = null;
        requestHeaders = null;
        looper = null;
        Looper looper2 = looper1;
        if (looper1 == null)
        {
            looper2 = Looper.myLooper();
        }
        looper = looper2;
        setUseSynchronousMode(false);
    }

    public String getCharset()
    {
        if (responseCharset == null)
        {
            return "UTF-8";
        } else
        {
            return responseCharset;
        }
    }

    public Header[] getRequestHeaders()
    {
        return requestHeaders;
    }

    public URI getRequestURI()
    {
        return requestURI;
    }

    byte[] getResponseData(HttpEntity httpentity)
        throws IOException
    {
        Object obj;
        InputStream inputstream;
        long l;
        long l1;
        int i = 4096;
        byte abyte0[] = null;
        obj = abyte0;
        if (httpentity == null)
        {
            break MISSING_BLOCK_LABEL_196;
        }
        inputstream = httpentity.getContent();
        obj = abyte0;
        if (inputstream == null)
        {
            break MISSING_BLOCK_LABEL_196;
        }
        l1 = httpentity.getContentLength();
        if (l1 > 0x7fffffffL)
        {
            throw new IllegalArgumentException("HTTP entity too large to be buffered in memory");
        }
        int j;
        if (l1 > 0L)
        {
            i = (int)l1;
        }
        obj = new ByteArrayBuffer(i);
        abyte0 = new byte[4096];
        i = 0;
_L1:
        j = inputstream.read(abyte0);
        if (j == -1)
        {
            break MISSING_BLOCK_LABEL_182;
        }
        if (Thread.currentThread().isInterrupted())
        {
            break MISSING_BLOCK_LABEL_182;
        }
        i += j;
        ((ByteArrayBuffer) (obj)).append(abyte0, 0, j);
        if (l1 <= 0L)
        {
            l = 1L;
        } else
        {
            l = l1;
        }
        sendProgressMessage(i, (int)l);
          goto _L1
        obj;
        try
        {
            AsyncHttpClient.silentCloseInputStream(inputstream);
            AsyncHttpClient.endEntityViaReflection(httpentity);
            throw obj;
        }
        // Misplaced declaration of an exception variable
        catch (HttpEntity httpentity)
        {
            System.gc();
        }
        throw new IOException("File too large to fit into available memory");
        AsyncHttpClient.silentCloseInputStream(inputstream);
        AsyncHttpClient.endEntityViaReflection(httpentity);
        obj = ((ByteArrayBuffer) (obj)).toByteArray();
        return ((byte []) (obj));
    }

    public boolean getUseSynchronousMode()
    {
        return useSynchronousMode;
    }

    protected void handleMessage(Message message)
    {
        switch (message.what)
        {
        default:
            return;

        case 0: // '\0'
            message = ((Message) ((Object[])(Object[])message.obj));
            if (message != null && message.length >= 3)
            {
                onSuccess(((Integer)message[0]).intValue(), (Header[])(Header[])message[1], (byte[])(byte[])message[2]);
                return;
            } else
            {
                Log.e("AsyncHttpResponseHandler", "SUCCESS_MESSAGE didn't got enough params");
                return;
            }

        case 1: // '\001'
            message = ((Message) ((Object[])(Object[])message.obj));
            if (message != null && message.length >= 4)
            {
                onFailure(((Integer)message[0]).intValue(), (Header[])(Header[])message[1], (byte[])(byte[])message[2], (Throwable)message[3]);
                return;
            } else
            {
                Log.e("AsyncHttpResponseHandler", "FAILURE_MESSAGE didn't got enough params");
                return;
            }

        case 2: // '\002'
            onStart();
            return;

        case 3: // '\003'
            onFinish();
            return;

        case 4: // '\004'
            message = ((Message) ((Object[])(Object[])message.obj));
            if (message != null && message.length >= 2)
            {
                try
                {
                    onProgress(((Integer)message[0]).intValue(), ((Integer)message[1]).intValue());
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Message message)
                {
                    Log.e("AsyncHttpResponseHandler", "custom onProgress contains an error", message);
                }
                return;
            } else
            {
                Log.e("AsyncHttpResponseHandler", "PROGRESS_MESSAGE didn't got enough params");
                return;
            }

        case 5: // '\005'
            message = ((Message) ((Object[])(Object[])message.obj));
            if (message != null && message.length == 1)
            {
                onRetry(((Integer)message[0]).intValue());
                return;
            } else
            {
                Log.e("AsyncHttpResponseHandler", "RETRY_MESSAGE didn't get enough params");
                return;
            }

        case 6: // '\006'
            onCancel();
            return;
        }
    }

    protected Message obtainMessage(int i, Object obj)
    {
        return Message.obtain(handler, i, obj);
    }

    public void onCancel()
    {
        Log.d("AsyncHttpResponseHandler", "Request got cancelled");
    }

    public abstract void onFailure(int i, Header aheader[], byte abyte0[], Throwable throwable);

    public void onFinish()
    {
    }

    public void onPostProcessResponse(ResponseHandlerInterface responsehandlerinterface, HttpResponse httpresponse)
    {
    }

    public void onPreProcessResponse(ResponseHandlerInterface responsehandlerinterface, HttpResponse httpresponse)
    {
    }

    public void onProgress(int i, int j)
    {
        double d;
        if (j > 0)
        {
            d = (((double)i * 1.0D) / (double)j) * 100D;
        } else
        {
            d = -1D;
        }
        Log.v("AsyncHttpResponseHandler", String.format("Progress %d from %d (%2.0f%%)", new Object[] {
            Integer.valueOf(i), Integer.valueOf(j), Double.valueOf(d)
        }));
    }

    public void onRetry(int i)
    {
        Log.d("AsyncHttpResponseHandler", String.format("Request retry no. %d", new Object[] {
            Integer.valueOf(i)
        }));
    }

    public void onStart()
    {
    }

    public abstract void onSuccess(int i, Header aheader[], byte abyte0[]);

    protected void postRunnable(Runnable runnable)
    {
label0:
        {
            if (runnable != null)
            {
                if (!getUseSynchronousMode() && handler != null)
                {
                    break label0;
                }
                runnable.run();
            }
            return;
        }
        boolean flag;
        if (handler != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        AssertUtils.asserts(flag, "handler should not be null!");
        handler.post(runnable);
    }

    public final void sendCancelMessage()
    {
        sendMessage(obtainMessage(6, null));
    }

    public final void sendFailureMessage(int i, Header aheader[], byte abyte0[], Throwable throwable)
    {
        sendMessage(obtainMessage(1, ((Object) (new Object[] {
            Integer.valueOf(i), aheader, abyte0, throwable
        }))));
    }

    public final void sendFinishMessage()
    {
        sendMessage(obtainMessage(3, null));
    }

    protected void sendMessage(Message message)
    {
        if (getUseSynchronousMode() || handler == null)
        {
            handleMessage(message);
        } else
        if (!Thread.currentThread().isInterrupted())
        {
            boolean flag;
            if (handler != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            AssertUtils.asserts(flag, "handler should not be null!");
            handler.sendMessage(message);
            return;
        }
    }

    public final void sendProgressMessage(int i, int j)
    {
        sendMessage(obtainMessage(4, ((Object) (new Object[] {
            Integer.valueOf(i), Integer.valueOf(j)
        }))));
    }

    public void sendResponseMessage(HttpResponse httpresponse)
        throws IOException
    {
        StatusLine statusline;
        byte abyte0[];
label0:
        {
            if (!Thread.currentThread().isInterrupted())
            {
                statusline = httpresponse.getStatusLine();
                abyte0 = getResponseData(httpresponse.getEntity());
                if (!Thread.currentThread().isInterrupted())
                {
                    if (statusline.getStatusCode() < 300)
                    {
                        break label0;
                    }
                    sendFailureMessage(statusline.getStatusCode(), httpresponse.getAllHeaders(), abyte0, new HttpResponseException(statusline.getStatusCode(), statusline.getReasonPhrase()));
                }
            }
            return;
        }
        sendSuccessMessage(statusline.getStatusCode(), httpresponse.getAllHeaders(), abyte0);
    }

    public final void sendRetryMessage(int i)
    {
        sendMessage(obtainMessage(5, ((Object) (new Object[] {
            Integer.valueOf(i)
        }))));
    }

    public final void sendStartMessage()
    {
        sendMessage(obtainMessage(2, null));
    }

    public final void sendSuccessMessage(int i, Header aheader[], byte abyte0[])
    {
        sendMessage(obtainMessage(0, ((Object) (new Object[] {
            Integer.valueOf(i), aheader, abyte0
        }))));
    }

    public void setCharset(String s)
    {
        responseCharset = s;
    }

    public void setRequestHeaders(Header aheader[])
    {
        requestHeaders = aheader;
    }

    public void setRequestURI(URI uri)
    {
        requestURI = uri;
    }

    public void setUseSynchronousMode(boolean flag)
    {
        boolean flag1;
        flag1 = flag;
        if (!flag)
        {
            flag1 = flag;
            if (looper == null)
            {
                flag1 = true;
                Log.w("AsyncHttpResponseHandler", "Current thread has not called Looper.prepare(). Forcing synchronous mode.");
            }
        }
        if (flag1 || handler != null) goto _L2; else goto _L1
_L1:
        handler = new ResponderHandler(this, looper);
_L4:
        useSynchronousMode = flag1;
        return;
_L2:
        if (flag1 && handler != null)
        {
            handler = null;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }
}
