// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpPush
{

    public HttpPush()
    {
    }

    public static String getResponse(String s)
        throws Exception
    {
        StringBuilder stringbuilder = null;
        s = (HttpURLConnection)(new URL(s.toString())).openConnection();
        s.setDoInput(true);
        s.setDoOutput(true);
        s = s.getInputStream();
_L4:
        stringbuilder = new StringBuilder();
        if (s == null) goto _L2; else goto _L1
_L1:
        s = new BufferedReader(new InputStreamReader(s, "UTF-8"));
_L5:
        String s1 = s.readLine();
        if (s1 != null) goto _L3; else goto _L2
_L2:
        return stringbuilder.toString();
        s;
        s.printStackTrace();
        s = stringbuilder;
          goto _L4
        s;
        s.printStackTrace();
        s = stringbuilder;
          goto _L4
_L3:
        stringbuilder.append(s1).append('\n');
          goto _L5
        s;
          goto _L2
    }
}
