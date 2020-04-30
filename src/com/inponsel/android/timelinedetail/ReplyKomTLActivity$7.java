// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.timelinedetail;

import android.content.Intent;
import android.view.View;
import com.inponsel.android.v2.ProfileOtherUser;

// Referenced classes of package com.inponsel.android.timelinedetail:
//            ReplyKomTLActivity

class this._cls0
    implements android.view.l.ReplyKomTLActivity._cls7
{

    final ReplyKomTLActivity this$0;

    public void onClick(View view)
    {
        view = new Intent(ReplyKomTLActivity.this, com/inponsel/android/v2/ProfileOtherUser);
        view.putExtra("id_user_view", user_name_to);
        startActivityForResult(view, 0);
        overridePendingTransition(0x7f040003, 0x7f040004);
    }

    ()
    {
        this$0 = ReplyKomTLActivity.this;
        super();
    }
}
