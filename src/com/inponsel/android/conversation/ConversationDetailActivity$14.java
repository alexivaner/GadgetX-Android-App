// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.conversation;


// Referenced classes of package com.inponsel.android.conversation:
//            ConversationDetailActivity

class this._cls0
    implements Runnable
{

    final ConversationDetailActivity this$0;

    public void run()
    {
        (new tHits(ConversationDetailActivity.this)).execute(new Void[0]);
    }

    tHits()
    {
        this$0 = ConversationDetailActivity.this;
        super();
    }
}
