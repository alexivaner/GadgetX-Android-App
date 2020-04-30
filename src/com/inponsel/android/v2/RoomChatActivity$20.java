// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.DialogInterface;
import android.content.Intent;

// Referenced classes of package com.inponsel.android.v2:
//            RoomChatActivity, RegisterActivity

class this._cls0
    implements android.content.ickListener
{

    final RoomChatActivity this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface = new Intent(RoomChatActivity.this, com/inponsel/android/v2/RegisterActivity);
        startActivityForResult(dialoginterface, 0);
        overridePendingTransition(0x7f040003, 0x7f040004);
    }

    ner()
    {
        this$0 = RoomChatActivity.this;
        super();
    }
}
