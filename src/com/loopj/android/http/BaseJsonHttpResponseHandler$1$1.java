// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;

import android.util.Log;
import org.apache.http.Header;

// Referenced classes of package com.loopj.android.http:
//            BaseJsonHttpResponseHandler

class val.jsonResponse
    implements Runnable
{

    final val.jsonResponse this$1;
    final Object val$jsonResponse;

    public void run()
    {
        onSuccess(statusCode, headers, responseString, val$jsonResponse);
    }

    l.headers()
    {
        this$1 = final_headers;
        val$jsonResponse = Object.this;
        super();
    }

    // Unreferenced inner class com/loopj/android/http/BaseJsonHttpResponseHandler$1

/* anonymous class */
    class BaseJsonHttpResponseHandler._cls1
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
                Object obj = parseResponse(responseString, false);
                postRunnable(((BaseJsonHttpResponseHandler._cls1._cls1) (obj)). new BaseJsonHttpResponseHandler._cls1._cls1());
                return;
            }
            catch (final Throwable t)
            {
                Log.d("BaseJsonHttpResponseHandler", "parseResponse thrown an problem", t);
                postRunnable(new BaseJsonHttpResponseHandler._cls1._cls2());
                return;
            }
        }

            
            {
                this$0 = final_basejsonhttpresponsehandler;
                responseString = s;
                statusCode = i;
                headers = _5B_Lorg.apache.http.Header_3B_.this;
                super();
            }

        // Unreferenced inner class com/loopj/android/http/BaseJsonHttpResponseHandler$1$2

/* anonymous class */
        class BaseJsonHttpResponseHandler._cls1._cls2
            implements Runnable
        {

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
        }

    }

}
