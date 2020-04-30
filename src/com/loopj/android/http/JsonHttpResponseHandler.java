// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;

import android.util.Log;
import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

// Referenced classes of package com.loopj.android.http:
//            TextHttpResponseHandler

public class JsonHttpResponseHandler extends TextHttpResponseHandler
{

    private static final String LOG_TAG = "JsonHttpResponseHandler";

    public JsonHttpResponseHandler()
    {
        super("UTF-8");
    }

    public JsonHttpResponseHandler(String s)
    {
        super(s);
    }

    public void onFailure(int i, Header aheader[], String s, Throwable throwable)
    {
        Log.w("JsonHttpResponseHandler", "onFailure(int, Header[], String, Throwable) was not overriden, but callback was received", throwable);
    }

    public void onFailure(int i, Header aheader[], Throwable throwable, JSONArray jsonarray)
    {
        Log.w("JsonHttpResponseHandler", "onFailure(int, Header[], Throwable, JSONArray) was not overriden, but callback was received", throwable);
    }

    public void onFailure(int i, Header aheader[], Throwable throwable, JSONObject jsonobject)
    {
        Log.w("JsonHttpResponseHandler", "onFailure(int, Header[], Throwable, JSONObject) was not overriden, but callback was received", throwable);
    }

    public final void onFailure(final int statusCode, final Header headers[], final byte responseBytes[], final Throwable throwable)
    {
        if (responseBytes != null)
        {
            headers = new Runnable() {

                final JsonHttpResponseHandler this$0;
                final Header val$headers[];
                final byte val$responseBytes[];
                final int val$statusCode;
                final Throwable val$throwable;

                public void run()
                {
                    try
                    {
                        Object obj = parseResponse(responseBytes);
                        postRunnable(((_cls1) (obj)). new Runnable() {

                            final _cls2 this$1;
                            final Object val$jsonResponse;

                            public void run()
                            {
                                if (jsonResponse instanceof JSONObject)
                                {
                                    onFailure(statusCode, headers, throwable, (JSONObject)jsonResponse);
                                    return;
                                }
                                if (jsonResponse instanceof JSONArray)
                                {
                                    onFailure(statusCode, headers, throwable, (JSONArray)jsonResponse);
                                    return;
                                }
                                if (jsonResponse instanceof String)
                                {
                                    onFailure(statusCode, headers, (String)jsonResponse, throwable);
                                    return;
                                } else
                                {
                                    onFailure(statusCode, headers, new JSONException((new StringBuilder()).append("Unexpected response type ").append(jsonResponse.getClass().getName()).toString()), (JSONObject)null);
                                    return;
                                }
                            }

            
            {
                this$1 = final__pcls2;
                jsonResponse = Object.this;
                super();
            }
                        });
                        return;
                    }
                    catch (JSONException jsonexception)
                    {
                        postRunnable(jsonexception. new Runnable() {

                            final _cls2 this$1;
                            final JSONException val$ex;

                            public void run()
                            {
                                onFailure(statusCode, headers, ex, (JSONObject)null);
                            }

            
            {
                this$1 = final__pcls2;
                ex = JSONException.this;
                super();
            }
                        });
                    }
                }

            
            {
                this$0 = JsonHttpResponseHandler.this;
                responseBytes = abyte0;
                statusCode = i;
                headers = aheader;
                throwable = throwable1;
                super();
            }
            };
            if (!getUseSynchronousMode())
            {
                (new Thread(headers)).start();
                return;
            } else
            {
                headers.run();
                return;
            }
        } else
        {
            Log.v("JsonHttpResponseHandler", "response body is null, calling onFailure(Throwable, JSONObject)");
            onFailure(statusCode, headers, throwable, (JSONObject)null);
            return;
        }
    }

    public void onSuccess(int i, Header aheader[], String s)
    {
        Log.w("JsonHttpResponseHandler", "onSuccess(int, Header[], String) was not overriden, but callback was received");
    }

    public void onSuccess(int i, Header aheader[], JSONArray jsonarray)
    {
        Log.w("JsonHttpResponseHandler", "onSuccess(int, Header[], JSONArray) was not overriden, but callback was received");
    }

    public void onSuccess(int i, Header aheader[], JSONObject jsonobject)
    {
        Log.w("JsonHttpResponseHandler", "onSuccess(int, Header[], JSONObject) was not overriden, but callback was received");
    }

    public final void onSuccess(final int statusCode, final Header headers[], final byte responseBytes[])
    {
        if (statusCode != 204)
        {
            headers = new Runnable() {

                final JsonHttpResponseHandler this$0;
                final Header val$headers[];
                final byte val$responseBytes[];
                final int val$statusCode;

                public void run()
                {
                    try
                    {
                        Object obj = parseResponse(responseBytes);
                        postRunnable(((_cls1) (obj)). new Runnable() {

                            final _cls1 this$1;
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
                this$1 = final__pcls1;
                jsonResponse = Object.this;
                super();
            }
                        });
                        return;
                    }
                    catch (JSONException jsonexception)
                    {
                        postRunnable(jsonexception. new Runnable() {

                            final _cls1 this$1;
                            final JSONException val$ex;

                            public void run()
                            {
                                onFailure(statusCode, headers, ex, (JSONObject)null);
                            }

            
            {
                this$1 = final__pcls1;
                ex = JSONException.this;
                super();
            }
                        });
                    }
                }

            
            {
                this$0 = JsonHttpResponseHandler.this;
                responseBytes = abyte0;
                statusCode = i;
                headers = aheader;
                super();
            }
            };
            if (!getUseSynchronousMode())
            {
                (new Thread(headers)).start();
                return;
            } else
            {
                headers.run();
                return;
            }
        } else
        {
            onSuccess(statusCode, headers, new JSONObject());
            return;
        }
    }

    protected Object parseResponse(byte abyte0[])
        throws JSONException
    {
        if (abyte0 != null) goto _L2; else goto _L1
_L1:
        abyte0 = null;
_L4:
        return abyte0;
_L2:
        Object obj;
        byte abyte1[];
label0:
        {
            Object obj1 = null;
            abyte0 = getResponseString(abyte0, getCharset());
            abyte1 = abyte0;
            obj = obj1;
            if (abyte0 == null)
            {
                break label0;
            }
            obj = abyte0.trim();
            abyte0 = ((byte []) (obj));
            if (((String) (obj)).startsWith("\uFEFF"))
            {
                abyte0 = ((String) (obj)).substring(1);
            }
            if (!abyte0.startsWith("{"))
            {
                abyte1 = abyte0;
                obj = obj1;
                if (!abyte0.startsWith("["))
                {
                    break label0;
                }
            }
            obj = (new JSONTokener(abyte0)).nextValue();
            abyte1 = abyte0;
        }
        abyte0 = ((byte []) (obj));
        if (obj == null)
        {
            return abyte1;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }
}
