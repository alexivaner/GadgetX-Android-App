// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.Intent;
import android.view.View;

// Referenced classes of package com.inponsel.android.v2:
//            HomeNewMainActivity, InboxMessageActivity

class this._cls0
    implements android.view.ctivity._cls33
{

    final HomeNewMainActivity this$0;

    public void onClick(View view)
    {
        i = new Intent(getApplicationContext(), com/inponsel/android/v2/InboxMessageActivity);
        startActivityForResult(i, 0);
        overridePendingTransition(0x7f040003, 0x7f040004);
    }

    ()
    {
        this$0 = HomeNewMainActivity.this;
        super();
    }
}
