// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import com.inponsel.android.utils.Log;
import com.loopj.android.http.AsyncHttpResponseHandler;
import org.apache.http.Header;

// Referenced classes of package com.inponsel.android.v2:
//            RegisterActivity

class ler extends AsyncHttpResponseHandler
{

    final RegisterActivity this$0;

    public void onFailure(int i, Header aheader[], byte abyte0[], Throwable throwable)
    {
    }

    public void onRetry(int i)
    {
    }

    public void onStart()
    {
    }

    public void onSuccess(int i, Header aheader[], byte abyte0[])
    {
        Log.e("responseHeadNews", new String(abyte0));
    }

    ler()
    {
        this$0 = RegisterActivity.this;
        super();
    }
}
