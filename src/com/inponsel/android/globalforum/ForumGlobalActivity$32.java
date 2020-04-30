// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.globalforum;

import android.content.Intent;
import android.view.View;
import com.inponsel.android.v2.ProfileOtherUser;

// Referenced classes of package com.inponsel.android.globalforum:
//            ForumGlobalActivity

class val.tl_username
    implements android.view.umGlobalActivity._cls32
{

    final ForumGlobalActivity this$0;
    private final String val$tl_username;

    public void onClick(View view)
    {
        view = new Intent(ForumGlobalActivity.this, com/inponsel/android/v2/ProfileOtherUser);
        view.putExtra("id_user_view", val$tl_username);
        startActivityForResult(view, 0);
        overridePendingTransition(0x7f040003, 0x7f040004);
    }

    ()
    {
        this$0 = final_forumglobalactivity;
        val$tl_username = String.this;
        super();
    }
}
