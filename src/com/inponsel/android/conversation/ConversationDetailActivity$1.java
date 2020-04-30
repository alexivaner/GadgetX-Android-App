// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.conversation;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;

// Referenced classes of package com.inponsel.android.conversation:
//            ConversationDetailActivity

class this._cls0 extends WebViewClient
{

    final ConversationDetailActivity this$0;

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        if (s.endsWith("</iframe>") || s.endsWith(".flv") || s.endsWith("wmv") || s.endsWith("avi"))
        {
            webview = new Intent("android.intent.action.VIEW");
            webview.setData(Uri.parse(s));
            startActivity(webview);
            return true;
        }
        if (s != null && s.startsWith("http://"))
        {
            webview.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(s)));
            return true;
        } else
        {
            return false;
        }
    }

    ()
    {
        this$0 = ConversationDetailActivity.this;
        super();
    }
}
