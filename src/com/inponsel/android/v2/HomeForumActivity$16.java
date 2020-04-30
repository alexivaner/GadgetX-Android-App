// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.Intent;
import android.view.View;

// Referenced classes of package com.inponsel.android.v2:
//            HomeForumActivity, ProfileOtherUser

class val.tl_username
    implements android.view.ctivity._cls16
{

    final HomeForumActivity this$0;
    private final String val$tl_username;

    public void onClick(View view)
    {
        view = new Intent(HomeForumActivity.this, com/inponsel/android/v2/ProfileOtherUser);
        view.putExtra("id_user_view", val$tl_username);
        startActivityForResult(view, 0);
        overridePendingTransition(0x7f040003, 0x7f040004);
    }

    ()
    {
        this$0 = final_homeforumactivity;
        val$tl_username = String.this;
        super();
    }
}
