// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.utils;

import com.inponsel.android.adapter.ListModel;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

// Referenced classes of package com.inponsel.android.utils:
//            EncodeDecodeAES

public class RestClient
{
    public static final class RequestMethod extends Enum
    {

        private static final RequestMethod ENUM$VALUES[];
        public static final RequestMethod GET;
        public static final RequestMethod POST;

        public static RequestMethod valueOf(String s)
        {
            return (RequestMethod)Enum.valueOf(com/inponsel/android/utils/RestClient$RequestMethod, s);
        }

        public static RequestMethod[] values()
        {
            RequestMethod arequestmethod[] = ENUM$VALUES;
            int i = arequestmethod.length;
            RequestMethod arequestmethod1[] = new RequestMethod[i];
            System.arraycopy(arequestmethod, 0, arequestmethod1, 0, i);
            return arequestmethod1;
        }

        static 
        {
            GET = new RequestMethod("GET", 0);
            POST = new RequestMethod("POST", 1);
            ENUM$VALUES = (new RequestMethod[] {
                GET, POST
            });
        }

        private RequestMethod(String s, int i)
        {
            super(s, i);
        }
    }


    private static int $SWITCH_TABLE$com$inponsel$android$utils$RestClient$RequestMethod[];
    public static String pelihara;
    private ArrayList headers;
    private String message;
    private ArrayList params;
    private String response;
    private int responseCode;
    private String url;

    static int[] $SWITCH_TABLE$com$inponsel$android$utils$RestClient$RequestMethod()
    {
        int ai[] = $SWITCH_TABLE$com$inponsel$android$utils$RestClient$RequestMethod;
        if (ai != null)
        {
            return ai;
        }
        ai = new int[RequestMethod.values().length];
        try
        {
            ai[RequestMethod.GET.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            ai[RequestMethod.POST.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror) { }
        $SWITCH_TABLE$com$inponsel$android$utils$RestClient$RequestMethod = ai;
        return ai;
    }

    public RestClient(String s)
    {
        url = s;
        params = new ArrayList();
        headers = new ArrayList();
    }

    private static String convertStreamToString(InputStream inputstream)
    {
        StringBuilder stringbuilder;
        BufferedReader bufferedreader;
        bufferedreader = new BufferedReader(new InputStreamReader(inputstream));
        stringbuilder = new StringBuilder();
_L2:
        String s = bufferedreader.readLine();
label0:
        {
            {
                if (s != null)
                {
                    break label0;
                }
                Exception exception;
                IOException ioexception;
                try
                {
                    inputstream.close();
                }
                // Misplaced declaration of an exception variable
                catch (InputStream inputstream)
                {
                    inputstream.printStackTrace();
                }
            }
            return stringbuilder.toString();
        }
        stringbuilder.append((new StringBuilder(String.valueOf(s))).append("\n").toString());
        continue; /* Loop/switch isn't completed */
        ioexception;
        ioexception.printStackTrace();
        try
        {
            inputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            inputstream.printStackTrace();
        }
        if (false)
        {
        } else
        {
            break MISSING_BLOCK_LABEL_37;
        }
        exception;
        try
        {
            inputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            inputstream.printStackTrace();
        }
        throw exception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private void executeRequest(HttpUriRequest httpurirequest, String s)
    {
        s = new DefaultHttpClient();
        try
        {
            httpurirequest = s.execute(httpurirequest);
            responseCode = httpurirequest.getStatusLine().getStatusCode();
            message = httpurirequest.getStatusLine().getReasonPhrase();
            httpurirequest = httpurirequest.getEntity();
        }
        // Misplaced declaration of an exception variable
        catch (HttpUriRequest httpurirequest)
        {
            s.getConnectionManager().shutdown();
            httpurirequest.printStackTrace();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (HttpUriRequest httpurirequest)
        {
            s.getConnectionManager().shutdown();
            httpurirequest.printStackTrace();
            return;
        }
        if (httpurirequest == null)
        {
            break MISSING_BLOCK_LABEL_76;
        }
        httpurirequest = httpurirequest.getContent();
        response = convertStreamToString(httpurirequest);
        httpurirequest.close();
    }

    public void AddHeader(String s, String s1)
    {
        headers.add(new BasicNameValuePair(s, s1));
    }

    public void AddParam(String s, String s1)
    {
        params.add(new BasicNameValuePair(s, s1));
    }

    public void Execute(RequestMethod requestmethod)
        throws Exception
    {
        $SWITCH_TABLE$com$inponsel$android$utils$RestClient$RequestMethod()[requestmethod.ordinal()];
        JVM INSTR tableswitch 1 2: default 32
    //                   1 33
    //                   2 275;
           goto _L1 _L2 _L3
_L1:
        return;
_L2:
        requestmethod = "";
        if (params.isEmpty()) goto _L5; else goto _L4
_L4:
        Iterator iterator;
        requestmethod = (new StringBuilder(String.valueOf(""))).append("?").toString();
        iterator = params.iterator();
_L8:
        if (iterator.hasNext()) goto _L6; else goto _L5
_L6:
        Object obj = (NameValuePair)iterator.next();
        obj = (new StringBuilder(String.valueOf(((NameValuePair) (obj)).getName()))).append("=").append(URLEncoder.encode(((NameValuePair) (obj)).getValue(), "UTF-8")).toString();
        if (requestmethod.length() > 1)
        {
            requestmethod = (new StringBuilder(String.valueOf(requestmethod))).append("&").append(((String) (obj))).toString();
        } else
        {
            requestmethod = (new StringBuilder(String.valueOf(requestmethod))).append(((String) (obj))).toString();
        }
        continue; /* Loop/switch isn't completed */
_L5:
        requestmethod = new HttpGet((new StringBuilder(String.valueOf(url))).append(requestmethod).toString());
        iterator = headers.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                executeRequest(requestmethod, url);
                return;
            }
            NameValuePair namevaluepair = (NameValuePair)iterator.next();
            requestmethod.addHeader(namevaluepair.getName(), namevaluepair.getValue());
        } while (true);
_L3:
        requestmethod = new HttpPost(url);
        Iterator iterator1 = headers.iterator();
        do
        {
            if (!iterator1.hasNext())
            {
                if (!params.isEmpty())
                {
                    requestmethod.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
                }
                executeRequest(requestmethod, url);
                return;
            }
            NameValuePair namevaluepair1 = (NameValuePair)iterator1.next();
            requestmethod.addHeader(namevaluepair1.getName(), namevaluepair1.getValue());
        } while (true);
        if (true) goto _L8; else goto _L7
_L7:
    }

    public String getErrorMessage()
    {
        return message;
    }

    public String getResponse()
    {
        return response;
    }

    public int getResponseCode()
    {
        return responseCode;
    }

    static 
    {
        pelihara = (new StringBuilder("ArRahman")).append(EncodeDecodeAES.asma2).append(ListModel.asma3).toString();
    }
}
