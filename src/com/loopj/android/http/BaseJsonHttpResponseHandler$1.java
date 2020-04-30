// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;

import android.util.Log;
import org.apache.http.Header;

// Referenced classes of package com.loopj.android.http:
//            BaseJsonHttpResponseHandler

class val.headers
    implements Runnable
{

    final BaseJsonHttpResponseHandler this$0;
    final Header val$headers[];
    final String val$responseString;
    final int val$statusCode;

    public void run()
    {
        try
        {
            final Object jsonResponse = parseResponse(val$responseString, false);
            postRunnable(new Runnable() {

                final BaseJsonHttpResponseHandler._cls1 this$1;
                final Object val$jsonResponse;

                public void run()
                {
                    onSuccess(statusCode, headers, responseString, jsonResponse);
                }

            
            {
                this$1 = BaseJsonHttpResponseHandler._cls1.this;
                jsonResponse = obj;
                super();
            }
            });
            return;
        }
        catch (final Throwable t)
        {
            Log.d("BaseJsonHttpResponseHandler", "parseResponse thrown an problem", t);
            postRunnable(new Runnable() {

                final BaseJsonHttpResponseHandler._cls1 this$1;
                final Throwable val$t;

                public void run()
                {
                    onFailure(statusCode, headers, t, responseString, null);
                }

            
            {
                this$1 = BaseJsonHttpResponseHandler._cls1.this;
                t = throwable;
                super();
            }
            });
            return;
        }
    }

    _cls2.val.t()
    {
        this$0 = final_basejsonhttpresponsehandler;
        val$responseString = s;
        val$statusCode = i;
        val$headers = _5B_Lorg.apache.http.Header_3B_.this;
        super();
    }
}
