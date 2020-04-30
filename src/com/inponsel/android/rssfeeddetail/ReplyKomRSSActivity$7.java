// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.rssfeeddetail;

import android.content.Intent;
import android.view.View;
import com.inponsel.android.v2.ProfileOtherUser;

// Referenced classes of package com.inponsel.android.rssfeeddetail:
//            ReplyKomRSSActivity

class this._cls0
    implements android.view.ReplyKomRSSActivity._cls7
{

    final ReplyKomRSSActivity this$0;

    public void onClick(View view)
    {
        view = new Intent(ReplyKomRSSActivity.this, com/inponsel/android/v2/ProfileOtherUser);
        view.putExtra("id_user_view", user_name_to);
        startActivityForResult(view, 0);
        overridePendingTransition(0x7f040003, 0x7f040004);
    }

    ()
    {
        this$0 = ReplyKomRSSActivity.this;
        super();
    }
}
