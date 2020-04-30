// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.Intent;
import android.view.View;

// Referenced classes of package com.inponsel.android.v2:
//            KatAppsReplyFormActivity, ProfileOtherUser

class this._cls0
    implements android.view.Activity._cls7
{

    final KatAppsReplyFormActivity this$0;

    public void onClick(View view)
    {
        view = new Intent(KatAppsReplyFormActivity.this, com/inponsel/android/v2/ProfileOtherUser);
        view.putExtra("id_user_view", userkomen);
        startActivityForResult(view, 0);
        overridePendingTransition(0x7f040003, 0x7f040004);
    }

    ()
    {
        this$0 = KatAppsReplyFormActivity.this;
        super();
    }
}
