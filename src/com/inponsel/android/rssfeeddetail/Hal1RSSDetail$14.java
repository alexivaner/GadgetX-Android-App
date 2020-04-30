// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.rssfeeddetail;


// Referenced classes of package com.inponsel.android.rssfeeddetail:
//            Hal1RSSDetail

class this._cls0
    implements Runnable
{

    final Hal1RSSDetail this$0;

    public void run()
    {
        (new tHits(Hal1RSSDetail.this)).execute(new Void[0]);
    }

    tHits()
    {
        this$0 = Hal1RSSDetail.this;
        super();
    }
}
