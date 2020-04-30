// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.http.protocol;

import java.io.IOException;
import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseFactory;
import org.apache.http.HttpServerConnection;
import org.apache.http.HttpVersion;
import org.apache.http.MethodNotSupportedException;
import org.apache.http.ProtocolException;
import org.apache.http.RequestLine;
import org.apache.http.StatusLine;
import org.apache.http.UnsupportedHttpVersionException;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.DefaultConnectionReuseStrategy;
import org.apache.http.impl.DefaultHttpResponseFactory;
import org.apache.http.params.HttpParams;
import org.apache.http.util.Args;
import org.apache.http.util.EncodingUtils;
import org.apache.http.util.EntityUtils;

// Referenced classes of package org.apache.http.protocol:
//            HttpProcessor, HttpRequestHandlerMapper, HttpRequestHandler, HttpContext, 
//            HttpExpectationVerifier, HttpRequestHandlerResolver

public class HttpService
{
    private static class HttpRequestHandlerResolverAdapter
        implements HttpRequestHandlerMapper
    {

        private final HttpRequestHandlerResolver resolver;

        public HttpRequestHandler lookup(HttpRequest httprequest)
        {
            return resolver.lookup(httprequest.getRequestLine().getUri());
        }

        public HttpRequestHandlerResolverAdapter(HttpRequestHandlerResolver httprequesthandlerresolver)
        {
            resolver = httprequesthandlerresolver;
        }
    }


    private volatile ConnectionReuseStrategy connStrategy;
    private volatile HttpExpectationVerifier expectationVerifier;
    private volatile HttpRequestHandlerMapper handlerMapper;
    private volatile HttpParams params;
    private volatile HttpProcessor processor;
    private volatile HttpResponseFactory responseFactory;

    public HttpService(HttpProcessor httpprocessor, ConnectionReuseStrategy connectionreusestrategy, HttpResponseFactory httpresponsefactory)
    {
        params = null;
        processor = null;
        handlerMapper = null;
        connStrategy = null;
        responseFactory = null;
        expectationVerifier = null;
        setHttpProcessor(httpprocessor);
        setConnReuseStrategy(connectionreusestrategy);
        setResponseFactory(httpresponsefactory);
    }

    public HttpService(HttpProcessor httpprocessor, ConnectionReuseStrategy connectionreusestrategy, HttpResponseFactory httpresponsefactory, HttpRequestHandlerMapper httprequesthandlermapper)
    {
        this(httpprocessor, connectionreusestrategy, httpresponsefactory, httprequesthandlermapper, ((HttpExpectationVerifier) (null)));
    }

    public HttpService(HttpProcessor httpprocessor, ConnectionReuseStrategy connectionreusestrategy, HttpResponseFactory httpresponsefactory, HttpRequestHandlerMapper httprequesthandlermapper, HttpExpectationVerifier httpexpectationverifier)
    {
        params = null;
        processor = null;
        handlerMapper = null;
        connStrategy = null;
        responseFactory = null;
        expectationVerifier = null;
        processor = (HttpProcessor)Args.notNull(httpprocessor, "HTTP processor");
        if (connectionreusestrategy == null)
        {
            connectionreusestrategy = DefaultConnectionReuseStrategy.INSTANCE;
        }
        connStrategy = connectionreusestrategy;
        if (httpresponsefactory == null)
        {
            httpresponsefactory = DefaultHttpResponseFactory.INSTANCE;
        }
        responseFactory = httpresponsefactory;
        handlerMapper = httprequesthandlermapper;
        expectationVerifier = httpexpectationverifier;
    }

    public HttpService(HttpProcessor httpprocessor, ConnectionReuseStrategy connectionreusestrategy, HttpResponseFactory httpresponsefactory, HttpRequestHandlerResolver httprequesthandlerresolver, HttpParams httpparams)
    {
        this(httpprocessor, connectionreusestrategy, httpresponsefactory, ((HttpRequestHandlerMapper) (new HttpRequestHandlerResolverAdapter(httprequesthandlerresolver))), ((HttpExpectationVerifier) (null)));
        params = httpparams;
    }

    public HttpService(HttpProcessor httpprocessor, ConnectionReuseStrategy connectionreusestrategy, HttpResponseFactory httpresponsefactory, HttpRequestHandlerResolver httprequesthandlerresolver, HttpExpectationVerifier httpexpectationverifier, HttpParams httpparams)
    {
        this(httpprocessor, connectionreusestrategy, httpresponsefactory, ((HttpRequestHandlerMapper) (new HttpRequestHandlerResolverAdapter(httprequesthandlerresolver))), httpexpectationverifier);
        params = httpparams;
    }

    public HttpService(HttpProcessor httpprocessor, HttpRequestHandlerMapper httprequesthandlermapper)
    {
        this(httpprocessor, null, null, httprequesthandlermapper, ((HttpExpectationVerifier) (null)));
    }

    protected void doService(HttpRequest httprequest, HttpResponse httpresponse, HttpContext httpcontext)
        throws HttpException, IOException
    {
        HttpRequestHandler httprequesthandler = null;
        if (handlerMapper != null)
        {
            httprequesthandler = handlerMapper.lookup(httprequest);
        }
        if (httprequesthandler != null)
        {
            httprequesthandler.handle(httprequest, httpresponse, httpcontext);
            return;
        } else
        {
            httpresponse.setStatusCode(501);
            return;
        }
    }

