// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.conversation;

import android.content.DialogInterface;
import com.inponsel.android.utils.Log;

// Referenced classes of package com.inponsel.android.conversation:
//            ConversationPost

class this._cls0
    implements android.content.lickListener
{

    final ConversationPost this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        ConversationPost.access$4(ConversationPost.this, ConversationPost.access$3(ConversationPost.this));
        ConversationPost.access$4(ConversationPost.this, ConversationPost.access$5(ConversationPost.this));
        if (i == 0)
        {
            ConversationPost.access$6(ConversationPost.this);
        } else
        {
            ConversationPost.access$7(ConversationPost.this);
        }
        Log.e("startActivityForResult", String.valueOf(-1));
    }

    ()
    {
        this$0 = ConversationPost.this;
        super();
    }
}
