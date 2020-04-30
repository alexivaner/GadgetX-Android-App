// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

// Referenced classes of package com.loopj.android.http:
//            AsyncHttpResponseHandler

private static class mResponder extends Handler
{

    private final AsyncHttpResponseHandler mResponder;

    public void handleMessage(Message message)
    {
        mResponder.handleMessage(message);
    }

    (AsyncHttpResponseHandler asynchttpresponsehandler, Looper looper)
    {
        super(looper);
        mResponder = asynchttpresponsehandler;
    }
}
