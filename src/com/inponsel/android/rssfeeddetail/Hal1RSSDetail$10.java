// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.rssfeeddetail;

import android.content.Intent;
import android.net.Uri;
import android.view.View;

// Referenced classes of package com.inponsel.android.rssfeeddetail:
//            Hal1RSSDetail

class this._cls0
    implements android.view.ner
{

    final Hal1RSSDetail this$0;

    public void onClick(View view)
    {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(rss_srclink)));
    }

    _cls9()
    {
        this$0 = Hal1RSSDetail.this;
        super();
    }
}
