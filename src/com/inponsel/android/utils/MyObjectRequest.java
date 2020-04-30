// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.utils;

import android.util.Base64;
import com.android.volley.AuthFailureError;
import com.android.volley.toolbox.JsonObjectRequest;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;

public class MyObjectRequest extends JsonObjectRequest
{

    private Map headers;

    public MyObjectRequest(String s, com.android.volley.Response.Listener listener, com.android.volley.Response.ErrorListener errorlistener, String s1, String s2)
    {
        super(s, null, listener, errorlistener);
        headers = new HashMap();
        if (s1 != null && s2 != null)
        {
            s = new String(Base64.encode((new StringBuilder(String.valueOf(s1))).append(":").append(s2).toString().getBytes(), 2));
            headers.put("Authorization", (new StringBuilder("Basic ")).append(s).toString());
        }
    }

    public MyObjectRequest(String s, JSONArray jsonarray, com.android.volley.Response.Listener listener, com.android.volley.Response.ErrorListener errorlistener)
    {
        super(s, null, listener, errorlistener);
        headers = new HashMap();
    }

    public Map getHeaders()
        throws AuthFailureError
    {
        return headers;
    }

    public void setHeader(String s, String s1)
    {
        headers.put(s, s1);
    }
}
