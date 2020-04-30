// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;

import java.io.IOException;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.AuthState;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.protocol.HttpContext;

public class PreemtiveAuthorizationHttpRequestInterceptor
    implements HttpRequestInterceptor
{

    public PreemtiveAuthorizationHttpRequestInterceptor()
    {
    }

    public void process(HttpRequest httprequest, HttpContext httpcontext)
        throws HttpException, IOException
    {
        httprequest = (AuthState)httpcontext.getAttribute("http.auth.target-scope");
        CredentialsProvider credentialsprovider = (CredentialsProvider)httpcontext.getAttribute("http.auth.credentials-provider");
        httpcontext = (HttpHost)httpcontext.getAttribute("http.target_host");
        if (httprequest.getAuthScheme() == null)
        {
            httpcontext = credentialsprovider.getCredentials(new AuthScope(httpcontext.getHostName(), httpcontext.getPort()));
            if (httpcontext != null)
            {
                httprequest.setAuthScheme(new BasicScheme());
                httprequest.setCredentials(httpcontext);
            }
        }
    }
}
