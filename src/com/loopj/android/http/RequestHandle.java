// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;

import java.lang.ref.WeakReference;

// Referenced classes of package com.loopj.android.http:
//            AsyncHttpRequest

public class RequestHandle
{

    private final WeakReference request;

    public RequestHandle(AsyncHttpRequest asynchttprequest)
    {
        request = new WeakReference(asynchttprequest);
    }

    public boolean cancel(boolean flag)
    {
        AsyncHttpRequest asynchttprequest = (AsyncHttpRequest)request.get();
        return asynchttprequest == null || asynchttprequest.cancel(flag);
    }

    public boolean isCancelled()
    {
        AsyncHttpRequest asynchttprequest = (AsyncHttpRequest)request.get();
        return asynchttprequest == null || asynchttprequest.isCancelled();
    }

    public boolean isFinished()
    {
        AsyncHttpRequest asynchttprequest = (AsyncHttpRequest)request.get();
        return asynchttprequest == null || asynchttprequest.isDone();
    }

    public boolean shouldBeGarbageCollected()
    {
        boolean flag;
        if (isCancelled() || isFinished())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            request.clear();
        }
        return flag;
    }
}