    public HttpParams getParams()
    {
        return params;
    }

    protected void handleException(HttpException httpexception, HttpResponse httpresponse)
    {
        String s;
        String s1;
        if (httpexception instanceof MethodNotSupportedException)
        {
            httpresponse.setStatusCode(501);
        } else
        if (httpexception instanceof UnsupportedHttpVersionException)
        {
            httpresponse.setStatusCode(505);
        } else
        if (httpexception instanceof ProtocolException)
        {
            httpresponse.setStatusCode(400);
        } else
        {
            httpresponse.setStatusCode(500);
        }
        s1 = httpexception.getMessage();
        s = s1;
        if (s1 == null)
        {
            s = httpexception.toString();
        }
        httpexception = new ByteArrayEntity(EncodingUtils.getAsciiBytes(s));
        httpexception.setContentType("text/plain; charset=US-ASCII");
        httpresponse.setEntity(httpexception);
    }

    public void handleRequest(HttpServerConnection httpserverconnection, HttpContext httpcontext)
        throws IOException, HttpException
    {
        Object obj1;
        httpcontext.setAttribute("http.connection", httpserverconnection);
        obj1 = null;
        HttpRequest httprequest = httpserverconnection.receiveRequestHeader();
        Object obj = obj1;
        if (!(httprequest instanceof HttpEntityEnclosingRequest)) goto _L2; else goto _L1
_L1:
        if (!((HttpEntityEnclosingRequest)httprequest).expectContinue()) goto _L4; else goto _L3
_L3:
        HttpExpectationVerifier httpexpectationverifier;
        obj = responseFactory.newHttpResponse(HttpVersion.HTTP_1_1, 100, httpcontext);
        httpexpectationverifier = expectationVerifier;
        obj1 = obj;
        if (httpexpectationverifier == null)
        {
            break MISSING_BLOCK_LABEL_90;
        }
        expectationVerifier.verify(httprequest, ((HttpResponse) (obj)), httpcontext);
        obj1 = obj;
_L6:
        obj = obj1;
        if (((HttpResponse) (obj1)).getStatusLine().getStatusCode() >= 200) goto _L2; else goto _L5
_L5:
        httpserverconnection.sendResponseHeader(((HttpResponse) (obj1)));
        httpserverconnection.flush();
        obj = null;
        httpserverconnection.receiveRequestEntity((HttpEntityEnclosingRequest)httprequest);
_L2:
        httpcontext.setAttribute("http.request", httprequest);
        obj1 = obj;
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_194;
        }
        obj1 = responseFactory.newHttpResponse(HttpVersion.HTTP_1_1, 200, httpcontext);
        processor.process(httprequest, httpcontext);
        doService(httprequest, ((HttpResponse) (obj1)), httpcontext);
        obj = obj1;
        if (!(httprequest instanceof HttpEntityEnclosingRequest))
        {
            break MISSING_BLOCK_LABEL_221;
        }
        EntityUtils.consume(((HttpEntityEnclosingRequest)httprequest).getEntity());
        obj = obj1;
_L7:
        httpcontext.setAttribute("http.response", obj);
        processor.process(((HttpResponse) (obj)), httpcontext);
        httpserverconnection.sendResponseHeader(((HttpResponse) (obj)));
        httpserverconnection.sendResponseEntity(((HttpResponse) (obj)));
        httpserverconnection.flush();
        if (!connStrategy.keepAlive(((HttpResponse) (obj)), httpcontext))
        {
            httpserverconnection.close();
        }
        return;
        obj;
        obj1 = responseFactory.newHttpResponse(HttpVersion.HTTP_1_0, 500, httpcontext);
        handleException(((HttpException) (obj)), ((HttpResponse) (obj1)));
          goto _L6
        obj1;
        obj = responseFactory.newHttpResponse(HttpVersion.HTTP_1_0, 500, httpcontext);
        handleException(((HttpException) (obj1)), ((HttpResponse) (obj)));
          goto _L7
_L4:
        httpserverconnection.receiveRequestEntity((HttpEntityEnclosingRequest)httprequest);
        obj = obj1;
          goto _L2
    }

    public void setConnReuseStrategy(ConnectionReuseStrategy connectionreusestrategy)
    {
        Args.notNull(connectionreusestrategy, "Connection reuse strategy");
        connStrategy = connectionreusestrategy;
    }

    public void setExpectationVerifier(HttpExpectationVerifier httpexpectationverifier)
    {
        expectationVerifier = httpexpectationverifier;
    }

    public void setHandlerResolver(HttpRequestHandlerResolver httprequesthandlerresolver)
    {
        handlerMapper = new HttpRequestHandlerResolverAdapter(httprequesthandlerresolver);
    }

    public void setHttpProcessor(HttpProcessor httpprocessor)
    {
        Args.notNull(httpprocessor, "HTTP processor");
        processor = httpprocessor;
    }

    public void setParams(HttpParams httpparams)
    {
        params = httpparams;
    }

    public void setResponseFactory(HttpResponseFactory httpresponsefactory)
    {
        Args.notNull(httpresponsefactory, "Response factory");
        responseFactory = httpresponsefactory;
    }
}
