// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;

import android.util.Log;
import org.apache.http.Header;

// Referenced classes of package com.loopj.android.http:
//            TextHttpResponseHandler

public abstract class BaseJsonHttpResponseHandler extends TextHttpResponseHandler
{

    private static final String LOG_TAG = "BaseJsonHttpResponseHandler";

    public BaseJsonHttpResponseHandler()
    {
        this("UTF-8");
    }

    public BaseJsonHttpResponseHandler(String s)
    {
        super(s);
    }

    public final void onFailure(final int statusCode, final Header headers[], final String responseString, final Throwable throwable)
    {
        if (responseString != null)
        {
            headers = new Runnable() {

                final BaseJsonHttpResponseHandler this$0;
                final Header val$headers[];
                final String val$responseString;
                final int val$statusCode;
                final Throwable val$throwable;

                public void run()
                {
                    try
                    {
                        Object obj = parseResponse(responseString, true);
                        postRunnable(((_cls1) (obj)). new Runnable() {

                            final _cls2 this$1;
                            final Object val$jsonResponse;

                            public void run()
                            {
                                onFailure(statusCode, headers, throwable, responseString, jsonResponse);
                            }

            
            {
                this$1 = final__pcls2;
                jsonResponse = Object.this;
                super();
            }
                        });
                        return;
                    }
                    catch (Throwable throwable1)
                    {
                        Log.d("BaseJsonHttpResponseHandler", "parseResponse thrown an problem", throwable1);
                    }
                    postRunnable(new Runnable() {

                        final _cls2 this$1;

                        public void run()
                        {
                            onFailure(statusCode, headers, throwable, responseString, null);
                        }

            
            {
                this$1 = _cls2.this;
                super();
            }
                    });
                }

            
            {
                this$0 = BaseJsonHttpResponseHandler.this;
                responseString = s;
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
            onFailure(statusCode, headers, throwable, null, null);
            return;
        }
    }

    public abstract void onFailure(int i, Header aheader[], Throwable throwable, String s, Object obj);

    public final void onSuccess(final int statusCode, final Header headers[], final String responseString)
    {
        if (statusCode != 204)
        {
            headers = new Runnable() {

                final BaseJsonHttpResponseHandler this$0;
                final Header val$headers[];
                final String val$responseString;
                final int val$statusCode;

                public void run()
                {
                    try
                    {
                        Object obj = parseResponse(responseString, false);
                        postRunnable(((_cls1) (obj)). new Runnable() {

                            final _cls1 this$1;
                            final Object val$jsonResponse;

                            public void run()
                            {
                                onSuccess(statusCode, headers, responseString, jsonResponse);
                            }

            
            {
                this$1 = final__pcls1;
                jsonResponse = Object.this;
                super();
            }
                        });
                        return;
                    }
                    catch (Throwable throwable)
                    {
                        Log.d("BaseJsonHttpResponseHandler", "parseResponse thrown an problem", throwable);
                        postRunnable(throwable. new Runnable() {

                            final _cls1 this$1;
                            final Throwable val$t;

                            public void run()
                            {
                                onFailure(statusCode, headers, t, responseString, null);
                            }

            
            {
                this$1 = final__pcls1;
                t = Throwable.this;
                super();
            }
                        });
                        return;
                    }
                }

            
            {
                this$0 = BaseJsonHttpResponseHandler.this;
                responseString = s;
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
            onSuccess(statusCode, headers, null, null);
            return;
        }
    }

    public abstract void onSuccess(int i, Header aheader[], String s, Object obj);

    protected abstract Object parseResponse(String s, boolean flag)
        throws Throwable;
}
