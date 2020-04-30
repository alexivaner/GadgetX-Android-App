// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.timelinedetail;


// Referenced classes of package com.inponsel.android.timelinedetail:
//            Hal1TLDetailActivity

class this._cls0
    implements Runnable
{

    final Hal1TLDetailActivity this$0;

    public void run()
    {
        (new tHits(Hal1TLDetailActivity.this)).execute(new Void[0]);
    }

    tHits()
    {
        this$0 = Hal1TLDetailActivity.this;
        super();
    }
}
