// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.conversation;

import android.content.DialogInterface;
import android.content.Intent;
import com.inponsel.android.v2.RegisterActivity;

// Referenced classes of package com.inponsel.android.conversation:
//            ConversationDetailActivity

class this._cls0
    implements android.content.r
{

    final ConversationDetailActivity this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface = new Intent(ConversationDetailActivity.this, com/inponsel/android/v2/RegisterActivity);
        startActivity(dialoginterface);
    }

    ()
    {
        this$0 = ConversationDetailActivity.this;
        super();
    }
}
