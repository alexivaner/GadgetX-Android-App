// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;

import android.util.Log;
import org.apache.http.Header;

// Referenced classes of package com.loopj.android.http:
//            BaseJsonHttpResponseHandler

class this._cls1
    implements Runnable
{

    final l.responseString this$1;

    public void run()
    {
        onFailure(statusCode, headers, throwable, responseString, null);
    }

    l.throwable()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/loopj/android/http/BaseJsonHttpResponseHandler$2

/* anonymous class */
    class BaseJsonHttpResponseHandler._cls2
        implements Runnable
    {

        final BaseJsonHttpResponseHandler this$0;
        final Header val$headers[];
        final String val$responseString;
        final int val$statusCode;
        final Throwable val$throwable;

        public void run()
        {
            try
            {
                final Object jsonResponse = parseResponse(responseString, true);
                postRunnable(new BaseJsonHttpResponseHandler._cls2._cls1());
                return;
            }
            catch (Throwable throwable1)
            {
                Log.d("BaseJsonHttpResponseHandler", "parseResponse thrown an problem", throwable1);
            }
            postRunnable(new BaseJsonHttpResponseHandler._cls2._cls2());
        }

            
            {
                this$0 = final_basejsonhttpresponsehandler;
                responseString = s;
                statusCode = i;
                headers = aheader;
                throwable = Throwable.this;
                super();
            }

        // Unreferenced inner class com/loopj/android/http/BaseJsonHttpResponseHandler$2$1

/* anonymous class */
        class BaseJsonHttpResponseHandler._cls2._cls1
            implements Runnable
        {

            final BaseJsonHttpResponseHandler._cls2 this$1;
            final Object val$jsonResponse;

            public void run()
            {
                onFailure(statusCode, headers, throwable, responseString, jsonResponse);
            }

                    
                    {
                        this$1 = BaseJsonHttpResponseHandler._cls2.this;
                        jsonResponse = obj;
                        super();
                    }
        }

    }

}
