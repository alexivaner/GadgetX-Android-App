// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inponsel.android.utils:
//            Log

public class JSONParser
{

    static InputStream is = null;
    static String json = "";
    static JSONObject jsonObject = null;

    public JSONParser()
    {
    }

    public JSONObject getJSONFromUrl(String s, List list)
    {
        String s1;
        try
        {
            DefaultHttpClient defaulthttpclient = new DefaultHttpClient();
            s = new HttpPost(s);
            s.setEntity(new UrlEncodedFormEntity(list));
            is = defaulthttpclient.execute(s).getEntity().getContent();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
        s = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);
        list = new StringBuilder();
_L1:
        s1 = s.readLine();
        if (s1 == null)
        {
            try
            {
                is.close();
                json = list.toString();
                Log.e("JSoN", json);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                Log.e("Buffer Error", (new StringBuilder("Error converting result ")).append(s.toString()).toString());
            }
            try
            {
                jsonObject = new JSONObject(json);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                Log.e("JSON Parser", (new StringBuilder("Error parsing data ")).append(s.toString()).toString());
            }
            return jsonObject;
        }
        list.append((new StringBuilder(String.valueOf(s1))).append("\n").toString());
          goto _L1
    }

}
