// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.details;

import android.content.Intent;
import android.view.View;
import com.inponsel.android.v2.ProfileOtherUser;

// Referenced classes of package com.inponsel.android.details:
//            KomentarTwitter

class val.user_name
    implements android.view.er
{

    final KomentarTwitter this$0;
    private final String val$user_name;

    public void onClick(View view)
    {
        view = new Intent(KomentarTwitter.this, com/inponsel/android/v2/ProfileOtherUser);
        view.putExtra("id_user_view", val$user_name);
        startActivityForResult(view, 0);
        overridePendingTransition(0x7f040003, 0x7f040004);
    }

    ()
    {
        this$0 = final_komentartwitter;
        val$user_name = String.this;
        super();
    }
}
