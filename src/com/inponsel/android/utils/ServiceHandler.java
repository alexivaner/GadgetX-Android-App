// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class ServiceHandler
{

    public static final int GET = 1;
    public static final int POST = 2;
    static String response = null;

    public ServiceHandler()
    {
    }

    public String makeServiceCall(String s, int i)
    {
        return makeServiceCall(s, i, null);
    }

    public String makeServiceCall(String s, int i, List list)
    {
        DefaultHttpClient defaulthttpclient = new DefaultHttpClient();
        Object obj = null;
        if (i != 2) goto _L2; else goto _L1
_L1:
        s = new HttpPost(s);
        if (list == null)
        {
            break MISSING_BLOCK_LABEL_42;
        }
        s.setEntity(new UrlEncodedFormEntity(list));
        obj = defaulthttpclient.execute(s);
_L4:
        response = EntityUtils.toString(((HttpResponse) (obj)).getEntity());
_L5:
        return response;
_L2:
        if (i != 1) goto _L4; else goto _L3
_L3:
        obj = s;
        if (list == null)
        {
            break MISSING_BLOCK_LABEL_111;
        }
        list = URLEncodedUtils.format(list, "utf-8");
        obj = (new StringBuilder(String.valueOf(s))).append("?").append(list).toString();
        obj = defaulthttpclient.execute(new HttpGet(((String) (obj))));
          goto _L4
        s;
        s.printStackTrace();
          goto _L5
        s;
        s.printStackTrace();
          goto _L5
        s;
        s.printStackTrace();
          goto _L5
    }

}
