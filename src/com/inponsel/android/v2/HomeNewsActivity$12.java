// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inponsel.android.v2;

import android.content.Intent;
import android.view.View;
import com.inponsel.android.favorit.LanggananBeritaAll;
import com.inponsel.android.utils.UserFunctions;

// Referenced classes of package com.inponsel.android.v2:
//            HomeNewsActivity

class this._cls0
    implements android.view.
{

    final HomeNewsActivity this$0;

    public void onClick(View view)
    {
        if (userFunctions.isUserLoggedIn(getApplicationContext()))
        {
            i = new Intent(getApplicationContext(), com/inponsel/android/favorit/LanggananBeritaAll);
            startActivity(i);
            return;
        } else
        {
            HomeNewsActivity.access$6(HomeNewsActivity.this, str_title_notlogin, "Fitur ini hanya untuk user terdaftar");
            return;
        }
    }

    All()
    {
        this$0 = HomeNewsActivity.this;
        super();
    }
}
