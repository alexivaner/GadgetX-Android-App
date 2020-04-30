// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;

import android.util.Log;
import java.io.UnsupportedEncodingException;
import org.apache.http.Header;

// Referenced classes of package com.loopj.android.http:
//            AsyncHttpResponseHandler

public abstract class TextHttpResponseHandler extends AsyncHttpResponseHandler
{

    private static final String LOG_TAG = "TextHttpResponseHandler";

    public TextHttpResponseHandler()
    {
        this("UTF-8");
    }

    public TextHttpResponseHandler(String s)
    {
        setCharset(s);
    }

    public static String getResponseString(byte abyte0[], String s)
    {
        if (abyte0 != null) goto _L2; else goto _L1
_L1:
        abyte0 = null;
_L4:
        s = abyte0;
        if (abyte0 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        s = abyte0;
        if (abyte0.startsWith("\uFEFF"))
        {
            return abyte0.substring(1);
        }
        break; /* Loop/switch isn't completed */
_L2:
        abyte0 = new String(abyte0, s);
        if (true) goto _L4; else goto _L3
        abyte0;
        Log.e("TextHttpResponseHandler", "Encoding response into string failed", abyte0);
        s = null;
_L3:
        return s;
    }

    public abstract void onFailure(int i, Header aheader[], String s, Throwable throwable);

    public void onFailure(int i, Header aheader[], byte abyte0[], Throwable throwable)
    {
        onFailure(i, aheader, getResponseString(abyte0, getCharset()), throwable);
    }

    public abstract void onSuccess(int i, Header aheader[], String s);

    public void onSuccess(int i, Header aheader[], byte abyte0[])
    {
        onSuccess(i, aheader, getResponseString(abyte0, getCharset()));
    }
}
