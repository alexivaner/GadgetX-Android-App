// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.DialogInterface;
import com.inponsel.android.utils.UserFunctions;

// Referenced classes of package com.inponsel.android.v2:
//            HomeNewMainActivity

class this._cls0
    implements android.content.Listener
{

    final HomeNewMainActivity this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        if (userFunctions.isUserLoggedIn(getApplicationContext()))
        {
            HomeNewMainActivity.access$5(HomeNewMainActivity.this, "0");
        }
        finish();
    }

    ()
    {
        this$0 = HomeNewMainActivity.this;
        super();
    }
}
