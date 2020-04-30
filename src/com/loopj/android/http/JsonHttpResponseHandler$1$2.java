// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.loopj.android.http:
//            JsonHttpResponseHandler

class val.ex
    implements Runnable
{

    final val.ex this$1;
    final JSONException val$ex;

    public void run()
    {
        onFailure(statusCode, headers, val$ex, (JSONObject)null);
    }

    l.headers()
    {
        this$1 = final_headers;
        val$ex = JSONException.this;
        super();
    }

    // Unreferenced inner class com/loopj/android/http/JsonHttpResponseHandler$1

/* anonymous class */
    class JsonHttpResponseHandler._cls1
        implements Runnable
    {

        final JsonHttpResponseHandler this$0;
        final Header val$headers[];
        final byte val$responseBytes[];
        final int val$statusCode;

        public void run()
        {
            try
            {
                final Object jsonResponse = parseResponse(responseBytes);
                postRunnable(new JsonHttpResponseHandler._cls1._cls1());
                return;
            }
            catch (JSONException jsonexception)
            {
                postRunnable(jsonexception. new JsonHttpResponseHandler._cls1._cls2());
            }
        }

            
            {
                this$0 = final_jsonhttpresponsehandler;
                responseBytes = abyte0;
                statusCode = i;
                headers = _5B_Lorg.apache.http.Header_3B_.this;
                super();
            }

        // Unreferenced inner class com/loopj/android/http/JsonHttpResponseHandler$1$1

/* anonymous class */
        class JsonHttpResponseHandler._cls1._cls1
            implements Runnable
        {

            final JsonHttpResponseHandler._cls1 this$1;
            final Object val$jsonResponse;

            public void run()
            {
                if (jsonResponse instanceof JSONObject)
                {
                    onSuccess(statusCode, headers, (JSONObject)jsonResponse);
                    return;
                }
                if (jsonResponse instanceof JSONArray)
                {
                    onSuccess(statusCode, headers, (JSONArray)jsonResponse);
                    return;
                }
                if (jsonResponse instanceof String)
                {
                    onFailure(statusCode, headers, (String)jsonResponse, new JSONException("Response cannot be parsed as JSON data"));
                    return;
                } else
                {
                    onFailure(statusCode, headers, new JSONException((new StringBuilder()).append("Unexpected response type ").append(jsonResponse.getClass().getName()).toString()), (JSONObject)null);
                    return;
                }
            }

                    
                    {
                        this$1 = JsonHttpResponseHandler._cls1.this;
                        jsonResponse = obj;
                        super();
                    }
        }

    }

}
