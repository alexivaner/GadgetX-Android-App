// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.http.protocol;

import java.io.IOException;
import java.net.InetAddress;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpInetConnection;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpVersion;
import org.apache.http.ProtocolException;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;
import org.apache.http.util.Args;

// Referenced classes of package org.apache.http.protocol:
//            HttpCoreContext, HttpContext

public class RequestTargetHost
    implements HttpRequestInterceptor
{

    public RequestTargetHost()
    {
    }

    public void process(HttpRequest httprequest, HttpContext httpcontext)
        throws HttpException, IOException
    {
        ProtocolVersion protocolversion;
        Args.notNull(httprequest, "HTTP request");
        httpcontext = HttpCoreContext.adapt(httpcontext);
        protocolversion = httprequest.getRequestLine().getProtocolVersion();
        break MISSING_BLOCK_LABEL_25;
        Object obj;
        while (true) 
        {
            do
            {
                return;
            } while (httprequest.getRequestLine().getMethod().equalsIgnoreCase("CONNECT") && protocolversion.lessEquals(HttpVersion.HTTP_1_0) || httprequest.containsHeader("Host"));
            HttpHost httphost = httpcontext.getTargetHost();
            obj = httphost;
            if (httphost != null)
            {
                break;
            }
            obj = httpcontext.getConnection();
            httpcontext = httphost;
            if (obj instanceof HttpInetConnection)
            {
                InetAddress inetaddress = ((HttpInetConnection)obj).getRemoteAddress();
                int i = ((HttpInetConnection)obj).getRemotePort();
                httpcontext = httphost;
                if (inetaddress != null)
                {
                    httpcontext = new HttpHost(inetaddress.getHostName(), i);
                }
            }
            obj = httpcontext;
            if (httpcontext != null)
            {
                break;
            }
            if (!protocolversion.lessEquals(HttpVersion.HTTP_1_0))
            {
                throw new ProtocolException("Target host missing");
            }
        }
        httprequest.addHeader("Host", ((HttpHost) (obj)).toHostString());
        return;
    }
}
