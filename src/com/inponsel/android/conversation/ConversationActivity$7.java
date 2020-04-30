// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.conversation;

import android.content.Intent;
import android.view.View;

// Referenced classes of package com.inponsel.android.conversation:
//            ConversationActivity, ConversationPost

class this._cls0
    implements android.view.nversationActivity._cls7
{

    final ConversationActivity this$0;

    public void onClick(View view)
    {
        view = new Intent(ConversationActivity.this, com/inponsel/android/conversation/ConversationPost);
        view.putExtra("from", "apps");
        startActivityForResult(view, 0);
        overridePendingTransition(0x7f040003, 0x7f040004);
    }

    ()
    {
        this$0 = ConversationActivity.this;
        super();
    }
}
