// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.conversation;

import android.content.Intent;
import android.view.View;
import com.inponsel.android.v2.ProfileOtherUser;

// Referenced classes of package com.inponsel.android.conversation:
//            ConversationActivity

class val.tl_username
    implements android.view.versationActivity._cls13
{

    final ConversationActivity this$0;
    private final String val$tl_username;

    public void onClick(View view)
    {
        view = new Intent(ConversationActivity.this, com/inponsel/android/v2/ProfileOtherUser);
        view.putExtra("id_user_view", val$tl_username);
        startActivityForResult(view, 0);
        overridePendingTransition(0x7f040003, 0x7f040004);
    }

    ()
    {
        this$0 = final_conversationactivity;
        val$tl_username = String.this;
        super();
    }
}
