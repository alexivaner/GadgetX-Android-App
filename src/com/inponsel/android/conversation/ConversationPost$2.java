// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.conversation;

import android.app.AlertDialog;
import android.view.View;

// Referenced classes of package com.inponsel.android.conversation:
//            ConversationPost

class val.dialog
    implements android.view.r
{

    final ConversationPost this$0;
    private final AlertDialog val$dialog;

    public void onClick(View view)
    {
        val$dialog.show();
    }

    ()
    {
        this$0 = final_conversationpost;
        val$dialog = AlertDialog.this;
        super();
    }
}
