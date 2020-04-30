// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.json;

import com.inponsel.android.utils.FileUtils;
import com.inponsel.android.utils.Log;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONParser
{

    static String json = "";
    private HttpURLConnection httpConnection;
    InputStream inputStream;
    BufferedReader reader;

    public JSONParser()
    {
        inputStream = null;
        reader = null;
    }

    private void openHttpClient(String s)
        throws IOException
    {
        DefaultHttpClient defaulthttpclient = new DefaultHttpClient();
        HttpConnectionParams.setConnectionTimeout(defaulthttpclient.getParams(), 30000);
        inputStream = defaulthttpclient.execute(new HttpGet(s)).getEntity().getContent();
        reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"), 8);
    }

    private void openHttpUrlConnection(String s)
        throws IOException
    {
        Log.d("urlstring in parser", (new StringBuilder(String.valueOf(s))).toString());
        httpConnection = (HttpURLConnection)(new URL(s)).openConnection();
        httpConnection.setConnectTimeout(30000);
        httpConnection.setRequestMethod("GET");
        httpConnection.connect();
    }

    public JSONObject getJSONHttpClient(String s)
        throws ClientProtocolException, IOException, JSONException
    {
        openHttpClient(s);
        s = new StringBuilder();
_L1:
        String s1 = reader.readLine();
        if (s1 != null)
        {
            break MISSING_BLOCK_LABEL_67;
        }
        json = s.toString();
        Log.d("json", json);
        s = new JSONObject(json);
        FileUtils.close(inputStream);
        FileUtils.close(reader);
        return s;
        s.append((new StringBuilder(String.valueOf(s1))).append("\n").toString());
          goto _L1
        s;
        FileUtils.close(inputStream);
        FileUtils.close(reader);
        throw s;
    }

    public JSONObject getJSONHttpURLConnection(String s)
        throws IOException, JSONException
    {
        Object obj;
        BufferedReader bufferedreader;
        String s1;
        Object obj1;
        Object obj2;
        Object obj3;
        StringBuffer stringbuffer;
        obj1 = null;
        bufferedreader = null;
        stringbuffer = new StringBuffer("");
        obj2 = null;
        s1 = null;
        obj3 = null;
        obj = obj2;
        openHttpUrlConnection(s);
        s = obj3;
        obj = obj2;
        if (httpConnection.getResponseCode() != 200) goto _L2; else goto _L1
_L1:
        obj = obj2;
        s = httpConnection.getInputStream();
        obj = s;
        bufferedreader = new BufferedReader(new InputStreamReader(s, "UTF-8"), 8);
_L3:
        obj = bufferedreader.readLine();
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_129;
        }
        json = stringbuffer.toString();
        obj = new JSONObject(json);
        s1 = s;
        s = ((String) (obj));
_L2:
        FileUtils.close(s1);
        FileUtils.close(bufferedreader);
        return s;
        stringbuffer.append((new StringBuilder(String.valueOf(obj))).append("\n").toString());
          goto _L3
        obj;
_L5:
        FileUtils.close(s);
        FileUtils.close(bufferedreader);
        throw obj;
        Exception exception;
        exception;
        bufferedreader = obj1;
        s = ((String) (obj));
        obj = exception;
        if (true) goto _L5; else goto _L4
_L4:
    }

}
