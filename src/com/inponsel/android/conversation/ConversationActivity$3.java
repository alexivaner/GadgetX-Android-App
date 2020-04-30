// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.conversation;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

// Referenced classes of package com.inponsel.android.conversation:
//            ConversationActivity

class this._cls0
    implements android.view.nversationActivity._cls3
{

    final ConversationActivity this$0;

    public void onClick(View view)
    {
        btnRefresh.setVisibility(8);
        pop_txt_empty.setVisibility(8);
        TimelineTask();
    }

    ()
    {
        this$0 = ConversationActivity.this;
        super();
    }
}
