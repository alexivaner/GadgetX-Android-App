// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.http.protocol;

import java.io.IOException;
import org.apache.http.HttpClientConnection;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.ProtocolException;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;
import org.apache.http.StatusLine;
import org.apache.http.util.Args;

// Referenced classes of package org.apache.http.protocol:
//            HttpContext, HttpProcessor

public class HttpRequestExecutor
{

    public static final int DEFAULT_WAIT_FOR_CONTINUE = 3000;
    private final int waitForContinue;

    public HttpRequestExecutor()
    {
        this(3000);
    }

    public HttpRequestExecutor(int i)
    {
        waitForContinue = Args.positive(i, "Wait for continue time");
    }

    private static void closeConnection(HttpClientConnection httpclientconnection)
    {
        try
        {
            httpclientconnection.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (HttpClientConnection httpclientconnection)
        {
            return;
        }
    }

    protected boolean canResponseHaveBody(HttpRequest httprequest, HttpResponse httpresponse)
    {
        int i;
        if (!"HEAD".equalsIgnoreCase(httprequest.getRequestLine().getMethod()))
        {
            if ((i = httpresponse.getStatusLine().getStatusCode()) >= 200 && i != 204 && i != 304 && i != 205)
            {
                return true;
            }
        }
        return false;
    }

    protected HttpResponse doReceiveResponse(HttpRequest httprequest, HttpClientConnection httpclientconnection, HttpContext httpcontext)
        throws HttpException, IOException
    {
        Args.notNull(httprequest, "HTTP request");
        Args.notNull(httpclientconnection, "Client connection");
        Args.notNull(httpcontext, "HTTP context");
        httpcontext = null;
        for (int i = 0; httpcontext == null || i < 200; i = httpcontext.getStatusLine().getStatusCode())
        {
            httpcontext = httpclientconnection.receiveResponseHeader();
            if (canResponseHaveBody(httprequest, httpcontext))
            {
                httpclientconnection.receiveResponseEntity(httpcontext);
            }
        }

        return httpcontext;
    }

    protected HttpResponse doSendRequest(HttpRequest httprequest, HttpClientConnection httpclientconnection, HttpContext httpcontext)
        throws IOException, HttpException
    {
        Args.notNull(httprequest, "HTTP request");
        Args.notNull(httpclientconnection, "Client connection");
        Args.notNull(httpcontext, "HTTP context");
        Object obj = null;
        Object obj1 = null;
        httpcontext.setAttribute("http.connection", httpclientconnection);
        httpcontext.setAttribute("http.request_sent", Boolean.FALSE);
        httpclientconnection.sendRequestHeader(httprequest);
        if (httprequest instanceof HttpEntityEnclosingRequest)
        {
            boolean flag = true;
            obj = httprequest.getRequestLine().getProtocolVersion();
            HttpResponse httpresponse = obj1;
            int i = ((flag) ? 1 : 0);
            if (((HttpEntityEnclosingRequest)httprequest).expectContinue())
            {
                httpresponse = obj1;
                i = ((flag) ? 1 : 0);
                if (!((ProtocolVersion) (obj)).lessEquals(HttpVersion.HTTP_1_0))
                {
                    httpclientconnection.flush();
                    httpresponse = obj1;
                    i = ((flag) ? 1 : 0);
                    if (httpclientconnection.isResponseAvailable(waitForContinue))
                    {
                        httpresponse = httpclientconnection.receiveResponseHeader();
                        if (canResponseHaveBody(httprequest, httpresponse))
                        {
                            httpclientconnection.receiveResponseEntity(httpresponse);
                        }
                        i = httpresponse.getStatusLine().getStatusCode();
                        if (i < 200)
                        {
                            if (i != 100)
                            {
                                throw new ProtocolException((new StringBuilder()).append("Unexpected response: ").append(httpresponse.getStatusLine()).toString());
                            }
                            httpresponse = null;
                            i = ((flag) ? 1 : 0);
                        } else
                        {
                            i = 0;
                        }
                    }
                }
            }
            obj = httpresponse;
            if (i != 0)
            {
                httpclientconnection.sendRequestEntity((HttpEntityEnclosingRequest)httprequest);
                obj = httpresponse;
            }
        }
        httpclientconnection.flush();
        httpcontext.setAttribute("http.request_sent", Boolean.TRUE);
        return ((HttpResponse) (obj));
    }

    public HttpResponse execute(HttpRequest httprequest, HttpClientConnection httpclientconnection, HttpContext httpcontext)
        throws IOException, HttpException
    {
        Args.notNull(httprequest, "HTTP request");
        Args.notNull(httpclientconnection, "Client connection");
        Args.notNull(httpcontext, "HTTP context");
        HttpResponse httpresponse;
        HttpResponse httpresponse1;
        try
        {
            httpresponse1 = doSendRequest(httprequest, httpclientconnection, httpcontext);
        }
        // Misplaced declaration of an exception variable
        catch (HttpRequest httprequest)
        {
            closeConnection(httpclientconnection);
            throw httprequest;
        }
        // Misplaced declaration of an exception variable
        catch (HttpRequest httprequest)
        {
            closeConnection(httpclientconnection);
            throw httprequest;
        }
        // Misplaced declaration of an exception variable
        catch (HttpRequest httprequest)
        {
            closeConnection(httpclientconnection);
            throw httprequest;
        }
        httpresponse = httpresponse1;
        if (httpresponse1 != null)
        {
            break MISSING_BLOCK_LABEL_48;
        }
        httpresponse = doReceiveResponse(httprequest, httpclientconnection, httpcontext);
        return httpresponse;
    }

    public void postProcess(HttpResponse httpresponse, HttpProcessor httpprocessor, HttpContext httpcontext)
        throws HttpException, IOException
    {
        Args.notNull(httpresponse, "HTTP response");
        Args.notNull(httpprocessor, "HTTP processor");
        Args.notNull(httpcontext, "HTTP context");
        httpcontext.setAttribute("http.response", httpresponse);
        httpprocessor.process(httpresponse, httpcontext);
    }

    public void preProcess(HttpRequest httprequest, HttpProcessor httpprocessor, HttpContext httpcontext)
        throws HttpException, IOException
    {
        Args.notNull(httprequest, "HTTP request");
        Args.notNull(httpprocessor, "HTTP processor");
        Args.notNull(httpcontext, "HTTP context");
        httpcontext.setAttribute("http.request", httprequest);
        httpprocessor.process(httprequest, httpcontext);
    }
}
