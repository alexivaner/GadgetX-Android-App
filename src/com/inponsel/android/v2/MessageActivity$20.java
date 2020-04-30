// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.widget.ListView;
import com.inponsel.android.adapter.ListChatMessageAdapter;

// Referenced classes of package com.inponsel.android.v2:
//            MessageActivity

class this._cls0
    implements Runnable
{

    final MessageActivity this$0;

    public void run()
    {
        listMessaging.setSelection(chatMsgAdapter.getCount() - 1);
    }

    eAdapter()
    {
        this$0 = MessageActivity.this;
        super();
    }
}
