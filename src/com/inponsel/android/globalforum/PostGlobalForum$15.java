// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.globalforum;

import android.content.DialogInterface;
import android.content.Intent;
import com.inponsel.android.v2.LoginActivity;

// Referenced classes of package com.inponsel.android.globalforum:
//            PostGlobalForum

class this._cls0
    implements android.content.lickListener
{

    final PostGlobalForum this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface = new Intent(PostGlobalForum.this, com/inponsel/android/v2/LoginActivity);
        dialoginterface.putExtra("activity", "main");
        startActivityForResult(dialoginterface, 0);
        overridePendingTransition(0x7f040003, 0x7f040004);
    }

    _cls9()
    {
        this$0 = PostGlobalForum.this;
        super();
    }
}
