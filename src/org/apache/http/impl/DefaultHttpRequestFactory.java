// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.http.impl;

import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestFactory;
import org.apache.http.MethodNotSupportedException;
import org.apache.http.RequestLine;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;
import org.apache.http.message.BasicHttpRequest;
import org.apache.http.util.Args;

public class DefaultHttpRequestFactory
    implements HttpRequestFactory
{

    public static final DefaultHttpRequestFactory INSTANCE = new DefaultHttpRequestFactory();
    private static final String RFC2616_COMMON_METHODS[] = {
        "GET"
    };
    private static final String RFC2616_ENTITY_ENC_METHODS[] = {
        "POST", "PUT"
    };
    private static final String RFC2616_SPECIAL_METHODS[] = {
        "HEAD", "OPTIONS", "DELETE", "TRACE", "CONNECT"
    };

    public DefaultHttpRequestFactory()
    {
    }

    private static boolean isOneOf(String as[], String s)
    {
        int j = as.length;
        for (int i = 0; i < j; i++)
        {
            if (as[i].equalsIgnoreCase(s))
            {
                return true;
            }
        }

        return false;
    }

    public HttpRequest newHttpRequest(String s, String s1)
        throws MethodNotSupportedException
    {
        if (isOneOf(RFC2616_COMMON_METHODS, s))
        {
            return new BasicHttpRequest(s, s1);
        }
        if (isOneOf(RFC2616_ENTITY_ENC_METHODS, s))
        {
            return new BasicHttpEntityEnclosingRequest(s, s1);
        }
        if (isOneOf(RFC2616_SPECIAL_METHODS, s))
        {
            return new BasicHttpRequest(s, s1);
        } else
        {
            throw new MethodNotSupportedException((new StringBuilder()).append(s).append(" method not supported").toString());
        }
    }

    public HttpRequest newHttpRequest(RequestLine requestline)
        throws MethodNotSupportedException
    {
        Args.notNull(requestline, "Request line");
        String s = requestline.getMethod();
        if (isOneOf(RFC2616_COMMON_METHODS, s))
        {
            return new BasicHttpRequest(requestline);
        }
        if (isOneOf(RFC2616_ENTITY_ENC_METHODS, s))
        {
            return new BasicHttpEntityEnclosingRequest(requestline);
        }
        if (isOneOf(RFC2616_SPECIAL_METHODS, s))
        {
            return new BasicHttpRequest(requestline);
        } else
        {
            throw new MethodNotSupportedException((new StringBuilder()).append(s).append(" method not supported").toString());
        }
    }

}
