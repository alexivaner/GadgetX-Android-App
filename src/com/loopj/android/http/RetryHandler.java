// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;

import android.os.SystemClock;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.Iterator;
import javax.net.ssl.SSLException;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.protocol.HttpContext;

class RetryHandler
    implements HttpRequestRetryHandler
{

    private static final HashSet exceptionBlacklist;
    private static final HashSet exceptionWhitelist;
    private final int maxRetries;
    private final int retrySleepTimeMS;

    public RetryHandler(int i, int j)
    {
        maxRetries = i;
        retrySleepTimeMS = j;
    }

    static void addClassToBlacklist(Class class1)
    {
        exceptionBlacklist.add(class1);
    }

    static void addClassToWhitelist(Class class1)
    {
        exceptionWhitelist.add(class1);
    }

    protected boolean isInList(HashSet hashset, Throwable throwable)
    {
        for (hashset = hashset.iterator(); hashset.hasNext();)
        {
            if (((Class)hashset.next()).isInstance(throwable))
            {
                return true;
            }
        }

        return false;
    }

    public boolean retryRequest(IOException ioexception, int i, HttpContext httpcontext)
    {
        boolean flag;
        boolean flag1;
        flag1 = true;
        Boolean boolean1 = (Boolean)httpcontext.getAttribute("http.request_sent");
        if (boolean1 != null && boolean1.booleanValue())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (i <= maxRetries) goto _L2; else goto _L1
_L1:
        flag1 = false;
_L4:
        if (flag1 && (HttpUriRequest)httpcontext.getAttribute("http.request") == null)
        {
            return false;
        }
        break; /* Loop/switch isn't completed */
_L2:
        if (isInList(exceptionWhitelist, ioexception))
        {
            flag1 = true;
        } else
        if (isInList(exceptionBlacklist, ioexception))
        {
            flag1 = false;
        } else
        if (!flag)
        {
            flag1 = true;
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (flag1)
        {
            SystemClock.sleep(retrySleepTimeMS);
        } else
        {
            ioexception.printStackTrace();
        }
        return flag1;
    }

    static 
    {
        exceptionWhitelist = new HashSet();
        exceptionBlacklist = new HashSet();
        exceptionWhitelist.add(org/apache/http/NoHttpResponseException);
        exceptionWhitelist.add(java/net/UnknownHostException);
        exceptionWhitelist.add(java/net/SocketException);
        exceptionBlacklist.add(java/io/InterruptedIOException);
        exceptionBlacklist.add(javax/net/ssl/SSLException);
    }
}
